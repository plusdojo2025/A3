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
		<ul id="nav">
			<li><a href="/webapp/HomeServlet">ホーム</a></li>
			<li><a href="/webapp/ApplyServlet">申し込み</a></li>
			<li><a href="/webapp/CourseServlet">式場/コース/プランナー 一覧</a></li>
			<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
			<li><a href="/webapp/〇〇Servlet">チャット(Q＆A)</a></li>
			<li><a href="/webapp/UmypServlet">マイページ</a></li>
			<li><a href="/webapp/LoginServlet">ログアウト</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>式場・オプション選択</h2>
 	</div>
<form method="POST" action="/A3/ApplyConfirmServlet">
 	 	<c:forEach var="e" items="${sikijoList}">
			<input type="radio" name="sikijo">${e.sName}
<%-- 			<p>${e.sikijoId}</p>
			<p>${e.sName}</p> --%>
			<p>${e.sAddress}</p><!-- ココ住所かも？あと、写真も入れる！！ --> 
		</c:forEach>  
		
		<label>オプション</label><br>
		<c:forEach var="e" items="${optionList}">
			<input type="checkbox" name="option"><%-- ${e.optionId }, --%>
			${e.optionName }:
			${e.optionPrice }万円
			<br>
		</c:forEach>
        <p><input type="submit" id="search" name="submit" value="申し込む"></p>		
 		
 </form>

</main>
<footer>

</footer>

<script>
//コース選択で表示

</script>
</body>
</html>