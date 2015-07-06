/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.run;

import org.springframework.stereotype.Component;

/**
 *
 * @author konst
 */
@Component
public class Dog {

    String name = "Barsik";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
