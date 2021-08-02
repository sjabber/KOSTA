<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.day.dto.Product" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%
    Map<Product, Integer> result = (Map)request.getAttribute("result");
    if (result == null || result.size() == 0) {%>--%>
<c:set var="result" value="${requestScope.result}"/>
<c:choose>
<c:when test="${empty result}">
    장바구니가 비었습니다.
</c:when>
<%--<%
        return;
    }
%>--%>
<c:otherwise>
<%--<%DecimalFormat df = new DecimalFormat("#,##0"); %>--%>
<style>
    .viewcart {position:relative}
    div.viewcart {
        text-align: center;
        display: inline-block;
        border: 1px solid;
    }

    div.viewcart > table > tr > td {

    }
</style>
<script>
    $(function () {
        $('div.viewcart>button.addorder').click(function () {
            $.ajax({
                url: './addorder',
            method: 'get',
            success:function (responseData) {
                // responseData = responseData.trim().replaceAll(/\n/g, "");
                alert(responseData.trim()); // 줄바꿈 제거
                //상품목록 보기 메뉴에 click 이벤트를 강제 발생시킨다.
                $('body > nav > ol > li > a[href="./productlist"]').trigger('click');
                }
            });
        });
    });
</script>
<div class="viewcart">
<h3>장바구니</h3>
<table>
    <tr>
        <th>상품번호</th><th>상품명</th><th>가격</th><th>수량</th><th>금액</th>
    </tr>
<c:forEach items="${result}" var="kv">
    <c:set var="p" value="${kv.key}"/> <%--key 값만 얻기 위함--%>
    <c:set var="quantity" value="${kv.value}"/>

<tr><td>${p.prod_no}</td>
        <td>${p.prod_name}</td>
        <td>${p.prod_price}</td>
        <td>${quantity}</td>
        <td><fmt:formatNumber pattern="#,##0" value="${p.prod_price * quantity}"/></td>
      </tr>
<%--    <%}
    %>--%>
    </c:forEach>
</table>
<button class="addorder">주문하기</button>
</div>
</c:otherwise>
</c:choose>