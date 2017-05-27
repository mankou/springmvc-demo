package mang.demo.springmvc.server.service;

import java.util.List;

import mang.demo.springmvc.server.entity.TestUser;

public interface TestService {
	public List  queryDb();
	
	public TestUser insertDb();
}
