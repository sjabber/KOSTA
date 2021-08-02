package com.day.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//?��?��?��?�� �??��: text/html
		response.setContentType("text/html;charset=UTF-8");
		
		//?��?��출력?��?��림얻�?
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<ol>");
		out.print("<li><a href=\"./move?opt=forward&id=id1&pwd=p1\">?��?��?��</a></li>");
		out.print("<li><a href=\"./move?opt=include\">?��?��루드</li>");
		out.print("<li><a href=\"./move?opt=redirect&id=id1&pwd=p1\">리다?��?��?��</li>");
		out.print("</ol>");
		out.print("</body>");		
		out.print("</html>");
	}
	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = response.getWriter();
		out.print("before forward");
		request.setAttribute("reqAttr1", "reqAttr1Value");
		String path = "first";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		out.print("after forward");
	}

	private void include(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = response.getWriter();
		out.print("before include");

		String path = "first";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.include(request, response);
		
		out.print("after include");
	}
	private void redirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = response.getWriter();
		out.print("before redirect");

		String location = "first";
		response.sendRedirect(location);
		
		out.print("after redirect");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if(opt == null || opt.equals("")) {//?���??��?��?��?��?��(?���?:opt)�? ?��?��?��?�� 경우
			show(request, response);
		}else if(opt.equals("forward")) { //
			forward(request, response);
		}else if(opt.equals("include")) {
			include(request, response);
		}else if(opt.equals("redirect")) {
			redirect(request, response);
		}
	}
}
