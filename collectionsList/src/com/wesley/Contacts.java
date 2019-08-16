package com.wesley;

import java.util.ArrayList;

public class Contacts {
    private String contactName;
    private String phoneNumber;

    public Contacts(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacts createContact (String contactName, String phoneNumber)  {
        return new Contacts(contactName, phoneNumber);
    }

    /*
    public ArrayList<String> getContacts() {
        return contacts;
    }

    //finds an item and returns its integer position
    private int findItem(String searchItem){
        return contacts.indexOf(searchItem);
    }
    //second way to do it more complicated
    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String contactName) {
        for(int i=0; i<myContacts.size();i++){
            Contacts contacts = this.myContacts.get(i);
            if(contacts.getContactName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }




    //print the list of all items
    public void printCList(){
        System.out.println("There are "+contacts.size()+"items in your arrayList");
        for(int i=0; i<contacts.size(); i++){
            System.out.println((i+1)+"."+contacts.get(i));
        }
    }

    //adding items to the arraylist
    public void addCItem(String item){
        contacts.add(item);
    }

    //modify items with 2 methods
    public void modifyCItem(String currentItem, String newItem){
     int position = findItem(currentItem);
     if(position >=0){
         modifyCItem(position, newItem);
     }
    }
    private void modifyCItem(int position, String newItem){
     contacts.set(position, newItem);
        System.out.println("Contact with position"+(position+1)+"has been modified");
    }

    //remove items with 2 methods
    public void removeCItem(String item){
        int position = findItem(item);
        if(position >=0){
            removeCItem(position);
        }
    }
    private void removeCItem(int position){
        contacts.remove(position);
    }

    //search and find for an string
    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position>=0){
            return true;
        }
        return false;
    }
    */
}
