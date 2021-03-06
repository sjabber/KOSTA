package com.day.control;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper;
		mapper = new ObjectMapper();
		String jsonStr ="";
		
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<>();
		//λ‘κ·Έ?Έ? ?¬?©?λ§? μ£Όλ¬Έκ°??₯
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			//λ‘κ·Έ?Έ?? ?¬?©? status:0, ?₯λ°κ΅¬??? status: -1, μΆκ??€?¨:status: -2/ msg:?€?¨?΄? , 
			//? ?μ²λ¦¬ : status:1
			map.put("status", 0);
		}else {
			//----λ‘κ·Έ?Έ? κ²½μ° ??€?Έ----
			//Customer c = new Customer();
			//c.setId("id1");
			//-----------------------
			//1.?₯λ°κ΅¬??΄?© 
			Map<String, Integer> cart = (Map)session.getAttribute("cart");
			if(cart != null && cart.size() > 0) {
				//2.?₯λ°κ΅¬??΄?©? OrderInfoκ°μ²΄λ‘? λ³??
				OrderInfo info = new OrderInfo();
				List<OrderLine> lines = new ArrayList<>();
				for(String prod_no: cart.keySet()) {
					int quantity = cart.get(prod_no);
					
					OrderLine line = new OrderLine(); //μ£Όλ¬Έ??Έ
					Product order_p = new Product(); 
					order_p.setProd_no(prod_no);
					line.setOrder_p(order_p);   //μ£Όλ¬Έ??				
					line.setOrder_quantity(quantity);//μ£Όλ¬Έ??
					lines.add(line);
				}		
				info.setLines(lines); //μ£Όλ¬Έ??Έ?€			
				info.setOrder_c(c); //μ£Όλ¬Έ?
				//3.λΉμ???€λ‘μ§ ?ΈμΆ?
				ServletContext sc = getServletContext();		
				OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
				OrderService service;
				service = OrderService.getInstance();
				try {
					service.add(info);//μ£Όλ¬ΈμΆκ?
					session.removeAttribute("cart");//?₯λ°κ΅¬? λΉμ°κΈ?
//					request.setAttribute("status", 1);
					map.put("status", 1);
				} catch (AddException e) { //μΆκ??€?¨?Έ κ²¨μ°
					e.printStackTrace();
//					request.setAttribute("msg", e.getMessage());
//					request.setAttribute("status", -2);
					map.put("msg", e.getMessage());
					map.put("status", -2);
				}			
			}else { //?₯λ°κ΅¬?κ°? λΉμ΄?? κ²½μ°
//				request.setAttribute("status", -1);
				map.put("status", -1);
			}
		}
		jsonStr = mapper.writeValueAsString(map);
		response.setContentType("application/json;charset=utf-8"); //??΅??μ§?? 
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}

}
