<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<h1>検索結果</h1>
<hr>

<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/A3/CDataServlet">
	セイ<input type="text" name="k_f_name" value="${e.k_f_name}"><br>
	メイ<input type="text" name="k_l_name" value="${e.k_l_name}"><br>
	住所<input type="text" name="address" value="${e.address}"><br>
	電話番号<input type="text" name="phone" value="${e.phone}"><br>
	</form>
	<hr>
</c:forEach>
<c:if test="${empty cardList}">
<p>指定された条件に一致するデータはありません。</p>
</c:if>
<a href="/A3/CDataServlet">メニューへ戻る</a>
</body>
</html>