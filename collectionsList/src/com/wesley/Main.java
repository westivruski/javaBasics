package com.wesley;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {
        boolean quit = false;
        int choise = 5;
        printMainMenu();
        while(!quit){
            System.out.println("Please select a number from the list below : ");
            choise = sc.nextInt();
            sc.nextLine();
            switch (choise){
                case 1:
                    searchContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    modifyContact();
                    break;
                case 5:
                    break;
                case 6:
                    printMainMenu();
                    break;
                case 7:
                    break;
                case 0:
                    quit=true;
                    break;
            }
        }




    }
    public static void printMainMenu(){
        System.out.println("\nPress 1 to print contact list"+
                "\nPress 2 to add a new contact" +
                "\nPress 3 to delete a new contact" +
                "\nPress 4 to modify a contact" +
                "\nPress 5 to search for a contact" +
                "\nPress 6 to print main menu" +
                "\nPress 0 to quit app" +
                "\nCOPPY ARRAYLIST TO NEW ARRAYLIST NR7");
    }

  /* old add contacts
    public static void addContact(){
        System.out.println("Enter the name of the contact you want to add :");
        contacts.addCItem(sc.nextLine());
    }
*/
  private static void addNewContact() {
      System.out.println("Enter new contact name : ");
      String name = sc.nextLine();
      System.out.println("Enter new phone number : ");
      String phone = sc.nextLine();
      Contacts newContacts = Contacts.createContact(name, phone);
      if(mobilePhone.addNewContact(newContacts)){
          System.out.println("New contact added : name :"+ name+ " phone :  "+ phone);
      }else {
          System.out.println("Cannot add "+ name+ " is on list" );
      }
  }

    private  static void removeContact(){
        System.out.println("Enter the name of the contact you want to delete");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.searchContacts(name);
        if(existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContact)) {
            System.out.println("Contact was deleted");
        }else {
            System.out.println("Contact not deleted");
        }
    }

    private static void modifyContact(){
        System.out.println("Enter the contact you want to modify");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.searchContacts(name);
       if(existingContact == null) {
           System.out.println("no contacts found to modify");
           return;
       }

        System.out.println("Enter contact name ");
        String newName = sc.nextLine();
        System.out.println("Enter new contact phone number : ");
        String newPhone = sc.nextLine();
        Contacts newContact = Contacts.createContact(newName, newPhone);
        if(mobilePhone.modifyContact(existingContact, newContact)) {
            System.out.println("Updated succesfull");
        }else {
            System.out.println("Not updated successfull");
        }
    }

    private static void searchContact(){
        System.out.println("Enter name of contact");
        String name = sc.nextLine();
        Contacts existingContact = mobilePhone.searchContacts(name);
        if (existingContact == null) {
            System.out.println("Name not found");
            return;
        }
        System.out.println("Contact "+ existingContact.getContactName()+"  phone : "+existingContact.getPhoneNumber()+"Found yoooo" );
    }
        /*
    public static void findContact(){
        System.out.println("Enter the name of the contact you want to search for :");
        String searchItem = sc.nextLine();
        if(contacts.onFile(searchItem)){
            System.out.println("Contact"+searchItem+"found.");
        }
        else{
            System.out.println("Contact"+searchItem+"not found.");
        }
    }
        */
        /*

    public static void processArrayList() {
       //adding entire content to another arraylist
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(contacts.getContacts());

        //adding another way to coppying this arraylist things
        ArrayList<String> nextArray = new ArrayList<String>(contacts.getContacts());

        //annotehr way to coppy to array from arraylist
        String[] myArray = new String[contacts.getContacts().size()];
        myArray = contacts.getContacts().toArray(myArray);


    }
        */
}