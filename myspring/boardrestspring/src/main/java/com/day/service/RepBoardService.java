package com.day.service;

import java.io.WriteAbortedException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day.dao.RepBoardDAO;
import com.day.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.exception.RemoveException;

@Service
public class RepBoardService {
	@Autowired
	private RepBoardDAO dao;
	/**
	 * 글쓰기
	 * @param repBoard
	 * @throws AddException
	 */
	public void write(RepBoard repBoard) throws AddException {
		repBoard.setParentNo(0);
		dao.Insert(repBoard);
	}
	
	/**
	 * 답글쓰기
	 * @param repBoard
	 * @throws AddException
	 */
	public void reply(RepBoard repBoard) throws AddException {
		if(repBoard.getParentNo() == 0) {
			throw new AddException("부모글번호가 필요합니다.");
		}
		dao.Insert(repBoard);
	}
	
	public List<RepBoard> list(String word) throws FindException {
		return dao.selectByWord(word);
	}
	
	public List<RepBoard> list() throws FindException {
		return dao.selectAll();
	}
	
	public RepBoard findByNo(int boardNo) throws FindException {
		try {
			dao.plusViewCount(boardNo);
		} catch (ModifyException e) {
			e.printStackTrace();
			throw new FindException("조회수 증가 실패: " + e.getMessage());
		}
		return dao.selectByNo(boardNo);
	}
	
	public void Modify(RepBoard repBoard) throws ModifyException {
		try {
			dao.update(repBoard);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModifyException("수정 실패, " + e.getMessage());
		}
	}
	
	// 댓글삭제
	public void Delete(RepBoard repBoard) throws RemoveException {
		try {
			dao.delete(repBoard);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoveException("삭제 실패, " + e.getMessage());
		}
	}
	
	// 게시글 삭제
//	public void Delete(RepBoard repBoard) throws RemoveException {
//		try {
//			dao.delete(repBoard);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RemoveException("원글 삭제 실패: " + e.getMessage());
//		}
//	}
}
