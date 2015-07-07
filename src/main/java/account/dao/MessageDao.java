/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.dao;

import account.contact.Contact;
import account.contact.ContactDTO;
import accountMessage.Message;
import accountMessage.MessageDTO;
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

    public List<Message> getConversation(ContactDTO contactFrom, ContactDTO contactTo) {
        List<Message> conversation = new ArrayList<>();
        Contact contFrom = contactDAO.getContactWithEmail(contactFrom.getEmail());
        Contact contTo = contactDAO.getContactWithEmail(contactTo.getEmail());

        messageList.stream().forEach((message) -> {
            Contact cFrom = message.getFrom();
            Contact cTo = message.getTo();
            if (cFrom.equals(contFrom) && cTo.equals(contTo)
                    || cTo.equals(contFrom) && cFrom.equals(contTo)) {
                conversation.add(message);
            }
        });

        return conversation;
    }
}
