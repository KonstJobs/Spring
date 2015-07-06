/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import account.hobby.HobbyDTO;
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
        
        HobbyDTO hobbyDTO = new HobbyDTO("test tietle", "descre");
        service.addHobby(hobbyDTO);
        service.addHobby(hobbyDTO);
        
        
        
        
    }
}
