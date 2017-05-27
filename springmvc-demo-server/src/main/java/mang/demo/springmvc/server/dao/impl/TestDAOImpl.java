package mang.demo.springmvc.server.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

import mang.demo.springmvc.server.dao.TestDAO;
import mang.demo.springmvc.server.dao.base.HibernateDaoBase;
import mang.demo.springmvc.server.entity.TestUser;



@Repository
public class TestDAOImpl extends HibernateDaoBase implements TestDAO {

	@Override
	public List queryTest() {
		String hql="from TestUser t ";
		List lis=this.getHibernateTemplate().find(hql);
		return lis;
	}

	@Override
	public Long queryMaxId() {
		String sql="select max(id) as maxid from t_user ";
		SQLQuery query=this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.addScalar("maxid", LongType.INSTANCE);
		
		List<Long> lis=query.list();
		if(lis!=null && lis.size()>0){
			return lis.get(0);
		}
		
		return null;
	}

	@Override
	public TestUser saveOrUpdate(TestUser entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

}
