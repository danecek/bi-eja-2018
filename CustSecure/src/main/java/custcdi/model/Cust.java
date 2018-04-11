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
import javax.persistence.Version;

@Entity
@NamedQueries(
        @NamedQuery(name = "allCusts", query = "SELECT c FROM Cust c")
)
public class Cust {

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;
    
    @Version
    private int version;
    
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
