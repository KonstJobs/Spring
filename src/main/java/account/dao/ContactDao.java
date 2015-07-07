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
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author konst
 */
@Component
public class ContactDao {

    private List<Contact> contactList = new ArrayList<>();

    @Autowired
    private HobbyDao hobbyDao;
    
    public void addContact(ContactDTO contactDTO) {

        String email = contactDTO.getEmail();
        boolean isContactPresent = checkThatContactCreated(email);

        if (contactList.isEmpty() || !isContactPresent) {

            Contact contact = new Contact();
            contact.setFirstName(contactDTO.getFirstName());
            contact.setLastName(contactDTO.getLastName());
            contact.setBirthDate(contactDTO.getBirthDate());
            contact.setHobbies(contactDTO.getHobbies());
            contact.setPlaces(contactDTO.getPlaces());
            contact.setEmail(email);

            contactList.add(contact);
            System.out.println("Added contact with email: " + email);
        } else {
            System.out.println("Contact with email " + email + " has allready created");
        }
    }

    public void deleteContact(ContactDTO contactDTO) throws Exception {

        if (contactList.isEmpty()) {
            throw new Exception("Contact list is empty, nothing to delete!");
        }

        for (Contact contact : contactList) {

            String email = contactDTO.getEmail();
            if (contact.getEmail().equals(email)) {
                contactList.remove(contact);

                System.out.println("Contact with email " + email + " deleted!");
                break;
            }
        }
    }

    public void addFriendShip(ContactDTO contactDTO1, ContactDTO contactDTO2) throws Exception {

        Contact contact1 = getContactWithEmail(contactDTO1.getEmail());
        Contact contact2 = getContactWithEmail(contactDTO2.getEmail());

        if (contact1 == null) {
            throw new Exception("Contact " + contact1 + "has not been created!");
        }

        if (contact2 == null) {
            throw new Exception("Contact " + contact1 + "has not been created!");
        }

        contact1.setFriend(contact2);
        contact2.setFriend(contact1);

    }

    public void removeFriendShip(Contact contact1, Contact contact2) {

    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    private boolean checkThatContactCreated(String email) {

        return contactList.stream().anyMatch((contactList1)
                -> (contactList1.getEmail().equalsIgnoreCase(email)));
    }

    public Contact getContactWithEmail(String email) {

        for (Contact contact : contactList) {
            String e_mail = contact.getEmail();
            if (e_mail.equals(email)) {
                return contact;
            }
        }

        System.out.println("Contact with email '" + email + "' not found!");
        return null;
    }

    public Set<Contact> getFirendList(ContactDTO contactDTO) {
        String email = contactDTO.getEmail();
        Contact contact = getContactWithEmail(email);
        return contact.getFriends();
    }
}
