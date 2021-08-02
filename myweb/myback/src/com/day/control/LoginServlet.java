package com.day.control;

import com.day.dto.Customer;
import com.day.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //응답헤더설정
      response.addHeader("Access-Control-Allow-Origin", "*");
      
      //1. 요청전달데이터 얻기
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      
      ServletContext sc = getServletContext();      
      CustomerService.envProp = sc.getRealPath(sc.getInitParameter("env"));
      CustomerService service = CustomerService.getInstance();
      //String jsonStr;
      
      //2. 비지니스로직 호출.
      String path = "";
      HttpSession session = request.getSession();
      session.removeAttribute("loginInfo");
      String msg = "성공";
      try {
         Customer loginInfo = service.login(id, pwd);
         //로그인 정보를 세션에 추가
         session.setAttribute("loginInfo", loginInfo);

         //3.성공시
         //path = "success";
         path = "success.jsp";
         msg = "성공";
         //jsonStr = "{\"status\" : 1}";
      } catch (Exception e) {
         e.printStackTrace();
         //4.실패시
         //path = "fail";
         path = "fail.jsp";
         msg = "실패";
         //jsonStr = "{\"status\" : -1}";
      }
      
      //5. 페이지 이동
      RequestDispatcher rd = request.getRequestDispatcher(path);
      rd.forward(request, response);
      
      //5. 응답
//      response.setContentType("application/json;charset=utf-8"); //응답형식 지정
//      PrintWriter out = response.getWriter();
      //out.print(msg);
//      out.print(jsonStr);
   }

}