<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>구조화용 태그</title>
    <link rel="stylesheet" href="./css/basic.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>

        /** {*/
        /*    box-sizing: border-box;*/
        /*}*/
        body {
            font-size: 100%;
        }

        header {
            color: white;
            background-color: #007042;
            font-size: 2em;
            font-weight: bold;
            width: 80%;
            height: 150px;
            margin: 0px auto;
            line-height: 150px;
            text-align: center;
        }

        header > a.logo {
            background-image: url('./images/logo.png');
            height: 75px;
            width: 75px;
            margin: 25px 0px;
            display: block;
            float: left;
        }

        nav {
            width: 100%;
            height: 90px;
            background-color: #333;
            color: white;
        }

        nav > ol {
            list-style-type: none;
            padding-left: 0px;
        }

        nav > ol > li {
            float: left;
            margin: 10px 30px;
        }

        nav > ol > li > a {
            display: block;
            padding: 8px;
            /*background-color: #dddddd;*/
            color: white;
            text-decoration: none;
        }

        nav > ol > li > a:hover {
            background-color: #000000;
        }

        section {
            clear: both;
            border: 1px solid;
            width: 75%;
            height: 600px;
            float: left;
            overflow: auto;
        }

        article {
            border: 1px solid;
            background-image: url('https://www.starbucks.co.kr/common/img/main/store_exp_img03.png');
            width: 95%;
            height: 45%;
            padding: 10px;
            margin: 5px;
        }

        aside {
            border: 1px solid;
            width: 20%;
            height: 600px;
            float: right;
        }

        footer {
            border: 1px solid;
            width: 80%;
            height: 80px;
            margin: 0px auto;
            clear: both;
        }
    </style>
    <script>
        $(function () { //$(document).ready(function(){});
            $('table.productlist tr > td').click(function () {
                console.log(this);
                var prod_no = $(this).attr('class');
                $.ajax({
                    url: './productinfo',
                    method: 'get',
                    data: {
                        prod_no: prod_no
                    },
                    success: function (responseData) {
                        $('section').empty();
                        $('section').html(responseData);
                        //json형태의 응답결과라면
                        //var htmlStr = '<img src="' + responseData.prod_no + ".jpg>";
                        //$('section').html(htmlStr)
                    }

                }); //상품 상세 정보보기 페이지 : ./productinfo
                // 요청방식 : get
                // 요청전달데이터 : prod_no = 상품번호값
                // 응답 :
            })
        });

        $(function () {
            //DOM트리에서 nav>ol>li>a 객체들 찾기
            var $menuObj = $('nav>ol>li>a');

            //DOM트리에서 section객체 찾기
            var $section = $('section');

            $menuObj.click(function () {
                //클릭된 현재 객체의 href 속성값 얻기 : .attr('href');
                console.log(this);
                var href = $(this).attr('href');
                switch (href) {
                    case './login.html':
                    case './signup.html':
                    case './productlistjson.html':
                    case './productlist':
                    case './viewcart':
                    case './orderlist':
                        // 결과가 항상 같은 경우에만 load를 쓴다. 로그인에는 적합하지 않음 (로그인 실패, 로그인 성공)
                        $section.load(href, function (responseTxt, statusTxt, xhr) {
                            // if(statusTxt == "success")
                            // alert("External content loaded successfully!");
                            if (statusTxt == "error")
                                alert("Error: " + xhr.status + ": " + xhr.statusText);
                        });
                        break;
                    case './logout':
                        alert("로그아웃 되었습니다.");
                        $section.load(href, function (responseTxt, statusTxt, xhr) {
                            // if(statusTxt == "success")
                            // alert("External content loaded successfully!");
                            if (statusTxt == "error")
                                alert("Error: " + xhr.status + ": " + xhr.statusText);
                        });
                        location.href = "./semantic_css_jq.jsp";
                        break;
                }
                return false;
            });
        });
    </script>
</head>
<body>
<header>
    <!-- 메뉴 -->
    <%--${sessionScope.loginInfo}--%>
    <a class="logo" href="#"></a> StarBucks
</header>
<nav>
    <ol>
        <c:choose>
            <c:when test="${empty sessionScope.loginInfo}">
                <li><a href="./login.html">로그인</a></li>
                <li><a href="./signup.html">가입</a></li>
            </c:when>
            <c:otherwise>
                <li>${loginInfo.id}님 반갑습니다.<a href="./logout">로그아웃</a></li>
            </c:otherwise>
        </c:choose>

        <li><a href="./productlist">상품목록</a></li>
        <li><a href="./viewcart">장바구니 보기</a></li>

        <c:if test="${!empty sessionScope.loginInfo}"> <!--!empty : 로그인이 된 경우 -->
            <li><a href="./orderlist">주문목록</a></li>
        </c:if>
    </ol>
</nav>
<section>
    <article>여름의 시작을 함께할 인도네시아 웨스트 자바. 허브의 복합적인 풍미와 낮은 산미, 은은하게
        달콤한 바닐라향이 매력적인 원두 자세히 보기
    </article>
    <article>차별화된 커피 경험을 누릴 수 있는 리저브 매장, 다양한 방법으로 편리하게 즐길 수 있는
        드라이브 스루 매장, 함께해서 더 따뜻할수 있는 지역사회 소통 공간 커뮤니티 매장
    </article>
</section>

<aside>KOSTABUCKS 현대카드</aside>
<footer> 사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송 데이비드 호섭
    TEL : 1522-3232 개인정보 책임자 : 하익성 ⓒ 2021 Starbucks Coffee Company. All
    Rights Reserved.
</footer>
</body>
</html>
