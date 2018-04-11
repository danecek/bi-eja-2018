/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.view;

import custcdi.business.Facade;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Model
public class UpdateCust {

    @Inject
    private Facade facade;

    @Pattern(regexp = "[a-zA-Z]+", message = "{onlyletters}")
    @Size(min = 3, message = "{tooshort}")
    private String name;    
    private int custId;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String updateCust() {
        facade.updateCust(custId, name);
        return "/index?faces-redirect=true";
    }

    /**
     * @return the custId
     */
    public int getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

}
