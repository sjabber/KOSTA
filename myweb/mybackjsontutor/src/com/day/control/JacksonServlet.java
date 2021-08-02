package com.day.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day.dto.Customer;
import com.day.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		//Customerê°ì²´ë¥? jsonë¬¸ì?—´ë¡? ë³??™˜
		Customer c = new Customer("id1", "p1", "n1");
		String jsonStr = mapper.writeValueAsString(c);
		System.out.println(jsonStr);
		
		//List<String>ê°ì²´ë¥? jsonë¬¸ì?—´ë¡? ë³??™˜
		List<String> list = new ArrayList<>();
		list.add("one");list.add("two");list.add("three");
		jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		
		//List<Product>ê°ì²´ë¥? jsonë¬¸ì?—´ë¡? ë³??™˜
		List<Product> products = new ArrayList<>();
		products.add(new Product("C0001", "?•„ë©”ë¦¬ì¹´ë…¸", 1000));
		products.add(new Product("C0002", "ICE?•„ë©”ë¦¬ì¹´ë…¸", 1000));
		jsonStr = mapper.writeValueAsString(products);
		System.out.println(jsonStr);
		
		//Map<String, Integer>ê°ì²´ë¥? jsonë¬¸ì?—´ë¡? ë³??™˜
		Map<String, Integer>map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		jsonStr = mapper.writeValueAsString(map);
		System.out.println(jsonStr);
	}
}
