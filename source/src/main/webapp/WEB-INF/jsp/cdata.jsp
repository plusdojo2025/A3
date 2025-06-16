<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報</title>
<link rel="stylesheet" href="/A3/css/all.css">
<link rel="stylesheet" href="/A3/css/cdata.css">
</head>
<body>
<h1>検索</h1><br>
<form method="POST" action="/A3/CDataServlet">
セイ<input type="text" name="k_f_name"><br>
メイ<input type="text" name="k_l_name"><br>
住所<input type="text" name="address"><br>
電話番号<input type="text" name="phone"><br>

<input type="submit" name="search" value="検索"><br>
</form>
<a href="/A3/CDataServlet">メニューへ戻る</a>
</body>
</html>