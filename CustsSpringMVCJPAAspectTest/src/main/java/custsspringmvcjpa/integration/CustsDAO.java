/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.integration;

import custsspringmvcjpa.model.Cust;

public interface CustsDAO extends AllEntities<Cust> {

    Cust findByName(String name);

}
