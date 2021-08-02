<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>menub.jsp</title>
</head>
<body>
<jsp:include page="menu.jsp" /> <%-- 실행시에 포함이 된다. --%>
<h1><%-- <%=msg %> --%></h1>
<%
    String msg ="안녕하세요";
%>
<%=msg%>
</body>
</html>