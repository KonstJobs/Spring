/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.contact.Contact;
import account.contact.ContactDTO;
import account.dao.ContactDao;
import java.util.List;
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

    public void createContact(ContactDTO contactDTO) {
        contactDao.addContact(contactDTO);
    }

    public List<Contact> getContacts() {
        return contactDao.getAllContacts();
    }

    public void deleteContact(ContactDTO contactDTO) throws Exception {
        contactDao.deleteContact(contactDTO);
    }

}
