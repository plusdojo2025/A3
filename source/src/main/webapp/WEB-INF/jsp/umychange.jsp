 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報検索</title>
</head>
<body>
<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/webapp/UMyChangeServlet">
	生年月日<input type="text" name="birthday" value="${e.birthday}"><br>
	住所<input type="text" name="address" value="${e.address}"><br>
	電話番号<input type="text" name="phone" value="${e.phone}"><br>
	メールアドレス<input type="text" name="email" value="${e.email}"><br>
	
	<input type="submit" name="submit" value="更新">
	<input type="submit" name="submit" value="削除"><br>
</form>
	<hr>
</c:forEach>
</body>
</html>