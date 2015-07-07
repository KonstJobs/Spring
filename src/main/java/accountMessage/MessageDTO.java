/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountMessage;

import account.contact.ContactDTO;
import java.time.LocalDateTime;

/**
 *
 * @author konst
 */
public class MessageDTO {

    private LocalDateTime date;
    private ContactDTO from;
    private ContactDTO to;
    private String content;

    public MessageDTO(LocalDateTime date, ContactDTO from, ContactDTO to, String content) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.content = content;
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
