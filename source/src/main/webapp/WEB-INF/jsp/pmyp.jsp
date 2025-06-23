<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="/A3/css/all.css">
<link rel="stylesheet" href="/A3/css/pmyp.css">
</head>
<body>
	<div class="myp">
	<form method="POST" action="/webapp/PmypServlet">
		<h2>マイページ</h2>
		名前：<input type="text" name="name" required="required" value="${planner.pName}">
		性別：<input type="text" name="gender" required="required" value="${planner.pGender}">
		式場住所：<input type="text" name="siki_add" required="required" value="${planner.sikiAdd}">
		電話番号：<input type="text" name="phone" required="required" value="${planner.pPhone}">
		得意分野：<input type="text" name="strong_fild" required="required" value="${planner.strongFild}"> 
		写真：<c:if test="${not empty e.pimage}">
		<img src="${e.psimage}" alt="プランナー画像" width="150">
		</c:if>
		
	</form>
	</div>	
</body>
</html>