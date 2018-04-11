/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/ExpiryQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})

public class CustsMessageBean implements MessageListener {

    private static final Logger LOG = Logger.getLogger(CustsMessageBean.class.getName());
    
    
    @Override
    public void onMessage(Message message) {
        try {
            LOG.info(message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(CustsMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
