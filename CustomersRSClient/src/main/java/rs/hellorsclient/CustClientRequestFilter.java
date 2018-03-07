/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.hellorsclient;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CustClientRequestFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext crc) throws IOException {
        LOG.info(crc.getEntity()+"");
    }
    private static final Logger LOG = Logger.getLogger(CustClientRequestFilter.class.getName());

}
