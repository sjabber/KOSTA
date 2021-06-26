package jdbc2;

import java.sql.*;

public class MyConnection {

    private static Connection con;
    public boolean isOpened = false;

    public static Connection getConnection() throws SQLException {
        con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "1673";

        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {

        // DB연결닫기
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
