/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.contact.ContactDTO;
import java.time.LocalDate;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author konst
 */
public class App {

    public static void main(String[] args) throws Exception {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("Beans.xml");

        JavaContactService service = context.getBean(JavaContactService.class);

        Set hobbies = new HashSet(asList("footbal", "basketball"));
        Set places = new HashSet(asList("theater", "stadium"));

        ContactDTO contactDTO = new ContactDTO("vasya", "ivanov", LocalDate.now(), hobbies, places);
        service.createContact(contactDTO);

        System.out.println("S: " + service.getContacts().size());

        service.deleteContact(contactDTO);

        System.out.println("S: " + service.getContacts().size());
    }
}
