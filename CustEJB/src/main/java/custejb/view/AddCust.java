/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.view;

import custejb.business.Facade;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Model
public class AddCust {

    @Inject
    private Facade facade;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    @Size(min=4)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String addCust() {
        facade.addCust(name);
        return "index?faces-redirect=true";
    }

}
