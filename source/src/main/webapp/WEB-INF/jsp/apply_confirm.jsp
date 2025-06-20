<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申し込み確認</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
<main>
</main>
<h2 id="regist">申し込み確認</h2>
 	<form method="POST" action="/A3/ApplyCompServlet">
	
		<p><c:out value="${siki.sName}"/></p>
		
		<p><input type="submit" id="search" name="submit" value="申し込む"></p>

	</form>

</body>
</html>