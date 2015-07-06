/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.Contact;
import account.place.Place;
import account.place.PlaceDTO;
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
public class PlaceDao {

    private Set<Place> placeList = new HashSet<>();

    @Autowired
    private ContactDao contactDao;

    public void addPlace(PlaceDTO placeDTO) {

        Place place = new Place();
        place.setTitle(placeDTO.getTitle());
        place.setDescription(placeDTO.getDescription());
        place.setLatitude(placeDTO.getLatitude());
        place.setLongitude(placeDTO.getLongitude());

        placeList.add(place);

    }

    public Set<Contact> getAllContactsForPlace(PlaceDTO placeDTO) {
        Set<Contact> contactsForPlace = new HashSet<>();
        List<Contact> contacts = contactDao.getAllContacts();
        String placeTitle = placeDTO.getTitle();

        for (Contact contact : contacts) {
            Set<Place> places = contact.getPlaces();

            for (Place place : places) {
                if (place.getTitle().equals(placeTitle)) {
                    contactsForPlace.add(contact);
                    break;
                }
            }
        }

        return contactsForPlace;
    }
}
