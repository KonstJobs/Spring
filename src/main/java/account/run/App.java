/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.contact.ContactDTO;
import account.hobby.HobbyDTO;
import account.place.PlaceDTO;
import accountMessage.Message;
import accountMessage.MessageDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
        
        ContactDTO dto1 = new ContactDTO("contact1", "sdf", LocalDate.now(), null, null, "sldfkj@ha-ha-ha-haha-h-a-ha-h-ah-ah-");
        ContactDTO dto2 = new ContactDTO("contact2", "dfd", LocalDate.now(), null, null, "sldfkj@ываыв");
        
        service.createContact(dto1);
        service.createContact(dto2);
        
        MessageDTO messageDTO = new MessageDTO(LocalDateTime.now(), dto1, dto2, "bla-bla");
        service.storeMessage(messageDTO);
        
        List<Message> messages = service.getConversation(dto1, dto2);
        
        System.out.println(messages.get(0).getContent());
        
        System.out.println(service.getContacts());
        
        //service.deleteContact(dto2);
        
        System.out.println(service.getContacts());
        
        service.addHobby(new HobbyDTO("title", "descr"));
        service.addHobby(new HobbyDTO("titldfe", "descrasdf"));
        
        service.addPlace(new PlaceDTO("descre", "title", 6542, 65432));
        service.addPlace(new PlaceDTO("sdf", "sdf", 343, 343));
        
        service.addFriendship(dto1, dto2);
        
        
        
        System.out.println(service.getFriendList(dto2));
    }
}
