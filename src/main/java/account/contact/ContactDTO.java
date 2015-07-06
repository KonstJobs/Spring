/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.contact;

import account.hobby.Hobby;
import account.place.Place;
import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author konst
 */
public class ContactDTO {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final Set<Hobby> hobbies;
    private final Set<Place> places;
    private final String email;

    public ContactDTO(String firstName,
            String lastName,
            LocalDate birthDate,
            Set<Hobby> hobbies,
            Set<Place> places,
            String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hobbies = hobbies;
        this.places = places;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

}
