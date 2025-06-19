<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/pwelcome.css' />">
</head>
<body>
<ul id="nav">
	<li><a href="/A3/HomeServlet">ホーム</a></li>
	<li><a href="/A3/ApplyServlet">申し込み</a></li>
	<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
	<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
	<li><a href="/A3/〇〇Servlet">チャット(Q＆A)</a></li>
	<li><a href="/A3/PMypServlet">マイページ</a></li>
	<li><a href="/A3/PLoginServlet">ログアウト</a></li>
</ul>

<div class="name-box">
<P>ようこそ<c:out value="${planner.pName}"/></P>
</div>
</body>
</html>