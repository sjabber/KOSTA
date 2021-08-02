package com.day.dao;
//package com.day.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.sql.MyConnection;
import org.springframework.stereotype.Repository;

@Repository("productDAO1")
public class ProductDAOOracle implements ProductDAO {
	/**
	 * 상품 전체 검색한다.
	 * 
	 * @Return 상품 전체를 반환한다. 상품이 존재하지 않으면 null값을 반환한다.
	 * @throws FindException 상품이 없을 경우 또는 상품 찾기를 실패할 경우 발생한다.
	 */

	public ProductDAOOracle() throws Exception {

		// JDBC 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 상품 전체 검색한다.
	 * 
	 * @param currentPage 페이지
	 * @Return page에 해당하는 상품들
	 * @throws FindException 상품이 없을 경우 또는 상품 찾기를 실패할 경우 발생한다.
	 */
	@Override
	public List<Product> selectAll() throws FindException {
		// DB연결

		Connection con = null;
		try {
			con = MyConnection.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());// 사용자에게 떠넘긴다. => 사용자 = service.java
		}

		String selectALLSQL = "SELECT * FROM product ORDER BY prod_no ASC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Product> list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(selectALLSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");

				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				list.add(p);
			}

			if (list.size() == 0) {
				throw new FindException("상품이 없습니다"); //
			}
			return list; // return이 앞이지만 finally를 거친 후 return이 된다.

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); // 검색하다가 발생한 예외라는 것임을 알려주기 위해 SQLException을 가공해서 예외를 던짐.
		} finally {

			MyConnection.close(con, pstmt, rs);
		}
		// return list; // catch에 throw new FindException(e.getMessage()); 넣어준 후 return
		// list; 제거 가능해짐.
	}

	
	/**
	 * 상품번호로 검색한다.
	 * 
	 * @param prod_no 상품번호
	 * @return 상품번호에 해당하는 상품
	 * @throws FindException FindException 상품이 없을 경우 또는 상품 찾기를 실패할 경우 발생한다.
	 */
	@Override
	public List<Product> selectByName(String word) throws FindException {

		Connection con = null;
		try {
			con = MyConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); // 검색 중에 예외 발생함을 명시함
		}

		String selectByNameSQL = "SELECT * FROM product WHERE prod_name LIKE ? ORDER BY prod_no";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<>();
		try {
			System.out.println("%" + word + "%");
			
			pstmt = con.prepareStatement(selectByNameSQL);
			pstmt.setString(1, "%" + word + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				Date prod_md_dt = rs.getDate("prod_mf_dt");
				Product p = new Product(prod_no, prod_name, prod_price, prod_md_dt, null);
				list.add(p);
			}

			if (list.size() == 0) {
				throw new FindException("상품이 없습니다.");
				// 찾지 못한 상황. catch가 없으므로 메소드명 옆에 throws FindException로 던진다.
			}
			return list; // finally 직후 반환한다 ?

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); // 찾기 실패 메시지
		} finally {
			MyConnection.close(con, pstmt, rs);
		}

	}
	

	/**
	 * 상품명으로 검색한다.
	 * 
	 * @param word 상품명에 해당하는 단어
	 * @return 단어를 포함한 상품들
	 * @throws FindException 상품이 없을 경우 또는 상품찾기를 실패한 경우 발생한다.
	 */
	@Override
	public Product selectByNo(String prod_no) throws FindException {
		Connection con = null;

		try {
			con = MyConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); // 검색 중에 예외 발생함을 명시함
		}

		String selectNyNoSQL = "SELECT * FROM product WHERE prod_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product p = null;

		try {
			pstmt = con.prepareStatement(selectNyNoSQL);
			pstmt.setString(1, prod_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");

				System.out.println(prod_no + ":" + prod_name + ":" + prod_price + ":" + prod_mf_dt);

				p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				return p;

			}
			throw new FindException("상품이 없습니다"); //

		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			com.day.sql.MyConnection.close(con, pstmt, rs);
		}
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {

		List<Product> list = new ArrayList<>();
		int cnt_per_page = 4;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage()); // 검색 중에 예외 발생함을 명시함
		}

		PreparedStatement pstmt = null;
		String selectAllPageSQL = "SELECT * " + "FROM (SELECT rownum rn, a.* " + " FROM (SELECT * "
				+ "                        FROM order_view  "
				+ "                        --WHERE order_dt BETWEEN '21/01/01' AND '21/03/31'  "
				+ "                        ORDER BY order_no DESC " + ") a "
				+ "          ) " + "WHERE rn BETWEEN START_ROW(?, ?) AND  END_ROW(?, ?)";
		try {
			pstmt = con.prepareStatement(selectAllPageSQL);
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2, cnt_per_page);
			pstmt.setInt(3, currentPage);
			pstmt.setInt(4, cnt_per_page);
			rs = pstmt.executeQuery();

			System.out.println("SQL구문을 DB에 수신, 결과 수신");

			while (rs.next()) { // next() : 결과 행의 커서를 다음 행으로 이동하는 메소드
				
				String prod_no = rs.getString("prod_no");
				String prod_name = rs.getString("prod_name");
				int prod_price = rs.getInt("prod_price");
				java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");

				System.out.println(prod_no + ":" + prod_name + ":" + prod_price + ":"+ prod_mf_dt);

				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
				list.add(p);
			}
			if (list.size() == 0) {
				throw new FindException("상품이 없습니다"); //
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(con, pstmt, rs);
		}

	}

	public static void main(String[] args) {
//		try {
//			ProductDAOOracle dao = new ProductDAOOracle();
//
//			// 상품번호로 1건 조회
////			dao.selectByNo("C0001");
//
//			// 전체 상품 조회
//			List<Product> all = dao.selectAll(4);
//			for (Product p : all) {
//				System.out.println(p);
//			}
//
//		} catch (FindException e) { // 다중 catch 작성 시 자식 Exception 먼저 아래에 부모 Exception 작성해야 컴파일 오류 방지
//			System.out.println(e.getMessage());
//		} catch (Exception e) { // FindException 없이 Exception만 두면 FindException가 업캐스팅되서 잡히긴 하는데, 상세한 파악을 위해 다중
//								// catch로 하자.
//			e.printStackTrace(); // new ProductDAOOracle(); 에서 발생한 예외 잡기
//			System.out.println(e.getMessage());
//		}
		
		String word = "리";
		System.out.println(word+ " 단어를 포함한 상품목록");
		
		try {
			ProductDAOOracle dao = new ProductDAOOracle();
			List<Product> list = dao.selectByName(word);
			for(Product p: list) {
				System.out.println(p);
			}
		}catch(FindException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

}


////전달받은 코드
//
//public static void testSELECT(String id) {
//		//DB연결
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String password = "hr";
//		Connection con = null;
//		try {
//			con = DriverManager.getConnection(url, user, password);
//			System.out.println("DB연결 성공");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return;
//		}
//PreparedStatement pstmt = null;
//		//SQL구문을 DB에 송신
//		String selectSQL = "SELECT * FROM customer WHERE id=?"; 
//										// ? : 바인드 변수 값을 대신함. 테이블명 등은 불가
//		//결과 수신
//		ResultSet rs = null; 
//		try {
//			pstmt = con.prepareStatement(selectSQL);
//			pstmt.setString(1, id);
//
//			rs = pstmt.executeQuery();
//
//			if(rs.next()) { //결과행의 커서를 다음행으로 이동시킨다
//				String pwd = rs.getString("pwd");
//				String name = rs.getString("name");
//				System.out.println("비밀번호는 " + pwd +", 이름은 " + name);
//			} else {
//				// 메소드가 여러 곳에서 사용될 것을 감안하면 추가 행이 없으면 
//				// 예외를 만들어서 강제로 떠넘기자.
//			}
//
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB와 연결해제
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}


