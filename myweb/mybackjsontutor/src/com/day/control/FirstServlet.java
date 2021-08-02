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
        System.out.println("FirstServletê°ì²´ ?ƒ?„±?¨");
//        //context-paramê°’ì–»ê¸?
//        ServletContext sc = getServletContext();
//        String devName = sc.getInitParameter("Developer");
//        System.out.println("ì±…ì„ê°œë°œ?:" + devName);
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet?˜ init()?˜¸ì¶œë¨");
		super.init(config); //servletcontextê°ì²´ ì°¸ì¡° ?‘?—…?•´ì¤?
		
		//context-paramê°’ì–»ê¸?
		ServletContext sc = getServletContext();
		String devName = sc.getInitParameter("Developer");
		System.out.println("ì±…ì„ê°œë°œ?:" + devName);
		
		String realPath =  sc.getRealPath("logo.jpg");
		//String realPath = "D:\\SW\\apache-tomcat-9.0.46\\wtpwebapps\\myback\\logo.jpg";
		System.out.println("logo.jpg?˜ ?‹¤? œê²½ë¡œ:" + realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			System.out.println("logo.jpg ?ŒŒ?¼?´ ?—†?Šµ?‹ˆ?‹¤");
		}	
		
		//servlet?˜ init-paramê°? ?–»ê¸?
		String fileName = this.getInitParameter("fileName");
		System.out.println("FirstServlet?—?„œë§? ?‚¬?š©?•  ?ˆ˜ ?ˆ?Š” ?ŒŒ?¼ë©”í„° fileName:" + fileName);
	}
	public void destroy() {
		System.out.println("FirstServlet?˜ destroy()?˜¸ì¶œë¨");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet?˜ doGet()?˜¸ì¶œë¨");
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		System.out.println("?š”ì²?? „?‹¬?°?´?„° id:" + idValue +", pwd:" + pwdValue);
		String[] cArr = request.getParameterValues("c");
		if(cArr != null) {
			for(String cValue: cArr) {
				System.out.println("?š”ì²?? „?‹¬?°?´?„° c:" + cValue);
			}
		}
		
		String contextPath = request.getContextPath();
		System.out.println(getServletContext().getContextPath()); //contextPath?? ê°™ìŒ
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
		
		response.setContentType("text/html;charset=UTF-8"); //?‘?‹µ?˜•?‹?? MIME?‘œì¤?ë°©ì‹?„ ?”°ë¥¸ë‹¤
		PrintWriter out = response.getWriter(); //?‘?‹µ ì¶œë ¥?Š¤?Š¸ë¦? ?–»ê¸?
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>?‘?‹µê²°ê³¼?…?‹ˆ?‹¤</h1>");
		out.print("?š”ì²? ?†?„±reqAttr1ê°?: " + attrValue);
		out.print("</body>");
		out.print("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet?˜ doPost()?˜¸ì¶œë¨");
	}
}
