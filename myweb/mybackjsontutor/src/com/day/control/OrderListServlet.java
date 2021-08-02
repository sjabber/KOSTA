package com.day.control;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.exception.FindException;
import com.day.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		response.setContentType("application/json;charset=utr-8");
		PrintWriter out = response.getWriter();
		
		//1. ��û���� ������ ��� (id��)
		HttpSession session = request.getSession();
		Customer c = (Customer)session.getAttribute("loginInfo");
		if (c == null) { //�α����� �ȵ� ���, ������ ���� ���
			request.setAttribute("status", 0); //�α��� ���Ѱ��
		} else {
			//2. �����Ͻ����� ȣ��
			ServletContext sc = getServletContext();
			OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
			OrderService service;
			service = OrderService.getInstance();
			try {
				List<OrderInfo> infos = service.findById(c.getId());
				String jsonStr = mapper.writeValueAsString(infos);
				System.out.println(jsonStr);
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().print(jsonStr);
//				request.setAttribute("infos", infos);
			} catch (FindException e) {
				e.printStackTrace();
			}
		}
//		String path = "orderlist.html";
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
	}
}
