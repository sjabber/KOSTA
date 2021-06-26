package com.day.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.day.dao.ProductDAO;
import com.day.dto.Product;
import com.day.exception.FindException;



// 여기서도 인터페이스를 활용하는 것이 적절하다. 실습상 클래스만 이용한다.
public class ProductService {
   private static ProductService service; // - 싱글톤 패턴(3)
   public static String envProp; //   
	   
	// 구체화된 ProductDAOFile 클래스가 아닌 일반화된 private ProductDAO dao; 인터페이스를 사용하고
	// 아래에서는 dao = new ProductDAOFile();를 사용하는 이유는?
	private ProductDAO dao; 
	
	// getInstence()에서 사용하기 위해 static 변수 선언한다.
	//private static ProductService service = new ProductService(); // - 싱글톤 패턴(3)
	
	
	// 패키지가 달라서 public으로 해야 패키지가 다른 main에서 메소드 사용 가능하다.
	// 외부에서 객체 생성 없이 ProductService.getInstance(); 로 사용하기 위해 static 선언한다.
	public static ProductService getInstance() {  // - 싱글톤 패턴(2)
		 if(service == null) {
	         service = new ProductService();
	      }
		return service;
	}
	
	private ProductService() { // 생성자를 private 선언해서 외부에서 객체 생성 못하게 한다 - 싱글톤 패턴(1)
		
		// dao = new ProductDAOFile(); // 좌측(구체화된 방식) 대신 리플렉션 기법을 사용해야 한다.
		// dao = new ProductDAOOracle(); 
		// dao = new ProductDAOMySQL();
		
		
		// 런타임 다이나믹 로드와 리플렉션 기법
		Properties env = new Properties();
		try {
			//env.load(new FileInputStream("classes.prop"));
			env.load(new FileInputStream(envProp));
			String className = env.getProperty("productDAO"); // #classes.prop 의 key 값으로 보자.
			Class c = Class.forName(className); 
			dao = (ProductDAO) c.newInstance();

			// DBMS(Oracle, MySQL 등)이 변경될 때마다 소스코드를 수정하는 과정을 피하기 위해
			// <런타임 다이나믹 로드와 리플렉션 기법>을 이용해서 classes.prop에 DMBS 명칭만 변경한다.
			// Oracle 또는 MySQL을 사용하려면 productDAO=com.day.dao.ProductDAOOracle();로 
			// prop 파일을 바꾸기만 하면 된다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   
	   
	public List<Product> findAll() throws FindException {
		return dao.selectAll();
	}
	
	public List<Product> findAll(int currentPage) throws FindException {
		return dao.selectAll(currentPage);
	}
	
	public Product findByNo(String prod_no) throws FindException {
		return dao.selectByNo(prod_no);
	}
	
	public List<Product> findByName(String word) throws FindException {
		return dao.selectByName(word);
	}
}
