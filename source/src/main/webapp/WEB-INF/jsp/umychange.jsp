 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報検索</title>
<link rel="stylesheet" href="<c:url value='/css/umypchange.css'/>">
<link rel="stylesheet" href="<c:url value='/css/all.css'/>">
</head>
<body>
<ul id="nav">
<li><a href="<c:url value='/HomeServlet'/>">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet'/>">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet'/>">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet'/>">シミュレーション機能</a></li>
<li><a href="<c:url value='/LoadHistoryServlet'/>">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet'/>">マイページ</a></li>
<li><a href="<c:url value='/LoginServlet'/>">ログアウト</a></li>
</ul>

<div class="change">
 <h3>登録情報の変更・削除</h3>

	<form method="POST" action="/A3/UMyChangeServlet">
	生年月日<br>
	<input type="date" name="birthday" value="${sessionScope.user.birthday}"><br>
	住所<br>
	<input type="text" name="address" value="${sessionScope.user.address}"><br>
	電話番号<br>
	<input type="text" name="phone" value="${sessionScope.user.phone}"><br>
	メールアドレス<br>
	<input type="text" name="email" value="${sessionScope.user.email}"><br>
	
	<input type="submit" name="submita" value="更新">
	<input type="submit" name="submita" value="アカウント削除">
	
	<c:if test="${not empty message}">
    <p style="color:white; font-weight: bold;">${message}</p>
</c:if>
</form>
</div>
</body>
</html>