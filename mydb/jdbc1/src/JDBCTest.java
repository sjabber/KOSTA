import java.sql.*;
import java.util.Scanner;

public class JDBCTest {

    public static void testSELECT(String id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("JDBC 드라이버로드 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // DB 연결
        // thin driver => 일반적으로 가장 많이 사용 (자바로만 만들어져 있음) 과 ocr driver
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "1673";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        PreparedStatement pstmt = null;
        String query = "SELECT ID, PWD, NAME FROM CUSTOMER WHERE ID = ?";

        // 결과 수신용 라이브러리 Resultset
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            System.out.println("SQL 구문을 DB에 송신, 결과 수신");

            if (rs.next()) {
                String c_id = rs.getString("ID");
                String c_pwd = rs.getString("PWD");
                String c_name = rs.getString("NAME");
                System.out.println("아이디 : " + c_id + ", 패스워드 : " + c_pwd + ", 이름 : " + c_name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 만약에 에러가 발생하게 되면 catch문으로 넘어가기 때문에 연결이 해지되지 않는 문제가 발생한다.
            // 그 때문에 연결 해제를 finally 안에서 수행한다.
            // DB와 연결해제 // 코딩량이 많아도 안전하게 짜는게 best
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testSELECT() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("JDBC 드라이버로드 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // DB 연결
        // thin driver => 일반적으로 가장 많이 사용 (자바로만 만들어져 있음) 과 ocr driver
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "1673";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        Statement stmt = null;

        // SQL구문을 DB에 송신
        String selectSQL = "SELECT employee_id," +
                " first_name," +
                " hire_date," +
                " salary," +
                " salary+(salary*NVL(commission_pct, 0)) 실급여" +
                " FROM employees";

        // 결과 수신용 라이브러리 Resultset
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(selectSQL);
            System.out.println("SQL구문을 DB에 송신, 결과 수신");

            // 결과 행을 끝까지 반복수행
            while (rs.next() == true) {
                int emp_id = rs.getInt("employee_id");
                String f_name = rs.getString(2);
                java.sql.Date hire_dt = rs.getDate("hire_date");
                int sal = rs.getInt("salary");
                float real_sal = rs.getFloat("실급여");
                System.out.println(emp_id + " : " + f_name + " : " + hire_dt + " : " + sal + " : " + real_sal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB와 연결해제
            // 만약에 에러가 발생하게 되면 catch문으로 넘어가기 때문에 연결이 해지되지 않는 문제가 발생한다.
            // 그 때문에 연결 해제를 finally 안에서 수행한다.
            // DB와 연결해제 // 코딩량이 많아도 안전하게 짜는게 best
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void testINSERT(String id, String pw, String name) {
        // DB 연결
        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "hr";
        String password = "1673";
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // SQL 구문 송신
        //String insertSQL = "INSERT INTO customer(id, pwd, name) VALUES ('" + id + "', '" + pw + "', '" + name + "')";
        String insertSQL = "INSERT INTO customer(id, pwd, name) VALUES (?, ?, ?)";

        // Statement 의 하위 인터페이스
        PreparedStatement pstmt = null;
//        Statement stmt = null;
        try {
            // Note PreparedStatement 설명
            // 전체 SQL 구문을 일단 미리 보내고 물음표에 대한 값만 따로 보낸다.
            // Note 사실상 송신을 두개로 나누어서 하는 것
            // 성능이 떨어지지 않냐?
            // => Nope! 물음표에 대한 값들만 반복수행하므로 이게 더 속도가 빠를 수 있다.
            pstmt = con.prepareStatement(insertSQL); // PreparedStatement는 매개변수를 요구한다.
            pstmt.setString(1, id); // 물음표 개수만큼 작성
            pstmt.setString(2, pw);
            pstmt.setString(3, name);
            int rowcnt = pstmt.executeUpdate(); // 마지막에는 반드시 execute 해주어야 한다.
            if (rowcnt == 1) {
                System.out.println(id + "번 고객 추가 성공");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            // DB연결닫기
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
        }
        // SQL 결과 수신
        // 결과활용
        // DB 연결 닫기
    }

    public static void testUPDATE(String id, String pwd, String name) {
        //DB 연결
        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "1673";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        String updateSQL = "";
        PreparedStatement pstmt = null;

        // SQL구문 송신
        if (pwd.equals("") && name.equals("")) {
            System.out.println("업데이트할 항목이 없습니다.");
            return;

        } else if (pwd.equals("")) {
            updateSQL = "UPDATE customer SET NAME = ? WHERE ID = ?";
            try {
                pstmt = con.prepareStatement(updateSQL);
                pstmt.setString(1, name);
                pstmt.setString(2, id);
                int row = pstmt.executeUpdate();
                // System.out.println("변경된 row : " + row);
                System.out.println(id + " 의 이름 정보가 변경되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            return;

        } else if (name.equals("")) {
            updateSQL = "UPDATE customer SET PWD = ? WHERE ID = ?";
            try {
                pstmt = con.prepareStatement(updateSQL);
                pstmt.setString(1, pwd);
                pstmt.setString(2, id);
                int row = pstmt.executeUpdate();
                // System.out.println("변경된 row : " + row);
                System.out.println(id + " 의 패스워드 정보가 변경되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            return;

        } else {
            updateSQL = "UPDATE customer SET PWD = ?, NAME = ? WHERE ID = ?";
            try {
                pstmt = con.prepareStatement(updateSQL);
                pstmt.setString(1, pwd);
                pstmt.setString(2, name);
                pstmt.setString(3, id);
                int row = pstmt.executeUpdate();
                // System.out.println("변경된 row : " + row);
                System.out.println(id + " 의 패스워드, 이름 정보가 변경되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            return;
        }
    }

//    public static void testUPDATE(String id, String pwd, String name) {
//        //DB 연결
//        Connection con = null;
//        String url = "jdbc:oracle:thin:@localhost:1521:xe";
//        String user = "hr";
//        String password = "1673";
//
//        try {
//            con = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        String updateSQL = "";
//        PreparedStatement pstmt = null;
//
//        // SQL구문 송신
//        if (pwd.equals("") && name.equals("")) {
//            System.out.println("업데이트할 항목이 없습니다.");
//            return;
//
//        } else if (pwd.equals("")) {
//            updateSQL = "UPDATE customer SET NAME = ? WHERE ID = ?";
//            try {
//                pstmt = con.prepareStatement(updateSQL);
//                pstmt.setString(1, name);
//                pstmt.setString(2, id);
//                int row = pstmt.executeUpdate();
//                // System.out.println("변경된 row : " + row);
//                System.out.println(id + " 의 이름 정보가 변경되었습니다.");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return;
//            }
//            return;
//
//        } else if (name.equals("")) {
//            updateSQL = "UPDATE customer SET PWD = ? WHERE ID = ?";
//            try {
//                pstmt = con.prepareStatement(updateSQL);
//                pstmt.setString(1, pwd);
//                pstmt.setString(2, id);
//                int row = pstmt.executeUpdate();
//                // System.out.println("변경된 row : " + row);
//                System.out.println(id + " 의 패스워드 정보가 변경되었습니다.");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return;
//            }
//            return;
//
//        } else {
//            updateSQL = "UPDATE customer SET PWD = ?, NAME = ? WHERE ID = ?";
//            try {
//                pstmt = con.prepareStatement(updateSQL);
//                pstmt.setString(1, pwd);
//                pstmt.setString(2, name);
//                pstmt.setString(3, id);
//                int row = pstmt.executeUpdate();
//                // System.out.println("변경된 row : " + row);
//                System.out.println(id + " 의 패스워드, 이름 정보가 변경되었습니다.");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return;
//            }
//            return;
//        }
//    }

    public static void testUPDATE2(String id, String pwd, String name) {
        //DB 연결
        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String password = "1673";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        String updateSQL = "";
        PreparedStatement pstmt = null;

        // SQL구문 송신
        if (pwd.equals("") && name.equals("")) {
            System.out.println("업데이트할 항목이 없습니다.");
            return;

        } else if (pwd.equals("")) {
            updateSQL = "UPDATE customer SET NAME = ? WHERE ID = ?";
            try {
                pstmt = con.prepareStatement(updateSQL);
                pstmt.setString(1, name);
                pstmt.setString(2, id);
                int row = pstmt.executeUpdate();
                // System.out.println("변경된 row : " + row);
                System.out.println(id + " 의 이름 정보가 변경되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            return;

        } else if (name.equals("")) {
            updateSQL = "UPDATE customer SET PWD = ? WHERE ID = ?";
            try {
                pstmt = con.prepareStatement(updateSQL);
                pstmt.setString(1, pwd);
                pstmt.setString(2, id);
                int row = pstmt.executeUpdate();
                // System.out.println("변경된 row : " + row);
                System.out.println(id + " 의 패스워드 정보가 변경되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            return;

        } else {
            updateSQL = "UPDATE customer SET PWD = ?, NAME = ? WHERE ID = ?";
            try {
                pstmt = con.prepareStatement(updateSQL);
                pstmt.setString(1, pwd);
                pstmt.setString(2, name);
                pstmt.setString(3, id);
                int row = pstmt.executeUpdate();
                // System.out.println("변경된 row : " + row);
                System.out.println(id + " 의 패스워드, 이름 정보가 변경되었습니다.");
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
            return;
        }
    }

    public static void main(String[] args) {
        // testSELECT();
        // testINSERT();
        // new JDBCTest().testUPDATE();
        // testUPDATE();

        // 키보드로 입력받은 id, pwd, name 값을 customer 테이블에 추가
//        Scanner sc = new Scanner(System.in);
//        System.out.print("아이디: ");
//        String idValue = sc.nextLine();
//        System.out.print("비밀번호: ");
//        String pwdValue = sc.nextLine();
//        System.out.print("이름: ");
//        String nameValue = sc.nextLine();
//        testINSERT(idValue, pwdValue, nameValue);

        // 키보드로 입력받은 id에 해당하는 고객의 비번과 이름값을 변경
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디: ");
        String idValue = sc.nextLine();
        // testSELECT(idValue); 비번과 이름과 아이디가 출력된다.

        System.out.print("비밀번호를 변경하려면 입력하세요[변경안하려면 enter를 누르세요]: ");
        String pwdValue = sc.nextLine(); // enter를 누른 경우 pwdValue 변수값은 ""가 된다.
//        System.out.println("입력한 비밀번호 값 : ["+ pwdValue +"]");

        System.out.print("이름을 변경하려면 값을 입력하세요[변경안하려면 enter를 누르세요]: ");
        String nameValue = sc.nextLine();
        testUPDATE(idValue, pwdValue, nameValue);
    }
}
