package com.day.control;

import com.day.service.CustomerService;
import com.day.service.OrderService;
import com.day.service.ProductService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DispatcherServlet이 요청됨");
		ServletContext sc = getServletContext();
		String envProp = sc.getRealPath(sc.getInitParameter("env"));
		CustomerService.envProp = envProp;
		ProductService.envProp = envProp;
		OrderService.envProp = envProp;

		//요청servletpath에 따라 사용될 Controller와 method가 달라짐
		String servletPath = request.getServletPath(); //요청받은 url을 호출한다.
		Controller controller;
		//controller.prop파일 로드
		//String realPath = sc.getRealPath("/WEB-INF/controller.prop");//프로퍼티파일의 실제 경로 찾기
		// 파일 이름이나 경로가 변할 수 있기 때문에 자바 코드안에 직접 파일명을 명시하는것은 권장하지 않는다.
		// file name writing in java code is not recommended

		String realPath = sc.getRealPath(sc.getInitParameter("env.controller"));
		Properties env = new Properties();
		env.load(new FileInputStream(realPath));

		//요청된 servletpath에 해당하는 클래스이름 찾기
		System.out.println("realPath : " + realPath);
		System.out.println("servletPath : " + servletPath);
		String controllerClassName = env.getProperty(servletPath);
		System.out.println("controllerClassName : " + controllerClassName);
		try {
			//클래스이름에 해당하는 클래스로드
			Class clazz = Class.forName(controllerClassName);
			//로드된 클래스를 이용한 객체생성
			Object obj = clazz.newInstance();

			//Method getInstanceMethod = clazz.getDeclaredMethod("getInstance", null);
			controller = (Controller) obj;
			//execute 메서드 호출
			String viewPath = controller.execute(request, response);
			System.out.println("viewPath : " + viewPath);
			RequestDispatcher rd = request.getRequestDispatcher(viewPath);
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
