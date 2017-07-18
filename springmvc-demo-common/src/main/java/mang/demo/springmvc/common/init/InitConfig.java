package mang.demo.springmvc.common.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitConfig implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean");
	}

}