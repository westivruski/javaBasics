package com.weshodaj;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainApp {

    private static ContactList manager;
    private static ContactManager contactManager;
    private static boolean exitVariable = false;
    private static boolean firstRun = true;


    public static void main(String[] args) {
       int selection;
        if(firstRun){
            contactManager = new ContactManager();
            firstRun = false;
        }

        while (!exitVariable) {
            Menu.showWelcomeMenu();
            selection = Menu.selectMenu();
            switch (selection) {
                case 1:
                    manageContacts(contactManager);
                    break;
                case 2:
                    manageLists(contactManager);
                    break;
                default:
                    exitApp(contactManager);
                    break;
            }
        }
    }

    public static void manageLists(ContactManager manager){
        int selection;
        Menu.showListsMenu();
        selection = Menu.selectMenu();
        switch (selection){
            case 1:
                manager.createNewList();
                break;
            case 2:
                manager.deleteExistingList();
                break;
            case 3:
                manager.printContactList();
                break;

        }

    }

    public static void manageContacts(ContactManager manager) {
        int selection;
        Menu.showContactMenu();
        selection = Menu.selectMenu();
        switch (selection) {
            case 1:
                manager.addNewContact();
                break;
            case 2:
               manager.deleteExistingContact();
               break;
            case 3:
                manager.printListOfContacts();
            default:
                break;
        }
    }

    public static void exitApp(ContactManager manager){
        System.out.println("Aplikacioni u mbull");
        try(FileOutputStream fos = new FileOutputStream("Contact.bin")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ContactManager.getContactsList());
        }catch (Exception e){
            e.printStackTrace();
        }
        exitVariable = true;
    }
}