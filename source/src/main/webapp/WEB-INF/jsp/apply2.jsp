<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み</title>
	<link rel="stylesheet" href="css/all.css">
	<link rel="stylesheet" href="css/Apply.css">
</head>

<body>
	<header>
<!-- 		<h1>aaaaaaaaaa</h1>-->
		<ul id="nav">
			<li><a href="/webapp/HomeServlet">ホーム</a></li>
			<li><a href="/webapp/ApplyServlet">申し込み</a></li>
			<li><a href="/webapp/CourseServlet">式場/コース/プランナー 一覧</a></li>
			<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
			<li><a href="/webapp/〇〇Servlet">チャット(Q＆A)</a></li>
			<li><a href="/webapp/UmypServlet">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>申し込み</h2>
 	</div>
 	<form method="POST" action="/A3/ApplyServlet">
 	<c:forEach var="e" items="${courseList}" >
		<input type="radio" name="course">${e.courseName}コース
		<p>${e.comment}</p>
	</c:forEach>
 	    
        <p><input type="submit" id="search" name="submit" value="申し込む"></p>	
 		
 	</form>
</main>
<footer>

</footer>

<script>




</script>
</body>
</html>