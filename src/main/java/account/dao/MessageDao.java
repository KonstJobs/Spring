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

/**
 *
 * @author konst
 */
public class MessageDao {

    List<Message> messageList = new ArrayList<>();
    private ContactDao contactDao;

    public MessageDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void storeMessage(MessageDTO messageDTO) {

        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setDate(messageDTO.getDate());
        message.setFrom(contactDao.getContactWithEmail(messageDTO.getFrom().getEmail()));
        message.setTo(contactDao.getContactWithEmail(messageDTO.getTo().getEmail()));

        messageList.add(message);

    }

    public List<MessageDTO> getConversation(ContactDTO contactFrom, ContactDTO contactTo) {
        List<MessageDTO> conversation = new ArrayList<>();
        Contact contFrom = contactDao.getContactWithEmail(contactFrom.getEmail());
        Contact contTo = contactDao.getContactWithEmail(contactTo.getEmail());

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

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
    
    

}
