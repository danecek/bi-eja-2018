/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.view;

import custejb.business.Facade;
import custejb.model.Cust;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Index {

    @Inject
    Facade facade;

    public List<Cust> getCusts() {
        return facade.allCusts();
    }

    public boolean isLogged() {
        return facade.loggedUser().isPresent();
    }

}
