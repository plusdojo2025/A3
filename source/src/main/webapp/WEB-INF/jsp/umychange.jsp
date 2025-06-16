 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報検索</title>
<link rel="stylesheet" type="text/css" href="css/umypchange.css">
<link rel="stylesheet" type="text/css" href="css/all.css">
</head>
<body>
<ul id="nav">
<li><a href="/A3/HomeServlet">ホーム</a></li>
<li><a href="/A3/ApplyServlet">申し込み</a></li>
<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
<li><a href="/A3/○○Servlet">チャット(Q＆A)</a></li>
<li><a href="/A3/UmypServlet">マイページ</a></li>
</ul>

<div class="change">
 <h3>登録情報の変更・削除</h3>
<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/webapp/UMyChangeServlet">
	生年月日<input type="text" name="birthday" value="${e.birthday}"><br>
	住所<input type="text" name="address" value="${e.address}"><br>
	電話番号<input type="text" name="phone" value="${e.phone}"><br>
	メールアドレス<input type="text" name="email" value="${e.email}"><br>
	
	<input type="submit" name="submit" value="更新">
	<input type="submit" name="submit" value="削除"><br>
</form>
</c:forEach>
</div>
</body>
</html>