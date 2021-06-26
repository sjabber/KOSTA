package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청전달데이터얻기
		//2.비지니스로직 호출
		ProductService service;
		ServletContext sc = getServletContext();
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		//String path ="";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			List<Product> list = service.findAll();
			String jsonStr = mapper.writeValueAsString(list);
			request.setAttribute("productList", list);
			//System.out.println(jsonStr);
			response.setContentType("application/json;charset=utf-8"); //응답형식지정(json) //주소 입력x 
			response.getWriter().print(jsonStr);
//			PrintWriter out = response.getWriter();
//			out.print(jsonStr);
			
			
			
			//path = "/productlist.jsp"; //참고 : "./" << 백엔드단에서는 상대경로 설정 X
		} catch (FindException e) {
			e.printStackTrace();
			//path = "/fail.jsp";
		}
		//RequestDispatcher rd = request.getRequestDispatcher(path);
		//rd.forward(request, response);
		
		//JSON라이브러리 활용해서 상품목록을 json문자열 형태로 응답
		
		
		
		
		
		
//		ServletContext sc = getServletContext();
//		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
//		ProductService service = ProductService.getInstance();
//		String path ="";
//		try {
//			//List<Product> productlist = service.findAll();
//			service.findAll();
//			path = "/productlist.jsp";
//		} catch (FindException e) {
//			e.printStackTrace();
//		}
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
		
	}
	
	
}
