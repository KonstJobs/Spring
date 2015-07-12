/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.Contact;
import account.contact.ContactDTO;
import account.message.Message;
import account.message.MessageDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author konst
 */
@Component
public class MessageDao {

    List<Message> messageList = new ArrayList<>();

    @Autowired
    private ContactDao contactDAO;

    public void storeMessage(MessageDTO messageDTO) {

        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setDate(messageDTO.getDate());
        message.setFrom(contactDAO.getContactWithEmail(messageDTO.getFrom().getEmail()));
        message.setTo(contactDAO.getContactWithEmail(messageDTO.getTo().getEmail()));

        messageList.add(message);

    }

    public List<MessageDTO> getConversation(ContactDTO contactFrom, ContactDTO contactTo) {
        List<MessageDTO> conversation = new ArrayList<>();
        Contact contFrom = contactDAO.getContactWithEmail(contactFrom.getEmail());
        Contact contTo = contactDAO.getContactWithEmail(contactTo.getEmail());

        for (Message message : messageList) {

            Contact c1 = message.getFrom();
            Contact c2 = message.getTo();

            if (c1.equals(contFrom) && c2.equals(contTo)
                    || c2.equals(contFrom) && c1.equals(contTo)) {

                MessageDTO messageDTO = new MessageDTO(
                        message.getDate(),
                        contactFrom, contactTo, message.getContent());

                conversation.add(messageDTO);
            }
        }
        return conversation;
    }

}
