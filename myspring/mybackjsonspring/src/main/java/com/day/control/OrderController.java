package com.day.control;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@ResponseBody
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/orderlist")
    public Object orderlist(HttpSession session) {
        Customer c = (Customer) session.getAttribute("loginInfo");
        Map<String, Object> map = new HashMap<>();
        List<OrderInfo> infos = null;
        
        if (c == null) {
            map.put("status", "0");
            return map;
        } else {
            try {
                infos = service.findById(c.getId());
            
            } catch (FindException e) {
                e.printStackTrace();
            }
        }
        return infos;
    }

    @GetMapping("/addorder")
    public Map<String, Object> addorder(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Customer c = (Customer) session.getAttribute("loginInfo");
        if (c == null) {
            map.put("status", 0);
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
                    map.put("status", 1);
                } catch (AddException e) {
                    e.printStackTrace();
                    map.put("msg", e.getMessage());
                    map.put("status", -2);
                }
            } else {
                map.put("status", -1);
                return map;
            }
        }
        return map;
    }
}
