package com.day.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.day.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.exception.RemoveException;

@Repository
public class RepBoardDAOOracle implements RepBoardDAO {
	@Autowired
	@Qualifier("UnderscoreToCamelCase")
	private SqlSessionFactory sessionFactory;

	@Override
	@Transactional(rollbackFor = AddException.class)
	public void Insert(RepBoard repBoard) throws AddException {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.dto.RepBoardMapper.insert", repBoard);
		} catch (Exception e) {
			throw new AddException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		
	}

	@Override
	public RepBoard selectByNo(int boardNo) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectOne("com.day.dto.RepBoardMapper.selectByNo", boardNo);
		} catch (Exception e) {
			throw new FindException(e.getMessage());	
		} finally {
			session.close();
		}
	}

	@Override
	public List<RepBoard> selectAll() throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectList("com.day.dto.RepBoardMapper.selectAll");
		} catch (Exception e) {
			throw new FindException(e.getMessage());	
		} finally {
			session.close();
		}
	}

	@Override
	public List<RepBoard> selectByWord(String word) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectList("com.day.dto.RepBoardMapper.selectByWord", word);
		} catch (Exception e) {
			throw new FindException(e.getMessage());	
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional(rollbackFor = ModifyException.class)
	public void plusViewCount(int boardNo) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.update("com.day.dto.RepBoardMapper.plusViewCount", boardNo);
		} catch (Exception e) {
			throw new ModifyException(e.getMessage());	
		} finally {
			session.close();
		}
	}

	@Override
	@Transactional(rollbackFor = ModifyException.class)
	public void update(RepBoard repBoard) throws ModifyException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.update("com.day.dto.RepBoardMapper.update", repBoard);
		} catch (Exception e) {
			throw new ModifyException(e.getMessage());	
		} finally {
			session.close();
		}
	}

	// 댓글 삭제
	@Override
	@Transactional(rollbackFor = RemoveException.class)
	public void delete(int no) throws RemoveException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.delete("com.day.dto.RepBoardMapper.deleteComment", no);
		} catch (Exception e) {
			throw new RemoveException(e.getMessage());	
		} finally {
			session.close();
		}
	}

	// 원글 삭제
	@Override
	@Transactional(rollbackFor = RemoveException.class)
	public void delete(RepBoard repBoard) throws RemoveException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			deleteReply(session, repBoard.getBoardNo());
			deleteWrite(session, repBoard);
		} finally {
			session.close();
		}
	}
	
	public void deleteReply(SqlSession session, int BoardNo) throws RemoveException {
		try {
			session.delete("com.day.dto.RepBoardMapper.deleteComment", BoardNo);
		} catch (Exception e) {
			throw new RemoveException(e.getMessage());	
		}
	}
	
	public void deleteWrite(SqlSession session, RepBoard repBoard) throws RemoveException {
		try {
			session.delete("com.day.dto.RepBoardMapper.deletePost", repBoard);
		} catch (Exception e) {
			throw new RemoveException(e.getMessage());	
		}
	}
	
	
	
	

}
