package mang.demo.springmvc.common.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class ServiceAspect {
	private static Logger logger=Logger.getLogger("log");
	
	
	//切面  
//    @Pointcut("execution(* com.neusoft.pszx.review.server.service.impl.RfidServiceImpl.*(..))")
    @Pointcut("execution(* com.neusoft.pszx.review.server.service..*.*(..))")
    private void pt(){}
    
  //切点的顺序  
    @Before("pt()")
    public void before(JoinPoint jp){  
        System.out.println("service before running......");  
    }  
}
