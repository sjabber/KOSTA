package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Customer;
import dto.OrderInfo;
import dto.OrderLine;
import dto.Product;
import exception.AddException;
import exception.FindException;
import jdbc.MyConnection;

public class OrderDAOOracle implements OrderDAO {

    @Override
    public void insert(OrderInfo info) throws AddException {
        //DB연결
        Connection con = null;
        try {
            con = MyConnection.getConnection();
            con.setAutoCommit(false); //자동커밋 해제
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddException(e.getMessage());
        }
        try {
            insertInfo(con, info);
            insertLines(con, info.getLines());
            con.commit(); //커밋
        } catch (Exception e) {
            try {
                con.rollback(); //롤백
            } catch (SQLException e1) {
            }
            throw new AddException(e.getMessage());
        } finally {
            MyConnection.close(con, null, null);
        }
    }

    /**
     * 주문 기본정보를 추가한다.
     *
     * @param con  DB연결객체
     * @param info 주문 기본정보
     * @throws AddException
     */
    private void insertInfo(Connection con, OrderInfo info) throws AddException {
        //SQL송신
        PreparedStatement pstmt = null;
        String insertInfoSQL = "INSERT INTO order_info(order_no, order_id) VALUES (ORDER_SEQ.NEXTVAL, ?)";
        try {
            pstmt = con.prepareStatement(insertInfoSQL);
            pstmt.setString(1, info.getOrder_c().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddException("주문 기본추가 실패!!!" + e.getMessage());
        } finally {
            MyConnection.close(null, pstmt, null);
        }

    }

    /**
     * 주문 상세 정보를 추가한다.
     *
     * @param con   DB연결객체
     * @param lines 주문 상세정보들
     * @throws AddException
     */
    private void insertLines(Connection con, List<OrderLine> lines) throws AddException {
        PreparedStatement pstmt = null;
        String insertLineSQL = "INSERT INTO order_line(order_no, order_prod_no, order_quantity) VALUES (ORDER_SEQ.CURRVAL, ?, ?)";

        try {
            pstmt = con.prepareStatement(insertLineSQL);
            for (OrderLine line : lines) {
                pstmt.setString(1, line.getOrder_p().getProd_no());
                pstmt.setInt(2, line.getOrder_quantity());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AddException("주문 상세추가 실패!!!" + e.getMessage());
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
        String selectByIdSQL = "SELECT oi.order_no, order_dt, order_prod_no, prod_name, prod_price FROM order_info oi "
                + "JOIN order_line ol ON(oi.order_no = ol.order_no) "
                + "JOIN product p ON(ol.order_prod_no = p.prod_no)"
                + "WHERE order_id = ? "
                + "ORDER BY oi.order_no DESC, order_prod_no ASC";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<OrderInfo> list = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(selectByIdSQL);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int order_no = rs.getInt("order_no");
                java.sql.Date order_dt = rs.getDate("order_dt");
                String order_prod_no = rs.getString("order_prod_no");
                String prod_name = rs.getString("prod_name");
                int prod_price = rs.getInt("prod_price");

                OrderInfo o = new OrderInfo();


            }
            if (list.size() == 0) {
                throw new FindException("주문내역이 없습니다.");
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

        OrderDAOOracle dao = new OrderDAOOracle();
        OrderInfo info = new OrderInfo();

        Customer c = new Customer();
        c.setId("id1");
        info.setOrder_c(c);

        List<OrderLine> lines = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
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
