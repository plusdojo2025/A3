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
<c:forEach var="e" items="${plannerList}" >
<h1>〇${e.plannerSikiAdd}</h1><!-- 式場の名前と写真も入れたい -->
名前<input type="text" name="name" value="${e.plannerName}"><br>
性別<input type="text" name="Gender" value="${e.plannerGender}"><br>
電話番号<input type="text" name="phone" value="${e.plannerPhone}"><br>
得意分野<input type="text" name="strong_fild" value="${e.plannerStrongFild}"><br>
写真<input type="text" name="image" value="${e.plannerImage}"><br>
</c:forEach>
</body>
</html>