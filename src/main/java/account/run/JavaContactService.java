/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.contact.ContactDTO;
import account.dao.ContactDao;
import account.dao.HobbyDao;
import account.dao.MessageDao;
import account.dao.PlaceDao;
import account.hobby.HobbyDTO;
import account.place.PlaceDTO;
import account.message.MessageDTO;
import java.util.List;
import java.util.Set;

/**
 *
 * @author konst
 */
public class JavaContactService {

    private ContactDao contactDao;
    private HobbyDao hobbyDao;
    private PlaceDao placeDao;
    private MessageDao messageDao;
    
    
    

    public void createContact(ContactDTO contactDTO) {
    
        System.out.println("1. add new folder");
        
        contactDao.addContact(contactDTO);
    }

    public List<ContactDTO> getContacts() {
        return contactDao.getAllContacts();
    }

    public void deleteContact(ContactDTO contactDTO) {
        try {
            contactDao.deleteContact(contactDTO);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addHobby(HobbyDTO hobbyDTO) {
        hobbyDao.addHobby(hobbyDTO);
    }

    public void addPlace(PlaceDTO placeDTO) {
        placeDao.addPlace(placeDTO);
    }

    public void addFriendship(ContactDTO contactDTO1, ContactDTO contactDTO2) {
        try {
            contactDao.addFriendShip(contactDTO1, contactDTO2);
        } catch (Exception ex) {
            System.out.println("Can't create friendship: " + ex.getMessage());
        }
    }

    public Set<ContactDTO> getFriendList(ContactDTO contactDTO) {
        return contactDao.getFirendList(contactDTO);
    }

    public List<MessageDTO> getConversation(ContactDTO contactDTO1, ContactDTO contactDTO2) {
        return messageDao.getConversation(contactDTO1, contactDTO2);
    }

    public void storeMessage(MessageDTO messageDTO) {
        messageDao.storeMessage(messageDTO);
    }

}
