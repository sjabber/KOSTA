package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.day.service.CustomerService;

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
      
      //2. 비지니스로직 호출.
      String path = "";
      String msg = ""; // jsp 이동 없이 응답 방식1
      String jsonStr = ""; // jsp 이동 없이 응답 방식2
      
      try {
         service.login(id, pwd);
         //3.성공시
         //path = "success";
         //path = "success.jsp"; // 뷰어
         //msg = "성공"; // jsp 이동 없이 응답 방식1
         jsonStr = "{\"status\": 1}";
         
      } catch (Exception e) {
         e.printStackTrace();
         //4.실패시
         //path = "fail.jsp";
         //msg = "실패";  // jsp 이동 없이 응답 방식
         jsonStr = "{\"status\": -1, \"msg\": \""+e.getMessage()+"\"}"; // json 문법 - 큰 따옴표 필수
 		
      }
      
      //5. 페이지 이동
      //RequestDispatcher rd = request.getRequestDispatcher(path);
      //rd.forward(request, response);

      //5. 응답( 뷰어로 이동 없이 )
      response.setContentType("application/json;charset=utf-8"); // 응답형식지정
      PrintWriter out = response.getWriter();
//      out.print(msg);
      out.print(jsonStr); // jsp 뷰어로 이동 없으므로 퍼포먼스 향상, 개발 속도 빠름 , 유지보수성 낮음
      
      
   }
}