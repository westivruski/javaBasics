package com.weshodaj;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class ContactList implements Serializable {
    public static final long serialVersionUID = 1;
    private String name;

    private LinkedList <Contact> contacts;



    public ContactList(String name) {
        this.name = name;
        contacts = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void deleteContact(String name,String surname){

        Contact contact = getContact(name,surname);
        contacts.remove(contact);
    }

    public Contact getContact(String name,String surname){
        for(Contact checkedContact : contacts){
            if(checkedContact.getName().equals(name) && checkedContact.getSurname().equals(surname)){
                return checkedContact;
            }
        }
        return null;
    }

    public int getNrOfContacts(){
        return contacts.size();
    }

    public void printContacts(){
        int nr = 1;
        for(Contact contact : contacts){
            System.out.println(nr+". "+contact.getName()+" "+contact.getSurname()+", tel : "+contact.getNumber());
            nr++;
        }
    }
}
