package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FailServlet
 */
public class FailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?��?��?��?�� �??��: text/html
		response.setContentType("text/html;charset=UTF-8");
				
		//?��?��출력?��?��림얻�?
		PrintWriter out = response.getWriter();
		out.print("?��?��");
	}
}
