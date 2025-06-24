<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>

<body>
<img src = "img/gouka.png" class="logomain">
<c:out value ="${user.lName}"></c:out>
	<header>
		<ul id="nov">
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
			<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
			<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
			<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
			<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>コース選択</h2>
 	</div>
 	<div class="course">
	 	<form method="POST" action="<c:url value='/ApplySikijoServlet' />">
	<%--  	<c:if test="${not empty errorMsg }">
	 		<p>${errorMsg }
	 	</c:if> --%>
	 	<c:forEach var="e" items="${courseList}" >
	 	<div class="courselist">
			<input type="radio" name="course" value="${e.courseId}" required>
			${e.courseName}コース:${e.coursePrice }万円
			<p>${e.comment}</p>
		</div>
		</c:forEach>	 	    
	        <p><input type="submit" id="search" name="submit" value="次へ"></p>		
	 	</form>
 	</div><!-- class="course" -->
</main>

<footer>
<div class="footer">
	<ul>
		<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
		<%-- <li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li> --%>
		<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
		<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
		<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
		<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
	</ul>
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
</footer>
<script>
</script>
</body>
</html>