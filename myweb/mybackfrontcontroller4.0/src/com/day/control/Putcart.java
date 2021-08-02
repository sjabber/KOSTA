package com.day.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Putcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, Integer> cart = (Map)session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<>();
			session.setAttribute("cart", cart);
		}
		//요청 전달 데이터 얻기
		String prod_no = request.getParameter("prod_no");
		String quantity = request.getParameter("quantity");
		Integer intQuantity = new Integer(quantity);

		// 같은 상품에 대한 덮어쓰기를 방지하기 위한 코드
		Integer oldQuantity = (Integer)cart.get(prod_no);
		if (oldQuantity != null) {
			intQuantity += oldQuantity;
		}
		cart.put(prod_no, intQuantity);
		System.out.println(cart);

		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
