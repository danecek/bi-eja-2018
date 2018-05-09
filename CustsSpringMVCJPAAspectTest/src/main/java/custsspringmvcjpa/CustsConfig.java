/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa;


import custsspringmvcjpa.business.FacadeImpl;
import custsspringmvcjpa.integration.CustsDAO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustsConfig {

    @Bean
    public FacadeImpl facade(CustsDAO custDAO) {
        return new FacadeImpl(custDAO);
    }


}
