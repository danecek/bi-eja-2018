/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custcdi.business;

import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@FacadeLogger
@Priority(Interceptor.Priority.APPLICATION)
public class FacadeLog {

    private static final Logger LOG = Logger.getLogger(FacadeLog.class.getName());

    @AroundInvoke
    public Object ai(InvocationContext context) throws Exception {
        LOG.info(context.getMethod().toString());
        return context.proceed();
    }

}
