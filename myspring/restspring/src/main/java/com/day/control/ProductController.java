package com.day.control;


import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

//@Controller // @Repository, @Service, @Controller 는 모두 @Component 의 하위 어노테이션이다.
public class ProductController {
    private Logger log = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @GetMapping("/productinfo")
    @ResponseBody // 직접 응답하는 구조, mvc가 아님.
//	public String productInfo(String prod_no) {
//		String jsonStr;
//		try {
//			Product p = service.findByNo(prod_no);
//			jsonStr = "{\"msg\" : \"success\"}";
//		} catch (FindException e) {
//			e.printStackTrace();
//			jsonStr = "{\"msg\" : \"fail\"}";
//		}
//		return jsonStr;
//	}

//	public Object productInfo(String prod_no) {
//		try {
//			Product p = service.findByNo(prod_no);
//			return p; //Product타입의 객체의 toString() 호출되어 응답바디에 쓰기된다.
//		} catch (FindException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

//	public Map<String, Object> productInfo(String prod_no) {
//		HashMap<String, Object> map = new HashMap<>();
//		try {
//			Product p = service.findByNo(prod_no);
//			map.put("status", 1);
//			map.put("p", p);
//		} catch (FindException e) {
//			e.printStackTrace();
//			map.put("status", 0);
//			map.put("msg", e.getMessage());
//		}
//		return map; //Map 객체의 내용을 json 객체타입의 문자열로 변환 후 응답바디에 쓰기된다.
//	}

	public Object productInfo(String prod_no) {
		HashMap<String, Object>map = new HashMap<>();
		try {
			Product p = service.findByNo(prod_no);
			return p;
		} catch (FindException e) {
			e.printStackTrace();
			map.put("status", -1);
			map.put("msg", e.getMessage());
			return map;//Map객체의내용을 json객체타입의 문자열로 변환후 응답바디에 쓰기된다
		}
	}


//	@GetMapping("/productlist")
//	public String productlist(Model model) {
//		List<Product> list;
//		try {
//			list = service.findAll();
//			model.addAttribute("productList", list);
//			return "productlist";
//		} catch (FindException e) {
//			e.printStackTrace();
//			//model.addAttribute("", )
//			return "fail";
//		}
//	}

    @GetMapping("/productlist")
    @ResponseBody
    public List<Product> productList() {
        List<Product> list;
        try {
            list = service.findAll();
            return list;
        } catch (FindException e) {
            e.printStackTrace();
            return null;
        }
    }
}
