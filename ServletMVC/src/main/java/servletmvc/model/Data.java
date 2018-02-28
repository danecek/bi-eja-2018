/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletmvc.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author danecek
 */
public class Data {

    /**
     * @return the data
     */
    public List<String> getData() {
        return data;
    }

    private final List<String> data = new CopyOnWriteArrayList<>();

    public static Data INST = new Data();

    private Data() {
        data.add("item");
    }
    
    

}
