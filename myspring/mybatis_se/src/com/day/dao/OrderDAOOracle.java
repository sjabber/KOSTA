/*
package com.day.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.sql.MyConnection;

public class OrderDAOOracle implements OrderDAO {

	@Override
	public void insert(OrderInfo info) throws AddException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false); // �ڵ�Ŀ�� ���� (insertInfo, insertLines ���� �ϳ��� �����ϸ� �ǵ����� ���� �ڵ�Ŀ�� ����)
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage()); // ���ῡ�� ���� ����� �ٷ� ���� ������
		}
		try {
			insertInfo(con, info); // �ֹ��⺻ �߰�
			insertLines(con, info.getLines()); // �ֹ��� �߰�
			// �� �� �޼ҵ� ���ο��� AddException�� throws ���ѱ��,
			// try/finally���� ���ܰ� �� ���̰� throws�� ���ܸ� �ٽ� ���ѱ��.
			con.commit(); // Ŀ��
		} catch (Exception e) {
			try {
				con.rollback(); // �ѹ�
			} catch (SQLException e1) {
				// e1.printStackTrace(); �ѹ� ���д� ���� �˸��� ����.
			}
			throw new AddException(e.getMessage()); // rollback() ���и� �˸�.

		} finally {

			MyConnection.close(con, null, null);// throw ���� ���ѱ���� close �ϰ� ���Ѱܶ�.
		}
	}

	*/
/**
	 * �ֹ��⺻���� �߰��Ѵ�.
	 * 
	 * @param con  DB���ᰴü
	 * @param info �ֹ��⺻����
	 * @throws AddException
	 *//*

	private void insertInfo(Connection con, OrderInfo info) throws AddException {
		// SQL�۽�
		PreparedStatement pstmt = null;
		String insertInfoSQL = "INSERT INTO order_info(order_no, order_id) " + " VALUES (ORDER_SEQ.NEXTVAL, ?)";
		try {
			pstmt = con.prepareStatement(insertInfoSQL);
			pstmt.setNString(1, info.getOrder_c().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException("�ֹ��⺻�߰����� : " + e.getMessage());
		} finally {
			MyConnection.close(null, pstmt, null); //
			// �ֹ��⺻ �߰� �� �ֹ��󼼸� �ٷ� �߰��ؾ� �ϴ� con�� close���� �ʴ´�.
		}
	}

	private void insertLines(Connection con, List<OrderLine> lines) throws AddException {
		PreparedStatement pstmt = null;
		String insertLineSQL = "INSERT INTO order_line(order_no, order_prod_no, order_quantity)"
				+ " VALUES (ORDER_SEQ.CURRVAL, ?, ? )"; // 'C0001', 3
		try {
			pstmt = con.prepareStatement(insertLineSQL);
			for (OrderLine line : lines) {
				pstmt.setString(1, line.getOrder_p().getProd_no());
				pstmt.setInt(2, line.getOrder_quantity());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException("�ֹ��� �߰����� : " + e.getMessage());
		} finally {
			MyConnection.close(null, pstmt, null);
		}

	}

	@Override
	public List<OrderInfo> selectById(String id) throws FindException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}

		String selectByIdSQL = "SELECT oi.order_no, order_dt, order_prod_no, prod_name, prod_price, order_quantity \r\n"
				+ "FROM order_info oi JOIN order_line ol ON(oi.order_no = ol.order_no)\r\n"
				+ "JOIN product p  ON (ol.order_prod_no = p.prod_no)\r\n" + "WHERE order_id = ? \r\n"
				+ "ORDER BY oi.order_no DESC, order_prod_no";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<OrderInfo> list = new ArrayList<>();
		List<OrderLine> lines = null;
		int oldOrder_no = 0;
		
//		OrderInfo info = new OrderInfo();  (X)
//		OrderLine line = new OrderLine();  (X)
//		Product prod = new Product();      (X)
		
		try {
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int order_no = rs.getInt("order_no");
				
				if (oldOrder_no != order_no) {
					oldOrder_no = order_no;

					OrderInfo info = new OrderInfo(); // (O)
					info.setOrder_no(order_no);
					info.setOrder_dt(rs.getDate("order_dt"));
					
					lines = new ArrayList<>();        // (O)
					info.setLines(lines); 
					
					list.add(info);
				}
								
		
				Product prod = new Product();  // (O)
				prod.setProd_no(rs.getString("order_prod_no"));
				prod.setProd_name(rs.getString("prod_name"));
				prod.setProd_price(rs.getInt("prod_price"));
				
				OrderLine line = new OrderLine();  // (O)
				line.setOrder_no(order_no);
				line.setOrder_p(prod);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				
				lines.add(line);        // (O)
				
			}

			if (list.size() == 0) {
				throw new FindException("�ֹ������� �����ϴ�");
			}

			return list; // if�� ��ġ�� ������ ��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, rs);
		}
	}

	
	
	
	public static void main(String[] args) {
		selectByIdTest();
//		insertTest();
	}

	public static void selectByIdTest() {
		OrderDAOOracle dao = new OrderDAOOracle();

		try {
			List<OrderInfo> list = dao.selectById("id1");
			System.out.println("list.size() " + list.size());
			System.out.println("getOrder_no :" + list.get(0).getOrder_no());
			System.out.println("getOrder_no :" + list.get(1).getOrder_no());
			System.out.println("getOrder_no :" + list.get(2).getOrder_no());
			System.out.println(list.get(0).getLines());
			System.out.println(list.get(1).getLines());
			System.out.println(list.get(2).getLines());
			System.out.println("getOrder_no :" + list.get(0).getLines().get(1).getOrder_p().getProd_name());
			System.out.println("getOrder_no :" + list.get(0).getLines().get(2).getOrder_p().getProd_name());

			System.out.println(list.get(0));

		} catch (FindException e) {
			e.printStackTrace();
		}
	}

	public static void insertTest() {
		OrderDAOOracle dao = new OrderDAOOracle();

		OrderInfo info = new OrderInfo();
		Customer c = new Customer();
		c.setId("id1");
		info.setOrder_c(c);

		List<OrderLine> lines = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			OrderLine line = new OrderLine();
			Product p = new Product();
			p.setProd_no("C000" + i);
			line.setOrder_p(p);
			line.setOrder_quantity(i);
			lines.add(line);
		}
		info.setLines(lines);

		try {
			dao.insert(info);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}


}
*/
