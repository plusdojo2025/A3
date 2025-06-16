<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userName = (String) request.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/all.css">
<link rel="stylesheet" type="text/css" href="css/pwelcome.css">
</head>
<body>
<ul id="nav">
	<li><a href="/webapp/HomeServlet">ホーム</a></li>
	<li><a href="/webapp/ApplyServlet">申し込み</a></li>
	<li><a href="/webapp/〇〇Servlet">式場/コース/プランナー 一覧</a></li>
	<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
	<li><a href="/webapp/〇〇Servlet">チャット(Q＆A)</a></li>
	<li><a href="/webapp/UmypServlet">マイページ</a></li>
</ul>

<div class="name-box">
	<h1>ようこそ</h1>
	<h1><%= userName %>さん</h1>
</div>
</body>
</html>