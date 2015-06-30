/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import account.Contact;
import account.Hobby;
import account.Place;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author konst
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Contact contact = (Contact) context.getBean("contact");

        Set<Hobby> hobs = contact.getHobbies();

        System.out.println("hobs: " + hobs.size());

        for (Hobby hob : hobs) {
            System.out.println(hob.getTitle());
        }
        
        
        Place pl = (Place) context.getBean("place");
        System.out.println(pl.getLatitude());
    }
}
