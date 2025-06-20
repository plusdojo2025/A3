<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申し込み確認</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<header>
		<ul id="nav">
			<li><a href="/A3/HomeServlet">ホーム</a></li>
			<li><a href="/A3/ApplyServlet">申し込み</a></li>
			<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
			<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
			<li><a href="/A3/〇〇Servlet">チャット(Q＆A)</a></li>
			<li><a href="/A3/UmypServlet">マイページ</a></li>
			<li><a href="/A3/LoginServlet">ログアウト</a></li>
		</ul>
	</header>
<main>
</main>
<h2 id="regist">申し込み確認</h2>
 	<form method="POST" action="/A3/ApplyCompServlet">
	
		<p>${siki.sName}</p>
		
		<p><input type="submit" id="search" name="submit" value="申し込む"></p>

	</form>

</body>
</html>