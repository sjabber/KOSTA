package com.day.dao;

import java.util.List;

import com.day.dto.OrderInfo;
import com.day.exception.AddException;
import com.day.exception.FindException;

public interface OrderDAO {
	/**
	 * ì£¼ë¬¸ì¶”ê??•œ?‹¤. ì£¼ë¬¸ê¸°ë³¸? •ë³´ì¶”ê°??? ì£¼ë¬¸?ƒ?„¸? •ë³´ë“¤?„ ì¶”ê??•œ?‹¤.
	 * @param info
	 * @throws AddException
	 */
	void insert(OrderInfo  info) throws AddException;
	
	/**
	 * ì£¼ë¬¸ê²??ƒ‰?•œ?‹¤
	 * @param id ê³ ê°?•„?´?””
	 * @return
	 * @throws FindException
	 */
	List<OrderInfo> selectById(String id) throws FindException;
}
