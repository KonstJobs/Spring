/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.contact.Contact;
import account.contact.ContactDTO;
import account.dao.ContactDao;
import account.dao.HobbyDao;
import account.dao.MessageDao;
import account.dao.PlaceDao;
import account.hobby.HobbyDTO;
import accountMessage.Message;
import account.place.PlaceDTO;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author konst
 */
@Service
public class JavaContactService {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private MessageDao messageDao;

    public void createContact(ContactDTO contactDTO) {
        contactDao.addContact(contactDTO);
    }

    public List<Contact> getContacts() {
        return contactDao.getAllContacts();
    }

    public void deleteContact(ContactDTO contactDTO) throws Exception {
        contactDao.deleteContact(contactDTO);
    }

    public void addHobby(HobbyDTO hobbyDTO) {
        hobbyDao.addHobby(hobbyDTO);
    }

    public void addPlace(PlaceDTO placeDTO) {
        placeDao.addPlace(placeDTO);
    }

    public void addFriendship(ContactDTO contactDTO1, ContactDTO contactDTO2) {
        contactDao.addFriendShip(contactDTO1, contactDTO2);
    }

    public Set<Contact> getFriendList(Contact contact) {

        return null;
    }

    public List<Message> getConversation() {

        return null;
    }

}
