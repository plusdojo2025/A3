<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:out value ="${user.lName}"></c:out>
<ul id="nav">
<li><a href="/A3/HomeServlet">ホーム</a></li>
<li><a href="/A3/ApplyCourseServlet">申し込み</a></li>
<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
<li><a href="/A3/○○Servlet">チャット(Q＆A)</a></li>
<li><a href="/A3/UmypServlet">マイページ</a></li>
<li><a href="/A3/LoginServlet">ログアウト</a></li>
</ul>
<meta charset="UTF-8">
<title>コース一覧</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/course.css">  
</head>
<body>
<h1>〇３つのコース</h1>
<c:forEach var="e" items="${courseList}" >
	<li><a href="SikijoServlet?course_id=${e.courseId}">${e.courseName}コース</a></li>
	<p>${e.comment}</p>
</c:forEach>
<%-- <li><a href="SikijoServlet?courseId=2">${e.name}</a>
<p>白を基調とした厳かな挙式、バージンロードの入場、会場など<br>
ロマンチックな雰囲気を活かした洋婚式スタイル</p>
<li><a href="SikijoServlet?courseId=3">${e.name}</a>
<p>和の伝統美と洋の華やかさが調和し、<br>
どちらも楽しめる和洋折衷ウェディング</p> --%>
</body>
</html>