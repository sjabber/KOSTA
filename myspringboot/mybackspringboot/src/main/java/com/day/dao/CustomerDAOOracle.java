package com.day.dao;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.ModifyException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("customerDAO")
public class CustomerDAOOracle implements CustomerDAO {
//	@Autowired
//	private DataSource ds;
	
	
	public CustomerDAOOracle() throws Exception {
		// JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//return;
		}
	}

	@Autowired
	private SqlSessionFactory sessionFactory;
	@Override
	public void insert(Customer c) throws AddException { // insert
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.day.dto.CustomerMapper.insert", c);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Customer selectById(String id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Customer customer = session.selectOne("com.day.dto.CustomerMapper.selectById", id);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
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
		} catch (Exception e) {
			e.printStackTrace();
			throw new ModifyException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		/*Connection con = null;

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
		}*/
	}
}
