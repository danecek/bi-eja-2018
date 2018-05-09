/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.business;


import custsspringmvcjpa.model.Cust;
import javax.validation.constraints.Pattern;

public interface Facade {

    void addCust(@Pattern(regexp = "[a-zA-Z]+") String name);

    Iterable<Cust> allCusts();


}
