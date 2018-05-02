/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjdbc.business;


import custsspringmvcjdbc.model.Cust;
import java.util.List;
import javax.validation.constraints.Pattern;

public interface Facade {

    void addCust(@Pattern(regexp = "[a-zA-Z]+") String name);

    List<Cust> allCusts();


}
