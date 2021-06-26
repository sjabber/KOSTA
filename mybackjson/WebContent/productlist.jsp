<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.day.dto.Product"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<%-- <c:url var="url1" value="http://localhost:8888/myfront/productlist.html"></c:url> --%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>jsp</title>
    <link rel="stylesheet" href="./css/basic.css" />
   <style>
      /* * {
        box-sizing: border-box;
      } */
      table.productlist {
        width: 500px; /*box-sizeng: border-box에 의해 전체 크기(border, width 등을 더한)가 500px가 된다*/
        height: 300px;
        border: 1px solid;
        border-collapse: collapse;
      }
      table.productlist tr > td {
        width: 20%;
        margin: 5px;
        border: 1px solid;
      }
      table.productlist tr > td > ul {
        list-style-type: none;
        padding: 0px;
        text-align: center;
      }
      table.productlist tr > td > ul > li > img {
        max-width: 100%;
      }
    </style>
</head>
<body>
<c:set var="productList" value="${requestScope.productList }" />
    <table class="productlist">
      <tr>
      <c:forEach items="${productList}" var="p" varStatus="statusObj">
          <c:if test="${statusObj.index % 4 == 0}">
            <c:if test="${statusObj.index > 0}">
              </tr>
            </c:if>
            <tr>
          </c:if>
        <td>
          <ul>
            <li><img src="images/${p.prod_no}.jpg" alt="${p.prod_name}" /></li>
            <li>${p.prod_name}</li>
          </ul>
        </td>
      </c:forEach>
      </tr>
    </table>
    
    
    
    
    
    
<%-- <c:redirect url="http://localhost:8888/myfront/productlist.html"></c:redirect> --%>
<%-- ${url1} --%>
</body>
</html>
<%-- <%
String resultP = (String)request.getAttribute("productlist");
%> --%>
<%-- <%
//요청객체의 속성(이름:"resultProudct")값 얻기
Product resultP = (Product) request.getAttribute("resultProduct");
//요청객체가 null이면 매개변수없는생성자를 이용해 객체생성하기, 
                 //요청객체속성(이름:"resultProduct", 값: resultP)으로 추가하기
if(resultP == null){
	resultP = new Product();
	request.setAttribute("resultProduct", resultP);
}
%>
<jsp:useBean id="resultCustomer" class="com.day.dto.Product" scope="request" /> --%>

<!-- ${productlist} -->
