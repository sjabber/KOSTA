package dao;

import dto.Customer;
import exception.AddException;
import exception.FindException;
import exception.ModifyException;
import jdbc.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDAOOracle implements CustomerDAO {

    public CustomerDAOOracle() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("JDBC 연결완료");
    }

    @Override
    public void insert(Customer c) throws AddException {
        // DB 연결
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddException(e.getMessage());
        }

        String query = "INSERT INTO customer(id, pwd, name, buildingno) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        //ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, c.getId());
            pstmt.setString(2, c.getPwd());
            pstmt.setString(3, c.getName());
            pstmt.setString(4, c.getBuildingno());
            pstmt.executeQuery();
            System.out.println("회원 가입 되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddException(e.getMessage());
        } finally {
            // DB연결 해제
            MyConnection.close(con, pstmt, null);
        }
    }

    @Override
    public Customer selectById(String id) throws FindException {
        // DB 연결
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        }

        String query = "SELECT * FROM customer WHERE id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String c_id = rs.getString("id");
                String c_pwd = rs.getString("pwd");
                String c_name = rs.getString("name");
                String c_buildingno = rs.getString("buildingno");

                Customer p = new Customer(c_id, c_pwd, c_name, c_buildingno);
                return p;
            }
            throw new FindException("해당 회원 정보가 없습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        } finally {
            // DB연결 해제
            MyConnection.close(con, pstmt, rs);
        }
    }

    @Override
    public void update(Customer c) throws ModifyException {
        // DB 연결
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModifyException(e.getMessage());
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "";


        if (c.getPwd().equals("")) { // Note 회원 탈퇴
            query = "UPDATE customer SET enabled = 0 WHERE id = ?";
            try {
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, c.getId());

                rs = pstmt.executeQuery();
                System.out.println("회원 탈퇴 되었습니다..");

            } catch (SQLException e) {
                e.printStackTrace();
                throw new ModifyException(e.getMessage());
            } finally {
                // DB 연결 해제
                MyConnection.close(con, pstmt, rs);
            }
        } else { // Note 회원 정보 수정
            query = "Update customer SET pwd = ?, name = ?, buildingno = ? WHERE id = ?";
            try {
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, c.getPwd());
                pstmt.setString(2, c.getName());
                pstmt.setString(3, c.getBuildingno());
                pstmt.setString(4, c.getId());
                rs = pstmt.executeQuery();
                System.out.println("회원 정보가 수정되었습니다.");

            } catch (SQLException e) {
                e.printStackTrace();
                throw new ModifyException(e.getMessage());
            } finally {
                // DB 연결해제
                MyConnection.close(con, pstmt, rs);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("회원가입");
        System.out.println("---------------------");
        System.out.print("아이디를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("패스워드를 입력하세요 : ");
        String pwd = sc.nextLine();
        System.out.print("회원 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("주소를 입력하세요 : ");
        String buildingno = sc.nextLine();

        try {
            CustomerDAOOracle dao = new CustomerDAOOracle();
            Customer customer = new Customer(id, pwd, name, buildingno, 1);

            // 회원 가입
            dao.insert(customer);

//            // 로그인 / 회원 정보 조회
            Customer c = dao.selectById(id);
            System.out.println(c);
//
//            // 회원 탈퇴 / 회원 정보 수정
//            dao.update(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
