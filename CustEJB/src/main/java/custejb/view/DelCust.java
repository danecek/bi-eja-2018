/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.view;

import custejb.business.Facade;
import custejb.model.Cust;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class DelCust {

    @Inject
    Facade facade;

    private int id;

    public Cust getCust() {
        return facade.findCust(id);
    }


    public String delCust() {
        facade.delCust(id);
        return "index?faces-redirect=true";
    }


    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
