package dao;

import dto.Product;
import exception.FindException;
import jdbc.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductDAOOracle implements ProductDAO {

    public ProductDAOOracle() throws Exception {
        // JDBC 드라이버 로드
        // 무조건 트라이캐치를 쓰는것도
        // 무조건 throws를 쓰는것도 아니다. => 상황에 알맞게 사용해줘야 한다.
        // upCasting 하여 throws (떠넘기기) 한다.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("JDBC 드라이버 로드 성공");
    }

    /**
     * 전체상품 목록 검색하여 리스트 형태로 반환해주는 메서드
     * **/
    @Override
    public List<Product> selectAll() throws FindException {
        //DB연결
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        }

        String selectALLSQL = "SELECT * FROM product ORDER BY prod_no ASC";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(selectALLSQL);
            rs = pstmt.executeQuery();
            //rs.next(); // true OR false 반환

            while (rs.next()) {
                // 행의 컬럼값 얻기
                String prod_no = rs.getString("prod_no");
                String prod_name = rs.getString("prod_name");
                int prod_price = rs.getInt("prod_price");
                java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");

                Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
                list.add(p);
            }
            if (list.size() == 0) {
                throw new FindException("상품이 없습니다");
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();

            // 콘솔에 예외 종류, 내용, 줄번호 출력됨
            // 원래 발생한 예외를 가공하는 절차
            throw new FindException(e.getMessage());
        } finally {
            // DB 연결해제
            MyConnection.close(con, pstmt, rs);
        }
    }

    //
    @Override
    public List<Product> selectAll(int currentPage) throws FindException {
        int cnt_per_page = 4; // 페이지별 보여줄 목록수
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();

        String selectAllPageSQL = "SELECT *\n" +
                "FROM (SELECT rownum rn, a.*\n" +
                "           FROM   (SELECT *\n" +
                "                        FROM order_view \n" +
                "                        --WHERE order_dt BETWEEN '21/01/01' AND '21/03/31' \n" +
                "                        ORDER BY order_no DESC\n" +
                "                       ) a\n" +
                "          )\n" +
                "WHERE rn BETWEEN START_ROW(?, ?) AND  END_ROW(?, ?)";
        try {
            pstmt = con.prepareStatement(selectAllPageSQL);
            pstmt.setInt(1, currentPage);
            pstmt.setInt(2, cnt_per_page);
            pstmt.setInt(3, currentPage);
            pstmt.setInt(4, cnt_per_page);
            rs = pstmt.executeQuery();
            // TODO
            while(rs.next()) {
                // 행의 컬럼값 얻기
                String prod_no = rs.getString("prod_no");
                String prod_name = rs.getString("prod_name");
                int prod_price = rs.getInt("prod_price");
                java.sql.Date prod_mf_dt = rs.getDate("prod_mf_dt");

                Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
                list.add(p);
            }
            if (list.size() == 0) {
                throw new FindException("상품이 없습니다.");
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();

            // 콘솔에 예외 종류, 내용, 줄번호 출력됨
            // 원래 발생한 예외를 가공하는 절차
            throw new FindException(e.getMessage());
        } finally {
            // DB 연결해제
            MyConnection.close(con, pstmt, rs);
        }

        // 전체건수 : 7건, 총페이지수 : 2페이지
    }

    @Override
    public Product selectByNo(String prod_no) throws FindException {
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "SELECT PROD_NO, PROD_NAME, PROD_PRICE, PROD_MF_DT FROM PRODUCT WHERE PROD_NO = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, prod_no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String prod_number = rs.getString("prod_no");
                String prod_name = rs.getString("prod_name");
                int prod_price = rs.getInt("prod_price");
                Date prod_mf_dt = rs.getDate("prod_mf_dt");

                Product p = new Product(prod_number, prod_name, prod_price, prod_mf_dt, null);
                return p;
            }
            // 이런식으로 예외처리가 쌉가능하다~
            throw new FindException("상품이 없습니다.");

        } catch (SQLException e) {
            e.printStackTrace();

            // 콘솔에 예외 종류, 내용, 줄번호 출력됨
            // 원래 발생한 예외를 가공하는 절차
            throw new FindException(e.getMessage());
        } finally {
            // DB 연결해제
            MyConnection.close(con, pstmt, rs);
        }
    }

    @Override
    public List<Product> selectByName(String word) throws FindException {
        // DB 연결
        Connection con = null;
        try {
            con = MyConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();
        String selectByName = "SELECT * FROM PRODUCT WHERE PROD_NAME LIKE ? ORDER BY prod_no";

        // SQL 구문 송신, 수신
        // 수신결과를 List화, 반환
        try {
            pstmt = con.prepareStatement(selectByName);
            pstmt.setString(1, "%" + word + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String prod_no = rs.getString("prod_no");
                String prod_name = rs.getString("prod_name");
                int prod_price = rs.getInt("prod_price");
                Date prod_mf_dt = rs.getDate("prod_mf_dt");

                Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, null);
                list.add(p);
            }

            if (list.size() == 0) {
                throw new FindException("상품이 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        } finally {
            // DB연결 해제
            MyConnection.close(con, pstmt, rs);
        }
        return list;
    }

    public static void main(String[] args) {

//        System.out.print("시작 페이지를 입력하세요 : ");
//        Scanner sc = new Scanner(System.in);
//        int currentPage = sc.nextInt();

//        try {
//            ProductDAOOracle dao = new ProductDAOOracle();
//            List<Product> all = dao.selectAll(currentPage);
//
//            for (Product p : all) {
//                System.out.println(p); // p.toString() 자동호출
//            }
//
//        } catch (FindException e) {
//            // Select 오류 => FindException
//            // 객체생성 오류 => Exception
//            // => Exception 처리를 다르게 하기 위함이다.
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        String prod_no = "X0001";
//        try {
//            ProductDAOOracle dao = new ProductDAOOracle();
//            Product p = dao.selectByNo(prod_no);
//            System.out.println(prod_no + "번 상품정보");
//            System.out.println(p);
//
//        } catch (FindException e) {
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println("\"" + word + "\" 단어를 포함한 상품목록");
        try {
            ProductDAOOracle dao = new ProductDAOOracle();
            List<Product> list = dao.selectByName(word);
            for (Product p : list) {
                System.out.println(p);
            }

        } catch (FindException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
