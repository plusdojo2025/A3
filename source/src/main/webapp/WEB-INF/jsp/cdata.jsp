<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--ここから名前検索--%>
<h1>検索</h1><br>
<form method="POST" action="/A3/CDataServlet">
苗字<input type="text" name="k_f_name">
名前<input type="text" name="k_l_name">
住所<input type="text" name="address"><br>
電話番号<input type="text" name="phone"><br>


<input type="submit" name="search" value="検索"><br>
</form>
<a href="/A3/CDataServlet">メニューへ戻る</a>
</body>
</html>