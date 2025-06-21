<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み</title>
	<link rel="stylesheet" href="css/all.css">
	<link rel="stylesheet" href="css/Apply.css">
</head>

<body>
	<header>
		<ul id="nav">
			<li><a href="/A3/HomeServlet">ホーム</a></li>
			<li><a href="/A3/ApplyServlet">申し込み</a></li>
			<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
			<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
			<li><a href="/A3/〇〇Servlet">チャット(Q＆A)</a></li>
			<li><a href="/A3/UmypServlet">マイページ</a></li>
			<li><a href="/A3/LoginServlet">ログアウト</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>式場・オプション選択</h2>
 	</div>
<form method="POST" action="/A3/ApplyConfirmServlet">
	
	<%-- <p><c:out value="${sessionScope.courseId.courseName}" />コース</p>
 --%>
 	<c:if test="${not empty errorMsg }">
 		<p>${errorMsg }
 	</c:if>	
 	<c:forEach var="e" items="${sikijoList}">
		<input type="radio" name="sikijo" value="${e.sikijoId }">${e.sName}
<%-- 		<p>${e.sikijoId}</p>
			<p>${e.sName}</p> --%>
			<p>${e.sAddress}</p><!-- ココ住所かも？あと、写真も入れる！！ --> 
	</c:forEach>  
		
	<label>オプション</label><br>
	<c:forEach var="e" items="${optionList}">
		<input type="checkbox" name="option" value="${e.optionId }"><%-- ${e.optionId }, --%>
		${e.optionName }:
		${e.optionPrice }万円
		<br>
	</c:forEach>
    <label>備考<br>
		<textarea name="remarks" rows=4 cols=40></textarea><br>
    </label>
    <p><input type="submit" name="submit" value="申し込み確認へ"></p> 		
</form>
	<button type="submit" name="return" value="戻る" onclick="history.back();">コース選択へ戻る</button>
	
</main>
<footer>

</footer>

<script>
//コース選択で表示

</script>
</body>
</html>