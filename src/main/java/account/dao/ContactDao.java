/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.Contact;
import account.contact.ContactDTO;
import account.hobby.Hobby;
import account.hobby.HobbyDTO;
import account.place.Place;
import account.place.PlaceDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
            contact.setHobbies(createHobbies(contactDTO.getHobbies()));
            contact.setPlaces(createPlaces(contactDTO.getPlaces()));
            contact.setEmail(email);

            contactList.add(contact);
            System.out.println("Added contact : " + contact);
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

    public void removeFriendShip(ContactDTO contactDTO1, ContactDTO contactDTO2) {

    }

    public List<ContactDTO> getAllContacts() {

        List<ContactDTO> contacts = new ArrayList<>();
        contactList.stream().forEach((contactList1) -> {
            ContactDTO contactDTO = new ContactDTO(contactList1.getFirstName(),
                    contactList1.getLastName(),
                    contactList1.getBirthDate(),
                    createHobbyDTO(contactList1.getHobbies()),
                    createPlaceDTO(contactList1.getPlaces()),
                    contactList1.getEmail());
            contacts.add(contactDTO);
        });

        return contacts;
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

    public Set<ContactDTO> getFirendList(ContactDTO contactDTO) {
        String email = contactDTO.getEmail();
        Contact contact = getContactWithEmail(email);
        return createContactsDTO(contact.getFriends());
    }

    private Set<Hobby> createHobbies(Set<HobbyDTO> hobbyDTO) {
        Set<Hobby> hobbies = new HashSet<>();

        hobbyDTO.stream().map((h) -> {
            Hobby hobby = new Hobby();
            hobby.setTitle(h.getTitle());
            hobby.setDescription(h.getDescription());
            return hobby;
        }).forEach((hobby) -> {
            hobbies.add(hobby);
        });

        return hobbies;
    }

    private Set<Place> createPlaces(Set<PlaceDTO> placesDTO) {
        Set<Place> places = new HashSet<>();

        placesDTO.stream().map((placeDTO) -> {
            Place place = new Place();
            place.setTitle(placeDTO.getTitle());
            place.setDescription(placeDTO.getDescription());
            place.setLatitude(placeDTO.getLatitude());
            place.setLongitude(placeDTO.getLongitude());
            return place;
        }).forEach((place) -> {
            places.add(place);
        });

        return places;
    }

    private Set<HobbyDTO> createHobbyDTO(Set<Hobby> hobbies) {
        Set<HobbyDTO> hobbiesDTO = new HashSet<>();
        for (Iterator<Hobby> it = hobbies.iterator(); it.hasNext();) {
            Hobby hobby = it.next();
            HobbyDTO hobbyDTO = new HobbyDTO(
                    hobby.getTitle(),
                    hobby.getDescription());
            hobbiesDTO.add(hobbyDTO);
        }

        return hobbiesDTO;
    }

    private Set<PlaceDTO> createPlaceDTO(Set<Place> places) {
        Set<PlaceDTO> placesDTO = new HashSet<>();
        places.stream().map((place) -> new PlaceDTO(
                place.getDescription(),
                place.getTitle(),
                place.getLongitude(),
                place.getLatitude())).forEach((placeDTO) -> {
                    placesDTO.add(placeDTO);
                });

        return placesDTO;
    }

    private Set<ContactDTO> createContactsDTO(Set<Contact> friends) {

        Set<ContactDTO> contactsDTO = new HashSet<>();
        for (Contact friend : friends) {
            ContactDTO contactDTO = new ContactDTO(friend.getFirstName(),
                    friend.getLastName(),
                    friend.getBirthDate(),
                    createHobbyDTO(friend.getHobbies()),
                    createPlaceDTO(friend.getPlaces()),
                    friend.getEmail());

            contactsDTO.add(contactDTO);

        }

        return contactsDTO;
    }

    public ContactDTO createContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getBirthDate(),
                createHobbyDTO(contact.getHobbies()),
                createPlaceDTO(contact.getPlaces()),
                contact.getEmail());

        return contactDTO;
    }
}
