/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.contact;

import account.other.Hobby;
import account.other.Place;
import java.time.LocalDate;
import java.util.Objects;
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

    public ContactDTO(String firstName, String lastName, LocalDate birthDate, Set<Hobby> hobbies, Set<Place> places) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hobbies = hobbies;
        this.places = places;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.birthDate);
        hash = 97 * hash + Objects.hashCode(this.hobbies);
        hash = 97 * hash + Objects.hashCode(this.places);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactDTO other = (ContactDTO) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.hobbies, other.hobbies)) {
            return false;
        }
        return Objects.equals(this.places, other.places);
    }

    
    
    
}
