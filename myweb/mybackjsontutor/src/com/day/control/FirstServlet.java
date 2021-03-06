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
        System.out.println("FirstServletκ°μ²΄ ??±?¨");
//        //context-paramκ°μ»κΈ?
//        ServletContext sc = getServletContext();
//        String devName = sc.getInitParameter("Developer");
//        System.out.println("μ±μκ°λ°?:" + devName);
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet? init()?ΈμΆλ¨");
		super.init(config); //servletcontextκ°μ²΄ μ°Έμ‘° ???΄μ€?
		
		//context-paramκ°μ»κΈ?
		ServletContext sc = getServletContext();
		String devName = sc.getInitParameter("Developer");
		System.out.println("μ±μκ°λ°?:" + devName);
		
		String realPath =  sc.getRealPath("logo.jpg");
		//String realPath = "D:\\SW\\apache-tomcat-9.0.46\\wtpwebapps\\myback\\logo.jpg";
		System.out.println("logo.jpg? ?€? κ²½λ‘:" + realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			System.out.println("logo.jpg ??Ό?΄ ??΅??€");
		}	
		
		//servlet? init-paramκ°? ?»κΈ?
		String fileName = this.getInitParameter("fileName");
		System.out.println("FirstServlet??λ§? ?¬?©?  ? ?? ??Όλ©ν° fileName:" + fileName);
	}
	public void destroy() {
		System.out.println("FirstServlet? destroy()?ΈμΆλ¨");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet? doGet()?ΈμΆλ¨");
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		System.out.println("?μ²?? ?¬?°?΄?° id:" + idValue +", pwd:" + pwdValue);
		String[] cArr = request.getParameterValues("c");
		if(cArr != null) {
			for(String cValue: cArr) {
				System.out.println("?μ²?? ?¬?°?΄?° c:" + cValue);
			}
		}
		
		String contextPath = request.getContextPath();
		System.out.println(getServletContext().getContextPath()); //contextPath?? κ°μ
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
		
		response.setContentType("text/html;charset=UTF-8"); //??΅???? MIME?μ€?λ°©μ? ?°λ₯Έλ€
		PrintWriter out = response.getWriter(); //??΅ μΆλ ₯?€?Έλ¦? ?»κΈ?
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>??΅κ²°κ³Ό???€</h1>");
		out.print("?μ²? ??±reqAttr1κ°?: " + attrValue);
		out.print("</body>");
		out.print("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet? doPost()?ΈμΆλ¨");
	}
}
