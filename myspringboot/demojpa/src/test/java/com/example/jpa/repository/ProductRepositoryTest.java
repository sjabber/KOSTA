package com.example.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.jpa.entity.Product;


@SpringBootTest
class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	@DisplayName("클래스이름과 메서드이름, 상위 인터페이스 이름 등을 출력-ProxyPattern")
	void test() {
		Class clazz = productRepository.getClass();
		log.error("클래스 이름: " + clazz.getName());
		log.error("---------");
		for(Method m: clazz.getDeclaredMethods()) {
			log.error(m.getName());
		}
		log.error("----------상위 인터페이스----------");
		for(Class inter: clazz.getInterfaces()) {
			log.error(inter.getName());
		}
	}
	
	@Transactional //두개가 같은 트랜잭션 안에서 동작하도록 만든다.
	@Commit //@Transactional 과 쌍을 이룬다. test에서 제공하는 어노테이션으로 일반 코드에서는 사용하면 안됨.
	@Test
	void testFind()	{ //@Transacntional 이 없으면 위 아래는 서로 다른 트랜잭션으로 동작한다.
		Optional<Product> optP = productRepository.findById("C0001");
		if(optP.isPresent()) {
			Product p = optP.get();
			String expectedName = "아메리카노";
			assertEquals(expectedName, p.getProd_name());
		} else {
			fail("상품없음");
		}
		
		log.error("-----------------------------구분선-----------------------------");
		
		Optional<Product> optP1 = productRepository.findById("C0001");
		if(optP1.isPresent()) {
			Product p = optP1.get();
			String expectedName = "아메리카노";
			assertEquals(expectedName, p.getProd_name());
		} else {
			fail("상품없음");
		}
	}
	
	@Test
	void testFindAll() {
		Iterable<Product> it = productRepository.findAll();
		it.forEach(p->log.error(p.getProd_no()));
		int expectedSize = 7;
		if(it instanceof Collection) {
			Collection c = (Collection)it;
			int size = c.size();
			assertTrue(expectedSize == size);
		}
	}
	
	@Test
	@DisplayName("일부 상품들 검색")
	void testSelectAllNos() {
		List<String> idList  = new ArrayList<>();
		//idList.add("상품번호없음1");
		//idList.add("상품번호없음2");
		idList.add("C0001");
		idList.add("G0001");
		
		//save가 경우에 따라 insert나 update가 되기도 한다.
		Iterable<String>Ids = idList;
		Iterable<Product> it = productRepository.findAllById(Ids); //JPA의 리턴값은 절대 Null이 아니다.
		long size = 0;
		if (it instanceof Collection) {
		    size =  ((Collection<Product>) it).size();
		}
//		long size = StreamSupport.stream(it.spliterator(), false).count();
		long expectedSize = 2;
		assertTrue(expectedSize == size);
	}
	
	@Test
	@Transactional
	@Commit
	@DisplayName("상품추가: 상품가격-기본값으로 추가, 제조일자-자동 추가, 상품명-notnull")
	void testInsert() {
		Product pG0003 = new Product();
		pG0003.setProd_no("G0003");
		pG0003.setProd_name("드리퍼");
		pG0003.setProd_price(3000);
		productRepository.save(pG0003);//존재하지않는 PK를 갖는 객체를 save()의 인자로 전달하면 SELECT후 INSERT됨 
		//로그에서 SELECT후 INSERT되는 SQL구문확인
		
		Product pG0004 = new Product();
		pG0004.setProd_no("G0004");
		pG0004.setProd_name("에코백");
		pG0004.setProd_price(4000);
		productRepository.save(pG0004);
	}
	
	@Test
//	@Transactional
//	@Commit
	void testUpdate() {
//		주의 : 아래처럼 새로운 객체생성으로 save()하면 모든컬럼값이 변경된다. -> 엔티티(DTO)에 DynamicUpdate어노테이션설정하면 부분값만 변경가능하다.
		Product p = new Product();
		p.setProd_no("G0003");
		p.setProd_name("그라인더");
		productRepository.save(p); //UPDATE
		
//		Optional<Product> optP = productRepository.findById("G0003");
//		if(optP.isPresent()) {
//			Product p = optP.get();
//			p.setProd_name("그라인더");
//			productRepository.save(p);
//		}
	}
	
	@Test
	void testDelete() {
		String prod_no = "G0003";
		productRepository.deleteById(prod_no);
	}
}
