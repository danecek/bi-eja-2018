/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import custcdi.model.Cust;
import java.util.List;
import java.util.Optional;

public interface Facade {

    void addCust(String name);

    List<Cust> allCusts();

    public void login(String user);

    public void logout();

    public Optional<String> user();
    
    void delCust(int id);

    public Cust findCust(int id);
}
