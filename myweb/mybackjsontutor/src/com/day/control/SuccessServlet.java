package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//??΅?? μ§?? : text/html
		response.setContentType("text/html;charset=UTF-8");
				
		//??΅μΆλ ₯?€?Έλ¦Όμ»κΈ?
		PrintWriter out = response.getWriter();
		out.print("?±κ³?");
	}

}
