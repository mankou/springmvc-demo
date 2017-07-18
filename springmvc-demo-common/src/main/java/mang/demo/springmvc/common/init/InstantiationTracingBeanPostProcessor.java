package mang.demo.springmvc.common.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component  
public class InstantiationTracingBeanPostProcessor implements  
        ApplicationListener<ContextRefreshedEvent> {  
  
    @Override  
    public void onApplicationEvent(ContextRefreshedEvent arg0) {  
        System.out.println("-----所有Bean载入完成---");  
    }  
}  