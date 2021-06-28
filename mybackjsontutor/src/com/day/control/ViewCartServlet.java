package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		//1.?���??��?��?��?��?�� ?���?
		//2.비�??��?��로직 ?���?
		ProductService service;
		ServletContext sc = getServletContext();		
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		
		//?��?��?�� ?��바구?���? 찾기
		HttpSession session = request.getSession();
		Map<String, Integer>cart = (Map)session.getAttribute("cart");
		
		List<Map<String, Object>>result = new ArrayList<>();
		//?��바구?���? ?��?���?
		if(cart != null && cart.size() > 0) {
			//?��?��번호?�� ?��?��?��?�� ?��?��?��보찾�?
			Set<String>prod_nos = cart.keySet();
			for(String prod_no: prod_nos) {
				Product p;
				try {
					p = service.findByNo(prod_no);
					Map map = new HashMap<>();
					map.put("product", p);
					map.put("quantity", cart.get(prod_no));
					result.add(map);
				} catch (FindException e) {
					e.printStackTrace();
				}
			}
		}
		jsonStr = mapper.writeValueAsString(result);
		response.setContentType("application/json;charset=utf-8"); //?��?��?��?���??��
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		System.out.println(jsonStr);
	}
}