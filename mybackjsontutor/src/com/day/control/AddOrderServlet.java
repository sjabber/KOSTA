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
		//ë¡œê·¸?¸?œ ?‚¬?š©?ë§? ì£¼ë¬¸ê°??Š¥
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c == null) {
			//ë¡œê·¸?¸?•ˆ?œ ?‚¬?š©? status:0, ?¥ë°”êµ¬?‹ˆ?—†?Œ status: -1, ì¶”ê??‹¤?Œ¨:status: -2/ msg:?‹¤?Œ¨?´?œ , 
			//? •?ƒì²˜ë¦¬ : status:1
			map.put("status", 0);
		}else {
			//----ë¡œê·¸?¸?œ ê²½ìš° ?…Œ?Š¤?Š¸----
			//Customer c = new Customer();
			//c.setId("id1");
			//-----------------------
			//1.?¥ë°”êµ¬?‹ˆ?‚´?š© 
			Map<String, Integer> cart = (Map)session.getAttribute("cart");
			if(cart != null && cart.size() > 0) {
				//2.?¥ë°”êµ¬?‹ˆ?‚´?š©?„ OrderInfoê°ì²´ë¡? ë³??™˜
				OrderInfo info = new OrderInfo();
				List<OrderLine> lines = new ArrayList<>();
				for(String prod_no: cart.keySet()) {
					int quantity = cart.get(prod_no);
					
					OrderLine line = new OrderLine(); //ì£¼ë¬¸?ƒ?„¸
					Product order_p = new Product(); 
					order_p.setProd_no(prod_no);
					line.setOrder_p(order_p);   //ì£¼ë¬¸?ƒ?’ˆ				
					line.setOrder_quantity(quantity);//ì£¼ë¬¸?ˆ˜?Ÿ‰
					lines.add(line);
				}		
				info.setLines(lines); //ì£¼ë¬¸?ƒ?„¸?“¤			
				info.setOrder_c(c); //ì£¼ë¬¸?
				//3.ë¹„ì??‹ˆ?Š¤ë¡œì§ ?˜¸ì¶?
				ServletContext sc = getServletContext();		
				OrderService.envProp = sc.getRealPath(sc.getInitParameter("env"));
				OrderService service;
				service = OrderService.getInstance();
				try {
					service.add(info);//ì£¼ë¬¸ì¶”ê?
					session.removeAttribute("cart");//?¥ë°”êµ¬?‹ˆ ë¹„ìš°ê¸?
//					request.setAttribute("status", 1);
					map.put("status", 1);
				} catch (AddException e) { //ì¶”ê??‹¤?Œ¨?¸ ê²¨ìš°
					e.printStackTrace();
//					request.setAttribute("msg", e.getMessage());
//					request.setAttribute("status", -2);
					map.put("msg", e.getMessage());
					map.put("status", -2);
				}			
			}else { //?¥ë°”êµ¬?‹ˆê°? ë¹„ì–´?ˆ?Š” ê²½ìš°
//				request.setAttribute("status", -1);
				map.put("status", -1);
			}
		}
		jsonStr = mapper.writeValueAsString(map);
		response.setContentType("application/json;charset=utf-8"); //?‘?‹µ?˜•?‹ì§?? •
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}

}
