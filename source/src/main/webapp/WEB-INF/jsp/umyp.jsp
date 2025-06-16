<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザーマイページ</title>
	<link rel="stylesheet" href="/A3/css/all.css">
	<link rel="stylesheet" href="/A3/css/cdata.css">
</head>
	
<body>
	<div class="myp">
		<h2>登録情報確認</h2>
		
		<form method="get" action="/webapp/UMyChangeServlet" method="get" class="umyp-form">
			<button type="submit">登録情報の確認、変更</button>
		</form>
		
		<form method="get" action="/webapp/UMypServlet" >
		<button type="submit">申し込み履歴</button>
		</form>
		
		<form method="get" action="/webapp/UMypServlet" >
		<button type="submit">ログアウト</button>
		</form>
		
	</div>
</body>
</html>