package com.day.control;

import com.day.dto.Product;
import com.day.exception.FindException;
import com.day.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class ProductController extends HttpServlet implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //String contextPath = request.getContextPath(); // /mybackfrontcontroller
        String servletPath = request.getServletPath(); // 요청 서블릿
        String methodName = servletPath.split("/", 2)[1]; // 요청 메서드 명
        System.out.println("methodName : " + methodName);

        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String viewPath = (String) method.invoke(this, request, response);
            return viewPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail.jsp";
        }
    }

    public String productlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 요청전달데이터 얻기
        //2. 비지니스로직호출
        ProductService service;
        service = ProductService.getInstance();
        String path;
        try {
            List<Product> list = service.findAll();
            request.setAttribute("productList", list);
            path = "/productlist.jsp";

        } catch (FindException e) {
            e.printStackTrace();
            path = "/fail.jsp";
        }
        return path;
    }

    public String productinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청전달 데이터 얻기
        String prod_no = request.getParameter("prod_no");
        System.out.println("prod_no : " + prod_no);

        ProductService service;
        //2. 비지니스 로직 호출
        service = ProductService.getInstance();
        String path = "";
        try {
            Product p = service.findByNo(prod_no);
            request.setAttribute("p", p);
            path = "productinfo.jsp";
        } catch (FindException e) {
            e.printStackTrace();
            path = "/fail.jsp";
        }
        return path;
    }
}
