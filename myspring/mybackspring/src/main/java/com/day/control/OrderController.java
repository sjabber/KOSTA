package com.day.control;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.OrderService;
import org.apache.log4j.Logger;

import com.day.dao.OrderDAOOracle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
/*	@Autowired
	@Qualifier("orderDAO")
	private OrderDAOOracle dao;*/

	@Autowired
	private OrderService service;

	private Logger log = Logger.getLogger(OrderController.class.getName());

	@GetMapping("/orderlist")
	public String orderlist(HttpSession session, Model model) {
		Customer c = (Customer) session.getAttribute("loginInfo");
		if (c == null) {
			model.addAttribute("status", 0);
		} else {
			try {
				List<OrderInfo> infos = service.findById(c.getId());
				log.error(infos.get(0).getLines().get(0).getOrder_p());
				model.addAttribute("infos", infos);
			} catch (FindException e) {
				e.printStackTrace();
			}
		}
		return "orderlist";
	}

	@GetMapping("/addorder")
	public String addorder(HttpSession session, Model model) {
		Customer c = (Customer) session.getAttribute("loginInfo");
		if (c == null) {
			model.addAttribute("status	, 0");
		} else {
			Map<String, Integer> cart = (Map) session.getAttribute("cart");
			if (cart != null && cart.size() > 0) {
				OrderInfo info = new OrderInfo();
				List<OrderLine> lines = new ArrayList<>();
				info.setLines(lines);
				for (String prod_no : cart.keySet()) {
					int quantity = cart.get(prod_no);
					OrderLine line = new OrderLine();
					Product order_p = new Product();
					order_p.setProd_no(prod_no);
					line.setOrder_p(order_p); //주문상품
					line.setOrder_quantity(quantity); //주문수량
					lines.add(line);
				}
				info.setLines(lines); //주문상세들
				info.setOrder_c(c); //주문자 정보
				try {
					service.add(info);
					session.removeAttribute("cart");
					model.addAttribute("status", 1);

				} catch (AddException e) {
					e.printStackTrace();
					model.addAttribute("msg", e.getMessage());
					model.addAttribute("status", -2);
				}
			} else {
				model.addAttribute("status", -1);
				return "fail";
			}
		}
		return "addorder";
	}
}
