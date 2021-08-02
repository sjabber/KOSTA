package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day.dto.Customer;
import com.day.exception.FindException;
import com.day.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������
		response.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		
		//1. ��û������ ���
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		ServletContext sc = getServletContext();		
		CustomerService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		CustomerService service = CustomerService.getInstance();
		//2.����Ͻ����� ȣ��
		//String path = "";
		//String msg = "";
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		Map<String, Object>map = new HashMap<>();
		try {
			Customer loginInfo = service.login(id, pwd);
			//�α��� ������ ���ǿ� �߰�
			//3.������
			session.setAttribute("loginInfo", loginInfo);			
			map.put("status", 1);
		} catch (FindException e) {
			//4.���н�
			e.printStackTrace();
			//jsonStr = "{\"status\" : -1, \"msg\": \"" +e.getMessage() +"\"}";
			//JSON?
			map.put("status", -1);
			map.put("msg", e.getMessage());
		}
		
		jsonStr = mapper.writeValueAsString(map);
		//5. ����
		response.setContentType("application/json;charset=utf-8"); //?��?��?��?���??��
		//response.sendError(200, "isOk");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}
}
