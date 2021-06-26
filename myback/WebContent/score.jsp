<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! int totalScore;
    int cnt = 0;
%>
<%
    int now = Integer.parseInt(request.getParameter("score"));
    totalScore += now;
    cnt++; //참여횟수 누적
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        div {
            margin: 20px 20px 20px 20px;
        	width : 380px;
        	height : 100px;
        }

        div > div.box {
            border : 1px solid black;
            padding: 5%;
        }
    </style>
</head>
<body>
<div>
    <div class="box">
        선택한 별점은 <%=now %>점 입니다.
        <br/>
        별점 총점은 <%=totalScore %>점 입니다.
        <br/>
        <%--DecimalFormat은 java.text.DecimalFormat 패키지에 있음--%>
        <%! DecimalFormat df = new DecimalFormat("0.0"); %>
        평점은 (<%= df.format((float) totalScore / cnt) %>점 / <%=cnt%> )입니다. (총점/ 별점 주기회수 )
        <br />
        <a href="score.html">별점주기</a>
    </div>
</div>
</body>
</html>