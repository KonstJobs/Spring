/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.message;

import account.contact.ContactDTO;
import java.time.LocalDateTime;

/**
 *
 * @author konst
 */
public class MessageDTO {

    private final LocalDateTime date;
    private final ContactDTO from;
    private final ContactDTO to;
    private final String content;

    public MessageDTO(LocalDateTime date, ContactDTO from, ContactDTO to, String content) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageDTO{" + "content=" + content + '}';
    }

    

    public LocalDateTime getDate() {
        return date;
    }

    public ContactDTO getFrom() {
        return from;
    }

    public ContactDTO getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    
    
    
}
