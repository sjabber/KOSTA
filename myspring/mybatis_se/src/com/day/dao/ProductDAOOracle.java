package com.day.dao;
//package com.day.dao;

import com.day.dto.Product;
import com.day.exception.FindException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

//@Repository("productDAO1")
public class ProductDAOOracle implements ProductDAO {

    private SqlSessionFactory sqlSessionFactory;

    public ProductDAOOracle() {
        String resource = "mybatis-config.xml"; //"org/mybatis/example/mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> selectAll() throws FindException {
        // DB연결
//		Connection con = null;
//		try {
//			//con = MyConnection.getConnection();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());// 사용자에게 떠넘긴다. => 사용자 = service.java
//		}
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAll");
            return list;
        } catch (Exception e) {
            throw new FindException(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Product> selectAll(int currentPage) throws FindException {
        int cnt_per_page = 4;
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            HashMap<String, Integer> map = new HashMap<>();
            map.put("cnt_per_page", cnt_per_page);
            map.put("currentPage", currentPage);
            List<Product> list = session.selectList("com.day.dto.ProductMapper.selectAllPage", map);

            if (list.size() == 0) {
                throw new FindException("상품이 없습니다"); //
            }
            return list; // return이 앞이지만 finally를 거친 후 return이 된다.
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindException(e.getMessage());
        } finally {
            session.close();
        }
        // return list; // catch에 throw new FindException(e.getMessage()); 넣어준 후 return
        // list; 제거 가능해짐.
    }

    @Override
    public List<Product> selectByName(String word) throws FindException {
        SqlSession session = null;

        try {
            session = sqlSessionFactory.openSession();
            HashMap<String, String> map = new HashMap<>();
            map.put("word", word);
            map.put("ordermethod", "prod_no ASC");
            List<Product> list = session.selectList("com.day.dto.ProductMapper.selectByName", map);
            if (list.size() == 0) {
                throw new FindException("상품이 없습니다.");
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindException(e.getMessage()); // 검색 중에 예외 발생함을 명시함
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product selectByNo(String prod_no) throws FindException {
        SqlSession session = null;

        try {
            session = sqlSessionFactory.openSession();
            Product product = session.selectOne("com.day.dto.ProductMapper.selectByNo", prod_no);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FindException(e.getMessage()); // 검색 중에 예외 발생함을 명시함
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) {

		ProductDAOOracle productDAOOracle = new ProductDAOOracle();
		try {
			Product p = productDAOOracle.selectByNo("C0001");
			System.out.println(p);
		} catch (FindException e) {
			e.printStackTrace();
		}
    }
}