/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.business;

import custsspringmvcjpa.integration.CustsDAO;
import custsspringmvcjpa.model.Cust;
import java.util.List;

public class FacadeImpl implements Facade {

    CustsDAO custDAO;

    public FacadeImpl(CustsDAO custDAO) {
        this.custDAO = custDAO;

    }

    @Override
    public void addCust(String name) {
        custDAO.save(new Cust(name));

    }

    @Override
    public Iterable<Cust> allCusts() {
        return custDAO.findAll();
    }

}
