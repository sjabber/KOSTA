import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.day.dao.CustomerDAO;
import com.day.dto.Customer;
import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

public class Test {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너(엔진)을 시작시킨다
		// 사용 API 종류 : ApplicationContext
		// 2. 스프링 컨테이너가 설정파일(config.xml)의 <bean>태그에 설정한 클래스타입의 객체를 생성한다.
		ApplicationContext ctx;
		String configLocation = "config.xml";
		ctx = new ClassPathXmlApplicationContext(configLocation);
		
//		ctx = new AnnotationConfigApplicationContext(com.day.config.Factory.class);
		

		Customer c1 = ctx.getBean("c", com.day.dto.Customer.class);
		System.out.println(c1); // c1.toString() 자동호출됨

		Customer c2 = ctx.getBean("c", com.day.dto.Customer.class);
		System.out.println(c2);
		System.out.println("c1==c2 : " + (c1 == c2)); // true : 스프링 컨테이너에서 관리되는 c객체는 1개. SingletonPattern으로 관리됨.
		
		// 다운캐스팅할 이름을 클래스가 아니라 인터페이스로 명심함으로써 의존성을 주입받아도 자바 코드가 변형되지 않을 수 있다. (결합도를 낮춤)
		CustomerDAO cDAO = ctx.getBean("customerDAO", com.day.dao.CustomerDAO.class);
		System.out.println(cDAO);
//
//		try {
//			Customer c = cDAO.selectById("id9");
//			System.out.println(c);
//		} catch (FindException e) {
//			e.printStackTrace();
//		}
//		
		Product p1 = ctx.getBean("p", com.day.dto.Product.class);
		System.out.println(p1);
		
		ProductService productService = ctx.getBean("productService", com.day.service.ProductService.class);
		try {
			System.out.println(productService.findByNo("G0001"));
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(productService);
	}

}
