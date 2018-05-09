/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.integration;

import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OptLockExAspect {

    private static final Logger LOG = Logger.getLogger(OptLockExAspect.class.getName());

    @Around("this(custsspringmvcjpa.integration.CustsDAO)")
   // @Around("execution(* custsspringmvcjpa.integration.CustsDAO.*(..))")
    Object exec(ProceedingJoinPoint pjp) throws Throwable {
        LOG.info("before");
        Object res = pjp.proceed();
        LOG.info("after");
        return res;

    }

}
