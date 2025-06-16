<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/cdata.css">
</head>
<body>
<h1>検索</h1><br>
<div class="searcher-box">
	<form method="POST" action="/A3/CDataServlet">
		<label>ミョウジ</label>
		<input type="text" name="k_f_name"><br>
		
		<label>苗字</label>
		<input type="text" name="f_name"><br>
		
		<label>ナマエ</label>
		<input type="text" name="k_l_name"><br>
		
		<label>名前</label>
		<input type="text" name="l_name"><br>
		
		<label>電話番号</label>
		<input type="text" name="phone"><br>
	</form>
</div>
<input type="submit" name="search" value="検索"><br>
	
<a href="/A3/CDataServlet">メニューへ戻る</a>
</body>
</html>