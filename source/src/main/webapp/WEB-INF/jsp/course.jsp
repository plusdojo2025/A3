<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コース一覧</title>
<link rel="stylesheet" href="css/course.css"> 
<link rel="stylesheet" href="css/all.css">
</head>
<body>
<div class="logo-wrapper">
<img src ="${pageContext.request.contextPath}/img/gouka.png" class="logomain">
<p class="username">
ようこそ<c:out value ="${user.fName}"></c:out><c:out value ="${user.lName}"></c:out>さん
</p>
</div>
<ul id="niv">
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
</ul>
<div class="hero">
<h2 class="herosimu">コース一覧</h2>
</div>
<ul class="course-list">
<h1>●３つのコース</h1>
<c:forEach var="e" items="${courseList}" >
	<li><a href="SikijoServlet?course_id=${e.courseId}">${e.courseName}コース</a></li>
	<div class="course-comment">
	<p>${e.comment}</p>
	</div>
</c:forEach>
</ul>

<%-- <li><a href="SikijoServlet?courseId=2">${e.name}</a>
<p>白を基調とした厳かな挙式、バージンロードの入場、会場など<br>
ロマンチックな雰囲気を活かした洋婚式スタイル</p>
<li><a href="SikijoServlet?courseId=3">${e.name}</a>
<p>和の伝統美と洋の華やかさが調和し、<br>
どちらも楽しめる和洋折衷ウェディング</p> --%>

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