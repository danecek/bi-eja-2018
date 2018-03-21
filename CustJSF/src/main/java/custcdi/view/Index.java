/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.view;

import custcdi.business.Facade;
import custcdi.model.Cust;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;


@Model //  @ Named @RequestScoped
public class Index {
    
    @Inject
    Facade facade;

    public List<Cust> getCusts() {
        return facade.allCusts();
    }
    
}
