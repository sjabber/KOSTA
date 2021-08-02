package com.day.control;

import com.day.dto.Customer;
import com.day.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

public class CustomerController extends HttpServlet implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		System.out.println("contextPath:" + contextPath +", servletPath:" + servletPath);
		String methodName = servletPath.split("/", 2)[1]; // "/login" => 슬래시를 기준으로 문자열을 두개로 자르고 두번째거를 골라라
		//if("login".equals(servletPath)) {
		//	login(request, response);
		//}
		// 메서드 이름"login"으로 메서드 호출하기
		try {
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			String viewPath = (String) method.invoke(this, request, response);
			return viewPath;
		} catch (Exception e) {
			e.printStackTrace();
			return "fail.jsp";
		}
	}

	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답헤더설정
		response.addHeader("Access-Control-Allow-Origin", "*");

		//1. 요청전달데이터 얻기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");


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

		return path;
		//5. 페이지 이동
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate(); // 세션제거
		
		String path = "success.jsp";
		return path;
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
	}

}
