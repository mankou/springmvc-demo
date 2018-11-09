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

    //切点
    @Pointcut("execution(* mang.demo.springmvc.server.service..*.*(..))")
    private void server(){}

    //通知
    @Before("server()")
    public void before(JoinPoint jp){
        System.out.println("service before running......");
    }
}