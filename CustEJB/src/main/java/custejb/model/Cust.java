/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custejb.model;

public class Cust {

    @Override
    public String toString() {
        return "Cust{" + "id=" + id + ", name=" + name + '}';
    }

    private final int id;
    private final String name;

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

}
