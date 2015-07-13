/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.javaconfig;

import account.dao.ContactDao;
import account.dao.HobbyDao;
import account.dao.MessageDao;
import account.dao.PlaceDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author konst
 */
@Configuration
public class DaoConfig {

    @Bean
    public ContactDao contactDao() {
        return new ContactDao();
    }

    @Bean
    public HobbyDao hobbyDao() {
        return new HobbyDao(contactDao());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(contactDao());
    }

    @Bean
    public PlaceDao placeDao() {
        return new PlaceDao(contactDao());
    }
}
