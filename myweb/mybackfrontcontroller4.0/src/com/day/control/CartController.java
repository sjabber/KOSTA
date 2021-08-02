package com.day.control;

import com.day.dto.Customer;
import com.day.dto.OrderInfo;
import com.day.dto.OrderLine;
import com.day.dto.Product;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.OrderService;
import com.day.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CartController extends HttpServlet implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //String contextPath = request.getContextPath(); // /mybackfrontcontroller
        String servletPath = request.getServletPath(); // 요청 서블릿
        String methodName = servletPath.split("/", 2)[1]; // 요청 메서드 명
        System.out.println(methodName);

        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String viewPath = (String) method.invoke(this, request, response);
            return viewPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail.jsp";
        }
    }

    public String putcart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        return "success.jsp";
    }

    public String viewcart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service;
        service = ProductService.getInstance();
        System.out.println("씨바 왜 반영이 안돼");

        //세션의 장바구니를 찾기
        HttpSession session = request.getSession();
        Map<String, Integer>cart = (Map)session.getAttribute("cart");

        Map<Product, Integer>result = new HashMap<>();
        //장바구니가 있다면
        if(cart != null && cart.size() > 0) {
            //상품번호에 해당하는 상품정보찾기
            Set<String> prod_nos = cart.keySet();
            for(String prod_no: prod_nos) {
                Product p;
                try {
                    p = service.findByNo(prod_no);
                    result.put(p, cart.get(prod_no));//요청속성으로 사용할 result에 추가
                } catch (FindException e) {
                    e.printStackTrace();
                }
            }
        }
        //3.요청속성 추가
        request.setAttribute("result", result);
        //4.페이지 이동
        String path = "viewcart.jsp";
        return path;
    }

    public String orderlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 요청전달 데이터 얻기 (id값)
        HttpSession session = request.getSession();
        Customer c = (Customer)session.getAttribute("loginInfo");
        if (c == null) { //로그인이 안된 경우, 세션이 끊긴 경우
            request.setAttribute("status", 0); //로그인 안한경우
        } else {
            //2. 비지니스로직 호출
            OrderService service;
            service = OrderService.getInstance();
            try {
                List<OrderInfo> infos = service.findById(c.getId());
                request.setAttribute("infos", infos);
            } catch (FindException e) {
                e.printStackTrace();
            }
        }
        String path = "orderlist.jsp";
        return path;
    }

    public String addorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "addorder.jsp";
        HttpSession session = request.getSession();
        //로그인된 사용자만 주문하기 가능
        Customer c = (Customer)session.getAttribute("loginInfo");
        if (c == null) {
            //로그인 안된 사용자 status -> 0, 장바구니 없음 status -> -1, 추가실패 : status: -2, msg:실패이유,
            //정상처리 : status:1
            request.setAttribute("status", 0);
        } else {
            // 로그인 성공된 케이스
            //1. 장바구니 내용 가져오기
            Map<String, Integer> cart = (Map) session.getAttribute("cart");
            if (cart != null && cart.size() > 0) {
                //2. 장바구니 내용을 OrderInfo객체로 변환
                OrderInfo info = new OrderInfo();
                List<OrderLine> lines = new ArrayList<>();
                info.setLines(lines);
                for (String prod_no : cart.keySet()) {
                    int quantity = cart.get(prod_no);

                    OrderLine line = new OrderLine(); //주문상세
                    Product order_p = new Product();
                    order_p.setProd_no(prod_no);
                    line.setOrder_p(order_p); //주문상품
                    line.setOrder_quantity(quantity); //주문수량
                    lines.add(line);
                }
                info.setLines(lines); //주문상세들
                info.setOrder_c(c); //주문자 정보

                //3. 비지니스로직 호출
                OrderService service;
                service = OrderService.getInstance();
                try {
                    service.add(info); // 주문 추가
                    session.removeAttribute("cart"); // 장바구니 비우기
                    request.setAttribute("status", 1);
                } catch (AddException e) { //추가 실패인 경우
                    e.printStackTrace();
                    request.setAttribute("msg", e.getMessage());
                    request.setAttribute("status", -2);
                }

                //service.addOrder();
            } else { // 장바구니가 비어있는 경우
                request.setAttribute("status", -1);
                path = "fail.jsp";
            }
        }
        return path;
    }
}
