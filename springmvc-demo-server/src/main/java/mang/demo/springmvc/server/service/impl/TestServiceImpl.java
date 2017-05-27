package mang.demo.springmvc.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mang.demo.springmvc.server.dao.TestDAO;
import mang.demo.springmvc.server.entity.TestUser;
import mang.demo.springmvc.server.service.TestService;



@Service
@Transactional
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDAO testDAO;
	@Override
	public List queryDb() {
		List lis=testDAO.queryTest();
		return lis;
	}
	@Override
	public TestUser insertDb() {
		Long maxId=testDAO.queryMaxId();
		if(maxId==null){
			maxId=0L;
		}else{
			maxId++;
		}
		
		TestUser testUser=new TestUser();
		testUser.setId(maxId);
		testUser.setCode("XX测试");
		testUser.setName("XX测试");
		testDAO.saveOrUpdate(testUser);
		return testUser;
	}

}
