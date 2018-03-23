/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import custcdi.model.Cust;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public interface Facade {

    void addCust(@Pattern(regexp = "[a-zA-Z]+") String name);

    List<Cust> allCusts();

    public void login(@Size(min = 3) String user);

    public void logout();

    public Optional<String> user();
}
