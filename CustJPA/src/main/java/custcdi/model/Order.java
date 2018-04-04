/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "CustOrder")
@NamedQueries(
        @NamedQuery(name = "allOrders", query = "SELECT o FROM CustOrder o")
)
public class Order {

    public Order() {
    }

    @Id
    @GeneratedValue
    private long id;

    private int price;

    @ManyToOne(optional = false)
    private Cust cust;

    public Order(int price, Cust cust) {
        this.price = price;
        this.cust = cust;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the cust
     */
    public Cust getCust() {
        return cust;
    }

}
