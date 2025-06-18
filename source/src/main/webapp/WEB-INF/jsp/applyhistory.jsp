<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み完了</title>
	<link rel="stylesheet" href="css/all.css">
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
<c:forEach var="e" items="${applyList}">
	<h2>申し込み完了</h2>
	<p>コース<br>${e.courseId}</p>
	<p>希望式場<br>${e.sikijoId}</p>
	<%-- <p>オプション<br>${e.courseId}</p> --%>
	<p>プランナー<br>${e.plannerId}</p>
</c:forEach>
</main>


</body>
</html>