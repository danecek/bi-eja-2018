/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvc.business;

import custsspringmvc.integration.CustsDAO;
import custsspringmvc.model.Cust;
import java.util.List;

public class FacadeImpl implements Facade {

    CustsDAO custDAO;

    public FacadeImpl(CustsDAO custDAO) {
        this.custDAO = custDAO;

    }

    @Override
    public void addCust(String name) {
        custDAO.add(name);

    }

    @Override
    public List<Cust> allCusts() {
        return custDAO.all();
    }

}
