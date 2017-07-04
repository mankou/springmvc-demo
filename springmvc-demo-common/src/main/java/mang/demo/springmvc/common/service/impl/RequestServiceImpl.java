package mang.demo.springmvc.common.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mang.demo.springmvc.common.dao.GeneralDAO;
import mang.demo.springmvc.common.entity.RequestLog;
import mang.demo.springmvc.common.service.RequestService;


@Service
@Transactional
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private GeneralDAO generalDAO;

	@Override
	public void saveOrUpdate(RequestLog requestLog) {
		generalDAO.saveOrUpdate(requestLog);
	}

}
