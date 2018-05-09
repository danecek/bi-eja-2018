/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.business;

import java.util.logging.Logger;
import javax.persistence.OptimisticLockException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order()
public class FacadeAspect {

    int norep = 3;

    @Around("execution(* custsspringmvcjpa.business.Facade.*(..))")

    //   @Around("within(custsspringmvcjpa.business.Facade)")
    Object facadeAround(ProceedingJoinPoint jp) throws Throwable {
        OptimisticLockException exx = null;
        for (int i = 1; i < norep; i++) {
            LOG.info("repetition:" + i);
            try {
                return jp.proceed();
            } catch (OptimisticLockException ex) {
                exx = ex;
            }
        }
        throw exx;
    }
    private static final Logger LOG = Logger.getLogger(FacadeAspect.class.getName());

}
