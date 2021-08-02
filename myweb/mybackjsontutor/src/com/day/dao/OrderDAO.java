package com.day.dao;

import java.util.List;

import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;

public interface OrderDAO {
	/**
	 * 주문추�??��?��. 주문기본?��보추�??? 주문?��?��?��보들?�� 추�??��?��.
	 * @param info
	 * @throws AddException
	 */
	void insert(OrderInfo  info) throws AddException;
	
	/**
	 * 주문�??��?��?��
	 * @param id 고객?��?��?��
	 * @return
	 * @throws FindException
	 */
	List<OrderInfo> selectById(String id) throws FindException;
}