////전달받은 코드
//
//public static void testUPDATE(String id, String pwd, String name) {
//		//DB연결
//		Connection con = null;
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String password = "hr";
//
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//			if("".equals(pwd) && "".equals(name)) {
//			System.out.println("변경할 내용이 없습니다");
//			return;
//		}
//
//
////SQL구문 송신
//		String updateSQL = 
//				"UPDATE customer SET ";
//
//		if(!"".equals(pwd) && !"".equals(name)) {
//			updateSQL += "pwd='" + pwd +"', name='" +name +"'";
//
//		}else if(!"".equals(name)) {
//			updateSQL += "name='" +name +"'";
//
//		}else {
//			updateSQL += "pwd='" +pwd +"'";
//		}
//		updateSQL += " WHERE id=?";
//
//
//PreparedStatement pstmt = null;
//		try {
//			pstmt = con.prepareStatement(updateSQL);
//			pstmt.setString(1, id);
//			int rowcnt = pstmt.executeUpdate();
//
//
//			if(rowcnt == 1) {
//				System.out.println(id+"고객의 내용이 변경되었습니다");
//			} else {
//				// 메소드가 여러 곳에서 사용될 것을 감안하면 변경 행이 없으면 
//				// 예외를 만들어서 강제로 떠넘기자.
//			}
//
//
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			if(pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}