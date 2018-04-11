/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.view;

import custcdi.business.Facade;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.Min;

@Model
public class CreateOrder {
    
    @Inject
    Facade facade;
    
    @Min(value = 1)
    private int price;
    
    private int custId;

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
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
    
    public String createOrder() {
        facade.addOrder(custId, price);
        return "index?faces-redirect=true";
        
    }
    
}
