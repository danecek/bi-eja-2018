/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
        @NamedQuery(name = "allCusts", query = "SELECT c FROM Cust c")
)
public class Cust {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "cust")
    Collection<Order> orders;

    public Cust() {
    }

    public Cust(String name) {
        this.name = name;
    }

    public Cust(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cust{" + "id=" + id + ", name=" + name + '}';
    }

}
