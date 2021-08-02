package com.day.service;

import com.day.dao.OrderDAO;
import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	@Autowired
	private OrderDAO dao;
	
	public void add(OrderInfo info)	throws AddException {
		dao.insert(info);
	}

	public List<OrderInfo> findById(String id) throws FindException {
		return dao.selectById(id);
	}
}
