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
		response.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		
		//1. ?öîÏ≤??†Ñ?ã¨?ç∞?ù¥?Ñ∞ ?ñªÍ∏?
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		ServletContext sc = getServletContext();		
		CustomerService.envProp = sc.getRealPath(sc.getInitParameter("env"));
		CustomerService service = CustomerService.getInstance();
		//2.ÎπÑÏ??ãà?ä§Î°úÏßÅ ?ò∏Ï∂?
		//String path = "";
		//String msg = "";
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		Map<String, Object>map = new HashMap<>();
		try {
			Customer loginInfo = service.login(id, pwd);
			//Î°úÍ∑∏?ù∏?†ïÎ≥¥Î?? ?Ñ∏?Öò?óê Ï∂îÍ?			
			session.setAttribute("loginInfo", loginInfo);			
			map.put("status", 1);
		} catch (FindException e) {
			e.printStackTrace();
			//jsonStr = "{\"status\" : -1, \"msg\": \"" +e.getMessage() +"\"}";
			//JSON?ùº?ù¥Î∏åÎü¨Î¶? ?ôú?ö©~
			map.put("status", -1);
			map.put("msg", e.getMessage());
		}
		
		jsonStr = mapper.writeValueAsString(map);
		//5.?ùë?ãµ
		response.setContentType("application/json;charset=utf-8"); //?ùë?ãµ?òï?ãùÏß??†ï
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}
}
