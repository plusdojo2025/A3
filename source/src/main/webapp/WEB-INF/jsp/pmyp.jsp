<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rei="stylesheet" href="/A3/css/all.css">
<link rei="stylesheet" href="/A3/css/pmyp.css">
</head>
<body>
	<div class="myp">
	<form method="POST" action="/A3/UmypServlet" method="get" class="pmyp-form">	>
		<h2>マイページ</h2>
		名前：<input type="text" name="name" required="required" value="${name} }">
		顔：<input type="text" name="image" required="required" value="${image} }">		
		性別：<input type="text" name="gender" required="required" value="${gender} }">
		式場住所：<input type="text" name="siki_add" required="required" value="${siki_add} }">
		電話番号：<input type="text" name="phone" required="required" value="${phone} }">
		得意分野：<input type="text" name="strong_fild" required="required" value="${strong_fild} }">
	<div></div>
	</form>	
</body>
</html>