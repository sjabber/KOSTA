package com.day.control;

import com.day.exception.FindException;
import com.day.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.day.dto.Product;

import java.util.List;

@Controller // @Repository, @Service, @Controller 는 모두 @Component 의 하위 어노테이션이다.
public class ProductController {
	//private Logger log = Logger.getLogger(ProductController.class);

    /*
     * @GetMapping("/productinfo") public void productInfo(HttpServletRequest request) {
     * String prod_no = request.getParameter("prod_no");
     * log.info("ProductController의 productInfo()입니다. prod_no = " + prod_no); }
     */
    /*
     * @GetMapping("/productinfo") public void productInfo(String prod_no) {
     * log.info("ProductController의 productInfo()입니다. prod_no = " + prod_no); }
     */
/*	@GetMapping("/productinfo")
    public void productInfo(@RequestParam(name = "prod_no", required = false, defaultValue = "yes") String no) {
        log.info("ProductController의 productInfo()입니다. prod_no = " + no);
    }*/
	
	/*
	 * @GetMapping("/register") public void add(String prod_no, String prod_name,
	 * 
	 * @RequestParam(required = false, defaultValue = "0") int prod_price) {
	 * log.info("add()입니다. prod_no=" + prod_no + ", prod_name=" + prod_name +
	 * ", prod_price=" + prod_price); }
	 */
/*	@GetMapping("/register")
	public void add(Product p) {
		log.info("add()입니다. prod_no=" + p.getProd_no() + ", prod_name=" + p.getProd_name() + ", prod_price=" + p.getProd_price());
	}*/
    /*@GetMapping("/register")
    public void add(String[] prod_no) {
        for (String no : prod_no) {
            log.info(no);
        }
    }*/
    //REST API 사용시 요청전달 데이터를 JSON으로 처리할 수 있다. 그때 사용한다.
/*    @GetMapping("/register")
    public void add(ArrayList<String> prod_no) {
        log.info("add()입니다.");
        for (String no : prod_no) {
            log.info(no);
        }
    }*/

	@Autowired
	private ProductService service;

//	@GetMapping("/productinfo")
/*	public void productInfo(String prod_no, Model model) {
		try {
			Product p = service.findByNo(prod_no);
			//request.setAttribute("p", p);
			model.addAttribute("p", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
/*	public ModelAndView productInfo(String prod_no) {
		ModelAndView mnv = new ModelAndView();
		try {
			Product p = service.findByNo(prod_no);
			mnv.setViewName("productinfo");
			mnv.addObject("p", p);
		} catch (FindException e) {
			e.printStackTrace();
			mnv.setViewName("fail");
		}
		return mnv;
	}*/
	@GetMapping("/productinfo")
	public String productInfo(String prod_no, Model model) {
		System.out.println("productInfo 호출됨 : " + prod_no);
		String viewName;
		try {
			Product p = service.findByNo(prod_no);
			model.addAttribute("p", p);
			viewName = "productinfo";
		} catch (FindException e) {
			e.printStackTrace();
			viewName = "fail";
		}
		return viewName;
	}
	
	@GetMapping("/productlist")
	public String productlist(Model model) {
		List<Product> list;
		try {
			list = service.findAll();
			model.addAttribute("productList", list);
			return "productlist";
		} catch (FindException e) {
			e.printStackTrace();
			//model.addAttribute("", )
			return "fail";
		}
	}
}
