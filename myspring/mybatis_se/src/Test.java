import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.day.dto.Product;

public class Test {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; //"org/mybatis/example/mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            //---------------------------------------
            Product product = session.selectOne("com.day.dto.ProductMapper.selectByNo", "C0001");
            System.out.println(product);

            //----------------------------------
/*            List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAll");
            System.out.println(list);

            //-----------------------------------
            HashMap<String, Integer> map = new HashMap<>();
            map.put("currentPage", 2);
            map.put("cnt_per_page", 4);
            List<Product> listCurrentPage = session.selectList("com.day.dto.ProductMapper.selectAllPage", map);

            for (Product p1 : listCurrentPage) {
                System.out.println(p1);
            }*/

            //-------------------------
            //List<Product> listName = session.selectList("com.day.dto.ProductMapper.selectByName", "%아%");
            //List<Product> listName = session.selectList("com.day.dto.ProductMapper.selectByName", "아");
/*            HashMap<String, String> map1 = new HashMap<>();
            map1.put("word", "리");
            map1.put("ordermethod", "prod_name");
            List<Product> listName = session.selectList("com.day.dto.ProductMapper.selectByName", map1);
            System.out.println(listName);

            //--------------------------
            System.out.println("고객추가");
            HashMap<String, Object> mapCustomer = new HashMap<>();*/
//            mapCustomer.put("id", "id11");
//            mapCustomer.put("pwd", "pwd11");
//            mapCustomer.put("name", "이름10");
//            mapCustomer.put("buildingno", "1");
//            session.insert("com.day.dto.CustomerMapper.insert", mapCustomer);

//            Customer c = new Customer();
//            c.setId("id13");
//            c.setPwd("p111");
//            c.setName("이름11");
//            c.setBuildingno("1");
//            session.insert("com.day.dto.CustomerMapper.insert", c);
//            session.commit();

            //--------------------------
/*            System.out.println("고객정보 수정");
            Customer c1 = new Customer();
            c1.setId("id13");
            //c1.setEnabled(0); //탈퇴처리
            c1.setPwd("test1234!"); //비밀번호 변경
            c1.setName("김태호"); //이름 변경
            int rowcnt = session.update("com.day.dto.CustomerMapper.update", c1);
            session.commit();*/

            //--------------------------
/*            System.out.println("고객정보 삭제");
            String id = "id13";
            int rowcnt = session.delete("com.day.dto.CustomerMapper.delete", id); //return값 => 처리건수
            if (rowcnt == 1) {

            } else if(rowcnt < 1) {
                System.out.println(id + "가 없어 삭제안됨.");
            }
            session.commit();*/


/*            Customer c2 = session.selectOne("com.day.dto.CustomerMapper.selectById", "id1");
            System.out.println(c2);*/

            OrderInfo info1 = new OrderInfo();
            Customer order_c = new Customer();
            order_c.setId("id1");
            info1.setOrder_c(order_c);

            List<OrderLine> lines1 = new ArrayList<>();
            OrderLine line1 = new OrderLine();
            Product order_p = new Product();
            order_p.setProd_no("G0001");
            line1.setOrder_p(order_p);
            line1.setOrder_quantity(10);
            lines1.add(line1);

            info1.setLines(lines1);

            session.insert("com.day.dto.OrderMapper.insertInfo", info1);

            for (OrderLine line2: info1.getLines()) {
                session.insert("com.day.dto.OrderMapper.insertLine", line2);
            }
            session.commit();


            List<OrderInfo> list = session.selectList("com.day.dto.OrderMapper.selectById", "id1");
            System.out.println("id1 고객의 주문목록");
            for (OrderInfo info : list) {
                int order_no = info.getOrder_no();
                Date order_dt = info.getOrder_dt();
                System.out.println("------------주문번호 : " + order_no + "주문일자:" + order_dt + "------------");
                List<OrderLine> lines = info.getLines();
                for (OrderLine line : lines) {
                    Product p1 = line.getOrder_p();
                    int quantity = line.getOrder_quantity();
                    System.out.println("상품번호: " + p1.getProd_no() + ", 상품명: " + p1.getProd_name()  +
                            ", 상품가격: " + p1.getProd_price() + ", 주문개수: " + quantity);
                    System.out.println("-----------------------------------------------------------------------");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
