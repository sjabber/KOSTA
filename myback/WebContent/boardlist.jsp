<%@ page import="com.day.dto.Board" %>
<%@ page import="com.day.dto.PageBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- boardlist.jsp --%>
<% PageBean<Board> pb = (PageBean)request.getAttribute("pb");
    pb.getCurrentPage();
    pb.getTotalPage();
    pb.getList();
    pb.getStartPage();
    pb.getEndPage();
    pb.getUrl();
%>