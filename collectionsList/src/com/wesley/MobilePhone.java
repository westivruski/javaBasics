package com.wesley;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contacts) {
        if(findContact(contacts.getContactName()) >=0){
            System.out.println("Contact alredy exists");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }

    public boolean modifyContact(Contacts oldContacts, Contacts newContacts) {
        int foundPosition = findContact(oldContacts);
        if(foundPosition <0) {
            System.out.println(oldContacts.getContactName()+ " contact not found");
            return false;
        }else if (findContact(newContacts.getContactName()) != -1) {
            System.out.println("no duplicates yoo");
            return false;
        }
        this.myContacts.set(foundPosition, newContacts);
        System.out.println(oldContacts.getContactName()+" was replaced with "+ newContacts.getContactName());
        return true;
    }

    public boolean removeContact (Contacts contacts){
        int foundPosition = findContact(contacts);
        if(foundPosition <0) {
            System.out.println("contact " +contacts.getContactName()+" not found" );
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contacts.getContactName()+ "was deleted from contacts");
        return true;
    }

    public String searchContact(Contacts contacts){
        if(findContact(contacts)>=0) {
            return contacts.getContactName();
        }
        return null;
    }
    public Contacts searchContacts(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact list");
        for(int i=0; i<myContacts.size(); i++){
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getContactName()+ "  "+
                    this.myContacts.get(i).getPhoneNumber()
                    );
        }
    }

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


}
