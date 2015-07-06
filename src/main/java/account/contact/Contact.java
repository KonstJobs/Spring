/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.contact;

import account.hobby.Hobby;
import account.place.Place;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author konst
 */
public class Contact {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Set<Hobby> hobbies;
    private Set<Place> places;
    private String email;
    private Set<Contact> friends = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public void setFriend(Contact contact) {
        friends.add(contact);
    }

    public Contact getFriend(String email) {

        for (Contact friend : friends) {
            if (friend.getEmail().equals(email)) {
                return friend;
            }
        }
        System.out.println("Friend not found!");
        return null;
    }

    public Set<Contact> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Contact{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    
    
}
