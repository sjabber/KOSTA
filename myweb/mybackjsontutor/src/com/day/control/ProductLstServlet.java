package com.day.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductLstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청전달 데이터 얻기
		//2. 비즈니스로직 호출
		ProductService service;
		ServletContext sc = getServletContext();		
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		//String path;
		try {
			List<Product> list = service.findAll();
			//request.setAttribute("productList", list);
			//path = "/productlist.jsp"; 
			//JSON?씪?씠釉뚮윭由? ?솢?슜?빐?꽌 ?긽?뭹紐⑸줉?쓣 json臾몄옄?뿴?삎?깭濡? ?쓳?떟
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(jsonStr);
		} catch (FindException e) {
			e.printStackTrace();
			//path = "/fail.jsp";
		}
		//RequestDispatcher rd = request.getRequestDispatcher(path);
		//rd.forward(request, response);
		
		
	}

}
