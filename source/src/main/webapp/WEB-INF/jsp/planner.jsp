<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プランナー一覧</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/course.css"> 
</head>
<body>
<img src = "img/gouka.png" class="logomain">
<c:out value ="${user.lName}"></c:out>
<ul id="nov">
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
</ul>
<div class="hero">
<h2 class="herosimu">プランナー一覧</h2>
</div>
<h1>〇${plannerList[0].sikiAdd}</h1> <!-- 式場の住所 -->
<img src="${pageContext.request.contextPath}/images/${param.image}" alt="式場画像" width="150"><br>
<div class="sikijo-container">
<c:forEach var="e" items="${plannerList}">
<div class="sikijo-card">
名前：<input type="text" value="${e.plannerName}"readonly><br>
性別：<input type="text" value="${e.gender}"readonly><br>
電話番号：<input type="text" value="${e.phone}"readonly><br>
得意分野：<input type="text" value="${e.strongFild}"readonly><br>
<c:if test="${not empty e.image}">
<img src="${e.image}" alt="プランナー画像" width="150">
</c:if>
</div>
</c:forEach>
</div>
<!-- ふっだーここから -->
<div class="footer">
<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
<!-- ふっだーここまで -->
</body>
</html>