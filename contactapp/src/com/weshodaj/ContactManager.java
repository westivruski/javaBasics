package com.weshodaj;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ContactManager {
    private static LinkedList<ContactList> contakte;

    public ContactManager(){
        contakte = new LinkedList<>();
        try(FileInputStream fis = new FileInputStream("Contact.bin")){
            ObjectInputStream ois = new ObjectInputStream(fis);
            contakte = (LinkedList<ContactList>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void createNewList(){
        System.out.println("Shkruani emrin e Listes qe doni te krijoni");
        String name = (new Scanner(System.in).nextLine()).toLowerCase();
        contakte.add(new ContactList(name));
        System.out.println("Emri i listes eshte : " + name.toUpperCase());
    }

    public void addNewContact(){
        Scanner sc = new Scanner(System.in);
        String veprimi = "";
        System.out.println("\nEmri i kontaktit qe doni te shtoni eshte ?");
        String name = sc.nextLine().toLowerCase();
        System.out.println("Mbiemri i kontaktit qe doni te shtoni eshte ?");
        String surname = sc.nextLine().toLowerCase();
        System.out.println("Numri i kontaktit qe doni te shtoni eshte ?");
        int number = sc.nextInt();
        sc.nextLine();
        Contact newContact = new Contact(name,surname,number);

        System.out.println("Ne cilen liste doni ta shtoni kete kontakt?");
        String listName = sc.nextLine();
        ContactList contactList = getContactList(listName);

        contactList.addContact(newContact);
        System.out.println(newContact.getName()+" "+newContact.getSurname()+". tel : "+ newContact.getNumber());

    }

    public void deleteExistingContact() {

        Scanner sc = new Scanner(System.in);
        String veprimi = "";
        System.out.println("Nga cila liste deshironi te fshini kontaktin ?");
        String listName = sc.nextLine().toLowerCase();
        ContactList contactList = getContactList(listName);
           for (ContactList checkedContact : contakte) {
            if (checkedContact.getName().equals(listName)) {
                System.out.println("Shkruani emrin e kontaktit qe doni te fshini : ");
                String name = sc.nextLine();
                System.out.println("Shkruani mbiemrin e kontaktit qe doni te fshini : ");
                String surname = sc.nextLine();
                contactList.deleteContact(name, surname);
            } else {
                System.out.println("Emri nuk eshte i sakte, ju lutem shruani emrin e Listes sakte");
                deleteExistingContact();

            }
        }
    }


 /*   public void deleteExistingList() {
        Scanner sc = new Scanner(System.in);
        String veprimi = "";
        System.out.println("Emri i listes qe doni te fshini ?");
        String listName = sc.nextLine().toLowerCase();
        ContactList contactList = getContactList(listName);
//            (int i=0; i < contakte.size();i++){
            if (contactList!=null) {
                contakte.remove(contactList);
                System.out.println(contactList + " u fshi");
            } else{
                System.out.println("Emri i Listes nuk eshte i sakte, fusni emrin e sakte!");
                deleteExistingList();
            }
        System.out.println("");
    }
    */


    public void deleteExistingList() {

        Scanner sc = new Scanner(System.in);
        String veprimi = "";
        System.out.println("Emri i listes qe doni te fshini ?");
        String listName = sc.nextLine().toLowerCase();
        ContactList contactList;

        try{
              contactList = getContactList(listName);
                contakte.remove(contactList);
                System.out.println(contactList + " u fshi");
            }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }













    public static ContactList getContactList(String listName){
      ContactList contactList = null;
      for(int i=0; i<contakte.size(); i++){
          if(listName.equals(contakte.get(i).getName())){
              contactList = contakte.get(i);
              i = contakte.size();
          }
      }
      return contactList;
    }

    public void printContactList(){
        int nr = 1;
        for(ContactList contactList: contakte){
            System.out.println(nr+ "Emri i Listes : "+ contactList.getName().toUpperCase()+ " "+ contactList.getNrOfContacts());
        }
    }

    public void printListOfContacts(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Zgjidhni Listen ku jane kontaktet qe doni ti shfaqni ");
        String listName = sc.nextLine().toLowerCase();
        ContactList contactList = getContactList(listName);
        contactList.printContacts();
    }

    public static LinkedList<ContactList> getContactsList(){
        return contakte;
    }
}
