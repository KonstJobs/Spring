/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.ContactDTO;
import account.place.Place;
import account.place.PlaceDTO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author konst
 */
public class PlaceDao {

    private Set<Place> placeList = new HashSet<>();
    private ContactDao contactDao;

    public PlaceDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void addPlace(PlaceDTO placeDTO) {

        Place place = new Place();
        place.setTitle(placeDTO.getTitle());
        place.setDescription(placeDTO.getDescription());
        place.setLatitude(placeDTO.getLatitude());
        place.setLongitude(placeDTO.getLongitude());

        placeList.add(place);

    }

    public Set<ContactDTO> getAllContactsForPlace(PlaceDTO placeDTO) {
        Set<ContactDTO> contactsForPlace = new HashSet<>();
        List<ContactDTO> contacts = contactDao.getAllContacts();
        String placeTitle = placeDTO.getTitle();

        for (ContactDTO contact : contacts) {
            Set<PlaceDTO> places = contact.getPlaces();

            for (PlaceDTO place : places) {
                if (place.getTitle().equals(placeTitle)) {
                    contactsForPlace.add(contact);
                    break;
                }
            }
        }

        return contactsForPlace;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

}
