<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申し込み確認</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>
<body>
<img src = "img/gouka.png" class="logomain">
<c:out value ="${user.lName}"></c:out>
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
<h2 id="regist">申し込み確認</h2>
 	<form method="POST" action="<c:url value='/ApplyCompServlet' />">
		<p>〇選択したコース<br>${course.courseName}コース<br>${course.intro}</p>
		
		<p>〇希望式場<br>
		${sikijo.sName}<br>
		${sikijo.sImage }
		</p>
		
		<label>〇オプション</label>
		<c:if test ="${not empty opMsg }">
			<p>${opMsg }</p>
		</c:if>
		<c:forEach var="e" items="${options}">
		    <li>${e.optionName} : ${e.optionPrice}万円</li>
		</c:forEach>	
		<p>【オプション合計金額】 ${opsum}万円</p>		
		
		<label>〇備考<br>
		${remarks }<br>
    	</label>
		
		<p>		
		<input type="submit" name="submit" value="申し込む">
		</p>
	</form>
	<button type="submit" name="return" value="戻る" onclick="history.back();">選択へ戻る</button>
</main>
<footer>
<div class="footer">
	<ul>
		<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
		<%-- <li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li> --%>
		<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
		<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
		<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
		<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
	</ul>
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
</footer>
</body>
</html>