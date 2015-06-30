/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.Contact;
import account.contact.ContactDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author konst
 */
@Component
public class ContactDao {

    private List<Contact> contactList = new ArrayList<>();
        
    
    public void addContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setBirthDate(contactDTO.getBirthDate());
        contact.setHobbies(contactDTO.getHobbies());
        contact.setPlaces(contactDTO.getPlaces());

        contactList.add(contact);

    }

    public void deleteContact(ContactDTO contactDTO) throws Exception {

        if (contactList.isEmpty()) {
            throw new Exception("Contact list is empty, nothing to delete!");
        }

        for (Contact contact : contactList) {
            if (contact.hashCode() == contactDTO.hashCode()) {
                contactList.remove(contact);
                
                System.out.println("Contact deleted!");
                break;
            }
        }
    }

    public void addFriendShip(Contact contact1, Contact contact2) {
        
        
    }

    public void removeFriendShip(Contact contact1, Contact contact2) {
    }

    public List<Contact> getAllContacts() {

        if (contactList.isEmpty()) {
            return null;
        }

        return contactList;
    }

}
