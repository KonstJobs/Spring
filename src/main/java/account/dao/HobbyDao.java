/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.ContactDTO;
import account.hobby.Hobby;
import account.hobby.HobbyDTO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author konst
 */
public class HobbyDao {

    private Set<Hobby> hoobyList = new HashSet<>();
    private ContactDao contactDao;

    public void addHobby(HobbyDTO hobbyDTO) {

        Hobby hobby = new Hobby();
        hobby.setTitle(hobbyDTO.getTitle());
        hobby.setDescription(hobbyDTO.getDescription());

        hoobyList.add(hobby);

    }

    public Set<ContactDTO> getAllContactsWithHobby(HobbyDTO hobbyDTO) {

        Set<ContactDTO> contactsWithHobby = new HashSet<>();
        List<ContactDTO> contacts = contactDao.getAllContacts();

        String hobbyTitle = hobbyDTO.getTitle();

        for (ContactDTO contact : contacts) {
            Set<HobbyDTO> hobbies = contact.getHobbies();

            for (HobbyDTO hobby : hobbies) {
                if (hobby.getTitle().equals(hobbyTitle)) {
                    contactsWithHobby.add(contact);
                    break;
                }
            }
        }

        return contactsWithHobby;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

}
