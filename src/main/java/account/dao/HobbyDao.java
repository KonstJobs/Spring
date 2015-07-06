/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.Contact;
import account.hobby.Hobby;
import account.hobby.HobbyDTO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author konst
 */
@Component
public class HobbyDao {

    private Set<Hobby> hoobyList = new HashSet<>();

    @Autowired
    private ContactDao contactDao;

    public void addHobby(HobbyDTO hobbyDTO) {

        Hobby hobby = new Hobby();
        hobby.setTitle(hobbyDTO.getTitle());
        hobby.setDescription(hobbyDTO.getDescription());

        hoobyList.add(hobby);

    }

    public Set<Contact> getAllContactsWithHobby(HobbyDTO hobbyDTO) {

        Set<Contact> contactsWithHobby = new HashSet<>();
        List<Contact> contacts = contactDao.getAllContacts();
        String hobbyTitle = hobbyDTO.getTitle();

        for (Contact contact : contacts) {
            Set<Hobby> hobbies = contact.getHobbies();

            for (Hobby hobby : hobbies) {
                if (hobby.getTitle().equals(hobbyTitle)) {
                    contactsWithHobby.add(contact);
                    break;
                }
            }
        }

        return contactsWithHobby;
    }
}
