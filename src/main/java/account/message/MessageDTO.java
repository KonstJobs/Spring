/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.message;

import account.contact.ContactDTO;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.date);
        hash = 37 * hash + Objects.hashCode(this.from);
        hash = 37 * hash + Objects.hashCode(this.to);
        hash = 37 * hash + Objects.hashCode(this.content);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MessageDTO other = (MessageDTO) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        if (!Objects.equals(this.to, other.to)) {
            return false;
        }
        return Objects.equals(this.content, other.content);
    }

    
    
    
}
