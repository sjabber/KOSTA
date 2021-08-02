<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int i=9;%> <%-- 메서드 내부 지역변수 --%>
<%i++; %>
<%out.print("i변수값은 : " +i); %>
<hr>
지역변수 i변수값은 : <%=i %> <%-- out.print 와 같은 역할을 수행한다. --%>
<hr>
<%! int i; %> <%-- 메서드 외부 전역변수 --%>
멤버변수 i변수값은 : <%=this.i %> <%-- out.print 와 같은 역할을 수행한다. --%>
<%-- <%! out.print("_jspService()의 외부입니다."); %> --%>
<hr>
<%//자바 주석 %>
<!-- html 주석 -->
<%-- JSP 전용 주석문 --%>


</body>
</html>