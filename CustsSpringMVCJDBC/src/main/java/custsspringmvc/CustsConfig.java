/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvc;

import custsspringmvc.business.FacadeImpl;
import custsspringmvc.integration.CustsDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustsConfig {

    @Bean
    public FacadeImpl facade(CustsDAOImpl custDAO) {
        return new FacadeImpl(custDAO);
    }


    @Bean
    public CustsDAOImpl custDAO() {
        return new CustsDAOImpl();
    }

}
