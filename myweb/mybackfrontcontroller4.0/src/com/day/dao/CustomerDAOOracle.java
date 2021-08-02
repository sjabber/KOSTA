package com.day.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import com.day.sql.MyConnection;

public class CustomerDAOOracle implements CustomerDAO {

	public CustomerDAOOracle() throws Exception {

		// JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void insert(Customer c) throws AddException { // insert

		Connection con = null;
		try {
			con = MyConnection.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());// 사용자에게 떠넘긴다. => 사용자 = service.java
		}

		String insertSQL = "INSERT INTO customer (id, pwd, name) VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getPwd());
			pstmt.setString(3, c.getName());

			int rowcnt = pstmt.executeUpdate();
			System.out.println("총 " + rowcnt + "건의 행이 추가되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, null);
		}

	}

	@Override
	public Customer selectById(String id) throws FindException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}

		String selectSQL = "SELECT * FROM customer WHERE id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");

				Customer c = new Customer(id, pwd, name);
				System.out.println("로그인 성공");
				return c;
			}

			throw new FindException("존재하지 않는 아이디입니다.");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, rs);
		}

	}
	@Override
	public void update(Customer c) throws ModifyException {

		Connection con = null;

		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String updateSQL = "UPDATE customer SET "; //pwd = 'p1', name = 'n1', buildingno='1'
		String updateSQL1 = " WHERE id = ?";

		boolean flag = false; //변경할 값이 있는 경우 true

		String pwd = c.getPwd();
		if( pwd != null && !pwd.equals("")) {
			updateSQL += "pwd = '" + pwd + "'";
			flag = true;
		}

		String name = c.getName();
		if( name != null && !name.equals("")) {
			if(flag) {
				updateSQL += ",";
			}
			updateSQL += "name = '" + name + "'";
			flag = true;
		}

		String buildingno = c.getBuildingno();
		if( buildingno != null && !buildingno.equals("")) {
			if(flag) {
				updateSQL += ",";
			}
			updateSQL += "buildingno = '" + buildingno + "'";
			flag = true;
		}


		int enabled = c.getEnabled();
		if( enabled > -1 ) { //0-탈퇴, 1-활동
			if(flag) {
				updateSQL += ",";
			}
			updateSQL += "enabled = '" + enabled + "'";
			flag = true;
		}

		System.out.println(updateSQL + updateSQL1);
		if(!flag) {
			throw new ModifyException("수정할 내용이 없습니다");
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(updateSQL + updateSQL1);
			pstmt.setString(1, c.getId());
			int rowcnt = pstmt.executeUpdate(); // 이름이 변경된 건수
			System.out.println("총 " + rowcnt + "건이 변경되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, null);
		}
	}

	public void Myupdate(Customer c) throws ModifyException {

		Connection con = null;

		try {
			con = MyConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String updateSQL = "UPDATE customer SET ";
		if (c.getEnabled() == 0) {
			updateSQL += "enabled = '0'";

		} else {

			if (c.getPwd().equals("") && c.getName().equals("") && c.getBuildingno().equals("")) {
				System.out.println("변경할 내용이 없습니다");
				return;
			}

			if (!c.getPwd().equals("")) {
				updateSQL += "pwd = '" + c.getPwd() + "', ";
			}

			if (!c.getName().equals("")) {
				updateSQL += "name = '" + c.getName() + "', ";
			}

			if (!c.getBuildingno().equals("")) {
				updateSQL += "buildingno = '" + c.getBuildingno() + "', ";
			}

			updateSQL = updateSQL.substring(0, updateSQL.length() - 2);
		}

		updateSQL += " WHERE id ='" + c.getId() + "'";

		System.out.println(updateSQL);
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			int rowcnt = stmt.executeUpdate(updateSQL); // 이름이 변경된 건수
			System.out.println("총 " + rowcnt + "건이 변경되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		} finally {
			MyConnection.close(con, stmt, null);
		}
	}

	public static void main(String[] args) {

//		signUp();

//		logIn();

		modify();

	}

	public static void modify() {

		CustomerDAOOracle dao = null;
		try {
			dao = new CustomerDAOOracle();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Customer c = new Customer();
		c.setId("id1");
		//c.setPwd("pp1");
		c.setName("nn1");
		//c.setBuildingno("b1");
		c.setEnabled(-1);
		try {
			dao.update(c);
		} catch (ModifyException e) {
			e.printStackTrace();
		}


//		CustomerDAOOracle dao;
//		Customer c = new Customer("id1", "", "", "북한");
//		c.setEnabled(1);
//		System.out.println("c.getEnabled :" + c.getEnabled());
//		try {
//			dao = new CustomerDAOOracle();
//			dao.update(c);
//		} catch (ModifyException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
	}

	public static void logIn() {
		CustomerDAOOracle dao;

		try {
			dao = new CustomerDAOOracle();
			Customer c = dao.selectById("id1");
		} catch (FindException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void signUp() {
		Customer c = new Customer("id11", "p11", "이름11", "오리역");

		CustomerDAOOracle dao;
		try {
			dao = new CustomerDAOOracle();
			dao.insert(c);

		} catch (AddException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
