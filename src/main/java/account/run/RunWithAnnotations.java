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
public class RunWithAnnotations {

    public static void main(String[] args) throws Exception {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("Beans.xml");

        JavaContactService service = context.getBean(JavaContactService.class);

        service.addHobby(new HobbyDTO("hobby1", "description1"));
        service.addHobby(new HobbyDTO("hobby2", "description2"));

        service.addPlace(new PlaceDTO("place1", "title1", 6542, 65432));
        service.addPlace(new PlaceDTO("place2", "title2", 343, 343));

        ContactDTO dto1 = new ContactDTO("name1", "lastname1", LocalDate.now(), null, null, "sldfkj@ha-ha-ha-haha-h-a-ha-h-ah-ah-");
        ContactDTO dto2 = new ContactDTO("name2", "lastname2", LocalDate.now(), null, null, "sldfkj@ываыв");

        service.createContact(dto1);
        service.createContact(dto2);

        MessageDTO messageDTO = new MessageDTO(LocalDateTime.now(), dto1, dto2, "bla-bla");
        service.storeMessage(messageDTO);

        List<Message> messages = service.getConversation(dto1, dto2);

        System.out.println(messages.get(0).getContent());

        System.out.println(service.getContacts());

        //service.deleteContact(dto2);
        System.out.println(service.getContacts());

        service.addFriendship(dto1, dto2);

        System.out.println(service.getFriendList(dto2));
    }
}
