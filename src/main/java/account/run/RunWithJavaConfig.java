/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.contact.ContactDTO;
import account.hobby.HobbyDTO;
import account.message.MessageDTO;
import account.place.PlaceDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author konst
 */
public class RunWithJavaConfig {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("Config.xml");

        JavaContactService service = (JavaContactService) context.getBean("service");

        // create hobbby
        HobbyDTO hobbyDTO1 = new HobbyDTO("title1", "title1");
        HobbyDTO hobbyDTO2 = new HobbyDTO("title2", "title2");
        Set<HobbyDTO> hobbySet = new HashSet<>();
        hobbySet.add(hobbyDTO1);
        hobbySet.add(hobbyDTO2);
       
        
        service.addHobby(hobbyDTO1);
        service.addHobby(hobbyDTO2);
        
        
         // create place 
        PlaceDTO placeDTO1 = new PlaceDTO("description1", "title1", 12346, 65020);
        PlaceDTO placeDTO2 = new PlaceDTO("description2", "title2", 12346.13, 65020.235);
        Set<PlaceDTO> placeSet = new HashSet<>();
        placeSet.add(placeDTO1);
        placeSet.add(placeDTO2);
        
        service.addPlace(placeDTO1);
        service.addPlace(placeDTO2);
        
        
        // create contact1
        ContactDTO contact1 = new ContactDTO(
                "name1",
                "last name1",
                LocalDate.now(),
                hobbySet,
                placeSet,
                "test@email");

        //create contact2
        ContactDTO contact2 = new ContactDTO(
                "name2",
                "last name2",
                LocalDate.now(),
                hobbySet,
                placeSet,
                "test@email2");

        service.createContact(contact1);
        service.createContact(contact2);
        
        
        System.out.println("get contacts:");
        service.getContacts().forEach((contact) -> {
            System.out.println(contact);
        });

        
        //add friendship
        service.addFriendship(contact1, contact2);
    
        System.out.println("friend list for contact2: " + service.getFriendList(contact2));
        System.out.println("friend list for contact1: " + service.getFriendList(contact1));
        
        // message
        MessageDTO messageDTO1 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content1");
        MessageDTO messageDTO2 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content2");
        MessageDTO messageDTO3 = new MessageDTO(LocalDateTime.now(), contact1, contact2, "content3");
        
        service.storeMessage(messageDTO1);
        service.storeMessage(messageDTO2);
        service.storeMessage(messageDTO3);
    
        System.out.println("conversation: " 
         + service.getConversation(contact1, contact2));
    
    }
}
