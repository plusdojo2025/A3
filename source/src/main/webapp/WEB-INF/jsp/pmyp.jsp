<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:forEach var="planner" items="${plannerList}">
	
		<h2>マイページ</h2>
		名前：<input type="text" name="name" required="required" value="${planner.plannerName}">
		顔：<input type="text" name="image" required="required" value="${planner.plannerImage}">		
		性別：<input type="text" name="gender" required="required" value="${planner.plannerGender}">
		式場住所：<input type="text" name="siki_add" required="required" value="${planner.plannerSikiAdd}">
		電話番号：<input type="text" name="phone" required="required" value="${planner.plannerPhone}">
		得意分野：<input type="text" name="strong_fild" required="required" value="${planner.plannerStrongFild}">
		
	</c:forEach>
	</div>	
</body>
</html>