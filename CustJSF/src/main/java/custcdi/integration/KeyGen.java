/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.integration;

public class KeyGen {

    private int counter = 1;

    public int newKey() {
        return counter++;
    }

}
