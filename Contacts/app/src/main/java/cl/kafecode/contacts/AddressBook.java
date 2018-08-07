package cl.kafecode.contacts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddressBook {

    private static AddressBook sharedInstance = new AddressBook();

    private ArrayList<Contact> mContacts;

    //Para pruebas
    Contact c1 = new Contact("Felipe",
            "Hernandez",
            "Socrates 444",
            "Ñuñoa",
            "780000");

    Contact c2 = new Contact("Karen",
            "Iglesias",
            "Socrates 777",
            "Ñuñoa",
            "780001");

    Contact c3 = new Contact("Marcela",
            "Ticona",
            "Chillan 676",
            "Chillan",
            "770001");
    //Fin Para pruebas


    private AddressBook(){
        mContacts = new ArrayList<Contact>();

        //Para pruebas
        mContacts.add(c1);
        mContacts.add(c2);
        mContacts.add(c3);
    }

    public static AddressBook getInstance(){
        return  sharedInstance;
    }

    public ArrayList<Contact> getContacts() {
        return mContacts;
    }
}
