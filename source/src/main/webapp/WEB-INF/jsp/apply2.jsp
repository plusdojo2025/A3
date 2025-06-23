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
	<header>
<!-- 		<h1>aaaaaaaaaa</h1>-->
		<ul id="nav">
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
			<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
			<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
			<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
			<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>コース選択</h2>
 	</div>
 	<form method="POST" action="<c:url value='/ApplySikijoServlet' />">
<%--  	<c:if test="${not empty errorMsg }">
 		<p>${errorMsg }
 	</c:if> --%>
 	<c:forEach var="e" items="${courseList}" >
		<input type="radio" name="course" value="${e.courseId}" required>
		${e.courseName}コース:${e.coursePrice }万円
		<p>${e.comment}</p>
	</c:forEach>
 	    
        <p><input type="submit" id="search" name="submit" value="次へ"></p>	
 		
 	</form>
</main>
<footer>

</footer>

<script>




</script>
</body>
</html>