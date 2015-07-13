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
import account.run.JavaContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author konst
 */
@Configuration
@Import(DaoConfig.class)
public class ContactServiceConfig {

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private HobbyDao hobbyDao;

    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private MessageDao messageDao;

    @Bean
    public JavaContactService javaContactService() {
        JavaContactService service = new JavaContactService();

        service.setContactDao(contactDao);
        service.setHobbyDao(hobbyDao);
        service.setPlaceDao(placeDao);
        service.setMessageDao(messageDao);

        return service;
    }

}
