package mang.demo.springmvc.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Slf4j
@Aspect
@Service
public class ServiceAspect {

    //切点
    @Pointcut("execution(* mang.demo.springmvc.server.service..*.*(..))")
    private void server(){}

    //通知
    @Before("server()")
    public void before(JoinPoint jp){
        System.out.println("service before running......");
    }
}