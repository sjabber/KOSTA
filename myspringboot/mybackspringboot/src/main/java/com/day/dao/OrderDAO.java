package com.day.dao;

import java.util.List;

import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;

public interface OrderDAO {
	/**
	 * �ֹ� �߰��Ѵ�. �ֹ��⺻���� �߰��� �ֹ����������� �߰��Ѵ�.
	 * @param info
	 * @throws AddException
	 */
	void insert(OrderInfo info) throws AddException;
	
	/**
	 * �ֹ� �˻��Ѵ�.
	 * @param id �����̵�
	 * @return
	 * @throws FindException
	 */
	List<OrderInfo> selectById(String id) throws FindException;
	
}

//
//package com.day.dao;
//
//import java.util.List;
//
//import com.day.dto.OrderInfo;
//import com.day.exception.AddException;
//import com.day.exception.FindException;
//
//public interface OrderDAO {
//	/**
//	 * �ֹ� �߰��Ѵ�. �ֹ��⺻���� �߰��� �ֹ����������� �߰��Ѵ�.
//	 * @param info
//	 * @throws AddException
//	 */
//	void insert(OrderInfo info) throws AddException;
//	
//	/**
//	 * �ֹ� �˻��Ѵ�.
//	 * @param id �����̵�
//	 * @return
//	 * @throws FindException
//	 */
//	List<OrderInfo> selectById(String id) throws FindException;
////	void insert(OrderInfo info) throws AddException;
////	
////	List<OrderInfo> selectById(String id) throws FindException;
//}
