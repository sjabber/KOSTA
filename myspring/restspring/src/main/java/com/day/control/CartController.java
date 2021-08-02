package com.day.control;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

//@Controller
public class CartController {

    @Autowired
    private ProductService service;

    @GetMapping("/putcart")
    @ResponseBody
/*    public void putCart(String prod_no, int quantity, HttpSession session) {
        System.out.println("신호 온당1");
        Map<String, Integer> cart = (Map)session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        Integer oldquantity = (Integer) cart.get(prod_no);
        if (oldquantity != null) {
            quantity += oldquantity;
        }
        cart.put(prod_no, quantity);
    }*/
    // ResponseEntity => 응답객체, 응답의 정보값을 바꿀 수 있어서 기존 HttpResponse와 다르다.
    //헤더정보, httpstatus정보를 바꿀 수 있다. <String>은 바디의 내용을 String으로 하기 때문에 사용한다.
    public ResponseEntity<String> putCart(String prod_no, int quantity, HttpSession session) {
        Map<String, Integer> cart = (Map)session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        Integer oldquantity = (Integer) cart.get(prod_no);
        if (oldquantity != null) {
            quantity += oldquantity;
        }
        cart.put(prod_no, quantity);

        ResponseEntity<String> entity =
       new ResponseEntity<String>(HttpStatus.OK); // 응답코드 200
//        new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        return entity;
    }

    @GetMapping("/viewcart")
    @ResponseBody
    public List<Map<String, Object>> viewCart(HttpSession session) {
        // 세션의 내용을 가져온다.
        Map<String, Integer>cart = (Map)session.getAttribute("cart");
        List<Map<String, Object>>result = new ArrayList<>();
        //장바구니가 있다면
        if(cart != null && cart.size() > 0) {
            //상품번호에 해당하는 상품정보찾기
            Set<String> prod_nos = cart.keySet();
            for(String prod_no: prod_nos) {
                Product p;
                try {
                    p = service.findByNo(prod_no);
                    Map map = new HashMap<>();
                    map.put("product", p);
                    map.put("quantity", cart.get(prod_no));
                    System.out.println(cart.get(prod_no));
                    System.out.println(map);
                    result.add(map);
                } catch (FindException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
