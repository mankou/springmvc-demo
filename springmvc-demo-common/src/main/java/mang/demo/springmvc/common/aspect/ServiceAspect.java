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
    private static Logger logger = Logger.getLogger("log");

    public static final String CONTROLLER_PONINT_CUT = "execution(* mang.demo.springmvc.server.controller..*.*(..))";


    //切面
    @Pointcut(CONTROLLER_PONINT_CUT)
    public void server() {
    }

    //切点的顺序
    @Before("server()")
    public void before(JoinPoint jp) {
        System.out.println("service before running......");
    }
}