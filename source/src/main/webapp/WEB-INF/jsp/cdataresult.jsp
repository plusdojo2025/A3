<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/cdata.css">
</head>
<body>
<h1>検索結果</h1>
<hr>

<c:forEach var="e" items="${cardList}" >
	<form method="GET" action="/A3/CDataResultServlet">
	ミョウジ<input type="text" name="k_f_name" value="${e.k_f_name}">
	苗字<input type="text" name="f_name" value="${e.f_name}"><br>
	ナマエ<input type="text" name="k_l_name" value="${e.k_l_name}">
	名前<input type="text" name="l_name" value="${e.l_name}"><br>
	住所<input type="text" name="address" value="${e.address}"><br>
	電話番号<input type="text" name="phone" value="${e.phone}"><br>
	
	<input type="submit" name="submit" value="更新">
	<input type="submit" name="submit" value="ログアウト"><br>
	</form>
	<hr>
</c:forEach>
<c:if test="${empty cardList}">
<p>指定された条件に一致するデータはありません。</p>
</c:if>
<a href="/A3/PlannerServlet">メニューへ戻る</a>
</body>
</html>