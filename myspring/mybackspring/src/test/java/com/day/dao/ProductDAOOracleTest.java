package com.day.dao;

import com.day.dto.Product;
import com.day.exception.FindException;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})


class ProductDAOOracleTest {
	
//	static private ProductDAO dao;
//	
//	@BeforeAll //단위테스트 실행할 때 한번 호출
//	static void setUpBeforeClass() throws Exception {
//		System.out.println("@BeforeAll 메서드 호출");
//		dao = new ProductDAOOracle();
//	}
//
//	@BeforeEach //테스트용 메서드들이 각각 호출될 때 마다 호출
//	void setUp() throws Exception {
//		System.out.println("@BeforeEach 메서드 호출");
//	}

	@Autowired
	@Qualifier("productDAO1")
	private ProductDAO dao;
	private Logger log = Logger.getLogger(ProductDAOOracleTest.class.getName());

	@Test
	void testSelectByNo() throws FindException {
		//fail("Not yet implemented");
		//System.out.println("@testSelectByNo 메서드 호출");
		log.debug("testSelectByNo DEBUG");
		log.info("testSelectByNo INFO");
		log.warn("testSelectByNo WARN");
		log.error("testSelectByNo ERROR");
		String prod_no = "C0001";
		Product p = dao.selectByNo(prod_no); // DB검색결과
		
		String expectedProdName = "아메리카노"; // 예상
		int expectedProdPrice = 1000;
		
		// 예상한 값과 같은지 비교하는데 사용하는 메서드
		assertEquals(expectedProdName, p.getProd_name());
		assertTrue(expectedProdName == "아메리카노");
	}
	
	@Test
	void testSelectAll() throws FindException {
		System.out.println("@testSelectAll 메서드 호출");
		List<Product> list = dao.selectAll();
		int expectedSize = 11;
		assertTrue(expectedSize == list.size());
	}
	
	@Test
	void testSelectByName() throws FindException {
		System.out.println("testSelectByName메서드 호출");
		String word = "아";
		List<Product> list = dao.selectByName(word);
		int expectedSize = 2;
		String expectedProd_no = "C0001";
		assertTrue(expectedSize == list.size());
		assertEquals(expectedProd_no, list.get(0).getProd_no());
	}

	@Test
	void testSelectByNameNotFound() {
		String word = "가";
		FindException expectedException;
		expectedException = assertThrows(FindException.class,
				()->dao.selectByName(word));

		String expectedMsg = "상품이 없습니다";
		assertEquals(expectedMsg, expectedException.getMessage());
	}


	@AfterEach //테스트용 메서드들이 종료될 때마다 호출
	void tearDown() throws Exception {
		System.out.println("@AfterEach 메서드 호출");
	}

	@AfterAll //테스트가 종료될 때 호출
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll 메서드 호출");
	}
}
