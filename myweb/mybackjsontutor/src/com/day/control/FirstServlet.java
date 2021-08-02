package com.day.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        super();
        System.out.println("FirstServlet객체 ?��?��?��");
//        //context-param값얻�?
//        ServletContext sc = getServletContext();
//        String devName = sc.getInitParameter("Developer");
//        System.out.println("책임개발?��:" + devName);
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet?�� init()?��출됨");
		super.init(config); //servletcontext객체 참조 ?��?��?���?
		
		//context-param값얻�?
		ServletContext sc = getServletContext();
		String devName = sc.getInitParameter("Developer");
		System.out.println("책임개발?��:" + devName);
		
		String realPath =  sc.getRealPath("logo.jpg");
		//String realPath = "D:\\SW\\apache-tomcat-9.0.46\\wtpwebapps\\myback\\logo.jpg";
		System.out.println("logo.jpg?�� ?��?��경로:" + realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			System.out.println("logo.jpg ?��?��?�� ?��?��?��?��");
		}	
		
		//servlet?�� init-param�? ?���?
		String fileName = this.getInitParameter("fileName");
		System.out.println("FirstServlet?��?���? ?��?��?�� ?�� ?��?�� ?��?��메터 fileName:" + fileName);
	}
	public void destroy() {
		System.out.println("FirstServlet?�� destroy()?��출됨");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet?�� doGet()?��출됨");
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		System.out.println("?���??��?��?��?��?�� id:" + idValue +", pwd:" + pwdValue);
		String[] cArr = request.getParameterValues("c");
		if(cArr != null) {
			for(String cValue: cArr) {
				System.out.println("?���??��?��?��?��?�� c:" + cValue);
			}
		}
		
		String contextPath = request.getContextPath();
		System.out.println(getServletContext().getContextPath()); //contextPath?? 같음
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println("contextPath:" + contextPath); //   /myback
		System.out.println("uri:" + uri); //  /myback/first
		System.out.println("url:" + url); //  http://localhost:8888/myback/first
		
		String servletPath = request.getServletPath();
		System.out.println("servletPath:" + servletPath); // servletPath:/first
		
Object obj = 
	request.getAttribute("reqAttr1");
String attrValue = (String)obj;		
		
		response.setContentType("text/html;charset=UTF-8"); //?��?��?��?��?? MIME?���?방식?�� ?��른다
		PrintWriter out = response.getWriter(); //?��?�� 출력?��?���? ?���?
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>?��?��결과?��?��?��</h1>");
		out.print("?���? ?��?��reqAttr1�?: " + attrValue);
		out.print("</body>");
		out.print("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet?�� doPost()?��출됨");
	}
}
