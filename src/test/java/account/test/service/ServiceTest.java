package account.test.service;

import account.contact.ContactDTO;
import account.dao.ContactDao;
import account.hobby.HobbyDTO;
import account.message.MessageDTO;
import account.place.PlaceDTO;
import account.run.JavaContactService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author konst
 */
@ContextConfiguration(locations = {"classpath:Beans.xml"})
public class ServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private JavaContactService service;

    @Test
    public void created_contact_should_be_added_to_contactList() throws Exception {

        ContactDTO contact = createContact1();
        service.createContact(contact);
        List<ContactDTO> allContacts = contactDao.getAllContacts();

        assertTrue("Contact " + contact + " not found in contactList: " + allContacts,
                allContacts.contains(contact));
    }

    @Test
    public void getContacts_should_return_all_contacts_in_contactList() {

        ContactDTO contact1 = createContact1();
        ContactDTO contact2 = createContact2();
        List<ContactDTO> contacts = new ArrayList<>(asList(contact1, contact2));

        service.createContact(contact1);
        service.createContact(contact2);
        List<ContactDTO> allContacts = service.getContacts();

        assertTrue(allContacts.containsAll(contacts));
    }

    @Test
    public void contact_should_be_removed_from_contactlist_after_deleting() {

        ContactDTO contact = createContact1();
        service.createContact(contact);
        service.deleteContact(contact);

        assertFalse(service.getContacts().contains(contact));
    }

    @Test()
    public void adding_firendship_should_create_firend_in_friendList_for_both_contacts() {

        ContactDTO contact1 = createContact1();
        ContactDTO contact2 = createContact2();
        service.createContact(contact1);
        service.createContact(contact2);
        service.addFriendship(contact1, contact2);

        assertTrue(service.getFriendList(contact1).contains(contact2));
        assertTrue(service.getFriendList(contact2).contains(contact1));

    }

    @Test
    public void friendList_should_return_all_contacts_in_friend_list() {

        ContactDTO contact1 = createContact1();
        ContactDTO contact2 = createContact2();
        service.createContact(contact1);
        service.createContact(contact2);
        service.addFriendship(contact1, contact2);

        assertTrue(service.getFriendList(contact1).contains(contact2));

    }

    @Test
    public void cversation_should_contains_all_messages_between_contacts() {
        ContactDTO contact1 = createContact1();
        ContactDTO contact2 = createContact2();
        service.createContact(contact1);
        service.createContact(contact2);

        MessageDTO message1 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content1");
        service.storeMessage(message1);
        MessageDTO message2 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content2");
        service.storeMessage(message2);

        List<MessageDTO> messages = new ArrayList<>(asList(message1, message2));
        List<MessageDTO> conversation = service.getConversation(contact1, contact2);

        assertTrue(conversation.containsAll(messages));

    }

    @AfterMethod
    public void deleteConatacs() {
        List<ContactDTO> contacts = service.getContacts();
        for (ContactDTO contact : contacts) {
            service.deleteContact(contact);
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

    private void createConversation(ContactDTO contact1, ContactDTO contact2) {

        MessageDTO messageDTO1 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content1");
        MessageDTO messageDTO2 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content2");
        MessageDTO messageDTO3 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content3");

        service.storeMessage(messageDTO1);
        service.storeMessage(messageDTO2);
        service.storeMessage(messageDTO3);

    }

}
