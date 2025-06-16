<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プランナー一覧</title>
</head>
<body>
<c:forEach var="e" items="${plannerList}" >
<h1>〇${sikijoName}</h1><!-- 式場の名前と写真も入れたい -->
名前<input type="text" name="name" value="${e.○○}"><br>
性別<input type="text" name="Gender" value="${e.○○}"><br>
電話番号<input type="text" name="phone" value="${e.○○}"><br>
得意分野<input type="text" name="strong_fild" value="${e.○○}"><br>
写真
</c:forEach>
</body>
</html>