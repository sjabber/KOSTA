package com.day.control;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청전달 데이터 얻기
		String prod_no = request.getParameter("prod_no");
		
		ProductService service;
		//2. 비지니스 로직 호출
		ServletContext sc = getServletContext();
		ProductService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		service = ProductService.getInstance();
		String path = "";
		try {
			Product p = service.findByNo(prod_no);
			request.setAttribute("p", p);
			path = "productinfo.jsp";
		} catch (FindException e) {
			e.printStackTrace();
			path = "fail";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
