/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.test.dao;

import account.contact.ContactDTO;
import account.dao.ContactDao;
import account.hobby.HobbyDTO;
import account.place.PlaceDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 *
 * @author konst
 */
@ContextConfiguration(locations = {"classpath:Beans.xml"})
public class ContactDAOTest extends AbstractTestNGSpringContextTests {

    public ContactDAOTest() {
    }

    @Autowired
    private ContactDao contactDao;

    @Test
    public void created_contact_should_be_added_to_contactList() throws Exception {

        ContactDTO contact = createContact1();
        contactDao.addContact(contact);
        List<ContactDTO> allContacts = contactDao.getAllContacts();

        assertTrue("Contact " + contact + " not found in contactList: " + allContacts,
                allContacts.contains(contact));
    }
    
     @Test
    public void getContacts_should_return_all_contacts_in_contactList() throws Exception {

        ContactDTO contact1 = createContact1();
        ContactDTO contact2 = createContact2();
        List<ContactDTO> contacts = new ArrayList<>(asList(contact1, contact2));

        contactDao.addContact(contact1);
        contactDao.addContact(contact2);
        List<ContactDTO> allContacts = contactDao.getAllContacts();

        assertTrue(allContacts.containsAll(contacts));
    }

    @AfterMethod
    public void deleteConatacs() throws Exception {
        List<ContactDTO> contacts = contactDao.getAllContacts();
        for (ContactDTO contact : contacts) {
            contactDao.deleteContact(contact);
        }
    }

    //==========================================================================
    //
    //==========================================================================
    private ContactDTO createContact1() {

        ContactDTO contact1 = new ContactDTO(
                "name1",
                "last name1",
                LocalDate.now(),
                createHobbySet(),
                createPlaceSet(),
                "test@email");

        return contact1;
    }

    private ContactDTO createContact2() {

        ContactDTO contact2 = new ContactDTO(
                "name2",
                "last name2",
                LocalDate.now(),
                createHobbySet(),
                createPlaceSet(),
                "test@emai2");

        return contact2;

    }

    private Set<PlaceDTO> createPlaceSet() {
        PlaceDTO placeDTO1 = new PlaceDTO("description1", "title1", 12346, 65020);
        PlaceDTO placeDTO2 = new PlaceDTO("description2", "title2", 12346.13, 65020.235);
        Set<PlaceDTO> placeSet = new HashSet<>();
        placeSet.add(placeDTO1);
        placeSet.add(placeDTO2);

        return placeSet;
    }

    private Set<HobbyDTO> createHobbySet() {
        HobbyDTO hobbyDTO1 = new HobbyDTO("title1", "title1");
        HobbyDTO hobbyDTO2 = new HobbyDTO("title2", "title2");
        Set<HobbyDTO> hobbySet = new HashSet<>();
        hobbySet.add(hobbyDTO1);
        hobbySet.add(hobbyDTO2);

        return hobbySet;
    }

}
