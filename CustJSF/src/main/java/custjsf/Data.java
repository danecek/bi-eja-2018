/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custjsf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Data {
    
    private List<Cust> custs;
    
    @PostConstruct
    void init() {
        custs = new ArrayList(Collections.singletonList(new Cust("Tom", "Prague")));
    }

    /**
     * @return the custs
     */
    public List<Cust> getCusts() {
        return custs;
    }
        
        
    
}
