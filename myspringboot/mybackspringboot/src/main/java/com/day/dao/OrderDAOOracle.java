package com.day.dao;

import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.exception.AddException;
import com.day.exception.FindException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("orderDAO")
public class OrderDAOOracle implements OrderDAO {

    @Autowired
    private SqlSessionFactory sessionFactory;

    @Transactional
    public void test() {
        String str = null;
        System.out.println(str.length());
    }

    @Override
    @Transactional(rollbackFor = AddException.class) //프레임워크에게 트랜잭션을 맡긴다.
    public void insert(OrderInfo info) throws AddException {
        SqlSession session = null;
        try {
            session = sessionFactory.openSession();
            insertInfo(session, info);
            insertLines(session, info.getLines());
            session.commit();
        } catch (Exception e) {
//            try {
//                session.rollback(); //롤백
//            } catch (Exception e1) {
//
//            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<OrderInfo> selectById(String id) throws FindException {
        SqlSession session = null;
        try {
            session = sessionFactory.openSession();
            List<OrderInfo> list = session.selectList("com.day.dto.OrderMapper.selectById", id);
            System.out.println("in daooracle");
            System.out.println(list.get(0).getLines().get(0).getOrder_p());
            if (list.size() == 0) {
                throw new FindException("주문내역이 없습니다.");
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void insertInfo(SqlSession session, OrderInfo info) throws AddException {
        try {
            session = sessionFactory.openSession();
            session.insert("com.day.dto.OrderMapper.insertInfo", info);
            session.commit();
        } catch (Exception e) {
            try {
                session.rollback(); //롤백
                e.printStackTrace();
                throw new AddException("추가 실패" + e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void insertLines(SqlSession session, List<OrderLine> lines) throws AddException {
        try {
            for (OrderLine line : lines) {
                session.insert("com.day.dto.OrderMapper.insertLine", line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AddException("주문상세 추가실패:" + e.getMessage());
        }
    }
}
