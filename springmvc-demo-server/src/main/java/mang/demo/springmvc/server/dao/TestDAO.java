package mang.demo.springmvc.server.dao;

import java.util.List;

import mang.demo.springmvc.server.entity.TestUser;

public interface TestDAO {
	public List queryTest();
	
	public Long queryMaxId();
	
	public TestUser saveOrUpdate(TestUser entity);
}
