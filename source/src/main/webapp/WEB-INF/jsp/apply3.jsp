<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>

<body>
<img src = "img/gouka.png" class="logomain">
<img src = "img/gouka.png" class="logomain">
<p class="username">
ようこそ<c:out value ="${user.fName}"></c:out><c:out value ="${user.lName}"></c:out>さん
</p>
	<header>
		<ul id="nov">
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
			<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
			<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
			<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
			<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>式場・オプション選択</h2>
 	</div>
<form method="POST" action="<c:url value='/ApplyConfirmServlet' />">
	
	<%-- <p><c:out value="${sessionScope.courseId.courseName}" />コース</p>
 --%>
 	<c:if test="${not empty errorMsg }">
 		<p>${errorMsg }
 	</c:if>	
 	<c:forEach var="e" items="${sikijoList}">
		<input type="radio" name="sikijo" value="${e.sikijoId }">${e.sName}:${e.sPrice }万円
<%-- 		<p>${e.sikijoId}</p>
			<p>${e.sName}</p> --%>
			<p>${e.sAddress}</p><!-- ココ住所かも？あと、写真も入れる！！ --> 
		<%-- 	<p>${e.sImage }</p> --%>
		<c:if test="${not empty e.sImage}">
		<img src="${pageContext.request.contextPath}/images/${e.sImage}" alt="式場画像" width="150">
		</c:if><br>
		<br>
	</c:forEach>  
		
	<label>オプション</label><br>
	<c:forEach var="e" items="${optionList}">
		<input type="checkbox" name="option" value="${e.optionId }"><%-- ${e.optionId }, --%>
		${e.optionName }:
		${e.optionPrice }万円
		<br>
	</c:forEach>
	<br>
    <label>備考<br>
		<textarea name="remarks" rows=4 cols=40></textarea><br>
    </label>
    <p><input type="submit" name="submit" value="申し込み確認へ"></p> 		
</form>
	<button type="submit" name="return" value="戻る" onclick="history.back();">コース選択へ戻る</button>
	
</main>
<footer>
<div class="footer">
	<ul>
		<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
		<%-- <li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li> --%>
		<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
		<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
		<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
		<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
	</ul>
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
</footer>

<script>
//コース選択で表示

</script>
</body>
</html>