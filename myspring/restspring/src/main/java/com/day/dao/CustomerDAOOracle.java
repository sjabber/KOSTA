package com.day.dao;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository("customerDAO")
public class CustomerDAOOracle implements CustomerDAO{
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Override
	public void insert(Customer c) throws AddException {
		SqlSession session = null;		
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.dto.CustomerMapper.insert", c);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public Customer selectById(String id) throws FindException {
		SqlSession session = null;		
		try {
			session = sessionFactory.openSession();
			Customer c = session.selectOne("com.day.dto.CustomerMapper.selectById", id);
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void update(Customer c) throws ModifyException {
		SqlSession session = null;		
		try {
			session = sessionFactory.openSession();
			session.update("com.day.dto.CustomerMapper.update", c);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

}