<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プランナー一覧</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/course.css"> 
</head>
<body>
<h1>〇${plannerList[0].sikiAdd}</h1> <!-- 式場の住所 -->
<img src="${pageContext.request.contextPath}/images/${param.image}" alt="式場画像" width="150"><br>
<c:forEach var="e" items="${plannerList}">
名前：<input type="text" value="${e.plannerName}"><br>
性別：<input type="text" value="${e.gender}"><br>
電話番号：<input type="text" value="${e.phone}"><br>
得意分野：<input type="text" value="${e.strongFild}"><br>
<c:if test="${not empty e.image}">
<img src="${e.image}" alt="プランナー画像" width="150">
</c:if>
</c:forEach>
</body>
</html>