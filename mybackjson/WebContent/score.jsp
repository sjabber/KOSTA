<%@page import="java.text.DecimalFormat"%><%-- import="java.text.*" --%>
<%--<%@page import="java.text.SimpleDecimalFormat"%><%--import= --%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String score = request.getParameter("score");%>
선택한 별점은 <%=score %>점입니다
<%int score2 = Integer.parseInt(request.getParameter("score"));%>
<%!int totalScore; %>
<%double avgScore; %>
<%!int totalCount = 0; %>
<%int scoreCount = score2 / score2;
totalCount += scoreCount;%>
<br>
별점 총점은 <%=this.totalScore = this.totalScore + score2 %>점입니다
<hr>
평점은 <%=avgScore = (double)this.totalScore / totalCount %>점입니다
<br>
<%DecimalFormat df = new DecimalFormat("#.#"); %>
평점은 <%=df.format(avgScore = (double)this.totalScore / totalCount) %>점입니다
<hr>
<a href="http://localhost:8888/myback/score.html">별점주기</a>
</body>
</html>