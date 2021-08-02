<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page errorPage="err.jsp" %>
<%--<%@ page buffer="8kb" %>--%>
<%--<%@ page buffer="none" %>--%> <%--1바이트씩 옮겨져 속도가 매우 떨어진다.--%>
<%@ page buffer="1kb" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    for (int i = 1; i <= 100; i++) {
%>
<div><%=i%>
</div>
<%
    }
%>

<%--
<% //a.txt파일 내용 1바이트 읽기
    String fileName = "a.txt";
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(fileName);
    } catch (FileNotFoundException e) {
%><h1>오류내용 : <%=e.getMessage()%></h1>
<%}
%>
--%>
<%--<% //a.txt파일 내용 1바이트 읽기
    String fileName = "a.txt";
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(fileName);
    } catch (FileNotFoundException e) {
        request.setAttribute("exception", e);
        String path = "err.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
%>--%>
<%
    String fileName = "a.txt";
    FileInputStream fis = null;
    fis = new FileInputStream(fileName);
%>


<h1>END</h1>
</body>
</html>