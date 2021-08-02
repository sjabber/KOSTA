<%@ page contentType="text/html;charset=UTF-8"
         isErrorPage="true" %> <%-- isErrorPage가 true 인 페이지에선 exception이 사용 가능해진다. --%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert here</title>
</head>
<body style="background-color: yellow;">
<%--<% request.getAttribute() %> 이렇게 쓸 필요가 없어진다. --%>
<h2><%=exception.getMessage() %></h2>
</body>
</html>
