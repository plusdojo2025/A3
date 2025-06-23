<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>式場一覧</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/course.css"> 
</head>
<body>
<h1></h1>
<c:forEach var="e" items="${sikijoList}">
	<li><a href="PlannerServlet?sikijo_id=${e.sikijoId}">${e.sikijoName}</a></li>
	<p>${e.sikijoJmNumber}</p>
	<p>${e.sikijoAddress}</p><!-- ココ住所かも？あと、写真も入れる！！ -->
<c:if test="${not empty e.image}">
<img src="${pageContext.request.contextPath}/images/${e.image}" alt="式場画像" width="150">
</c:if>
</c:forEach>
</body>
</html>