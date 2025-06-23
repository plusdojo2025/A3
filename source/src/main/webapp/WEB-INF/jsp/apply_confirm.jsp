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
	<header>
		<ul id="nav">
			<li><a href="/A3/HomeServlet">ホーム</a></li>
			<li><a href="/A3/ApplyServlet">申し込み</a></li>
			<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
			<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
			<li><a href="/A3/ChatSelectServlet">チャット(Q＆A)</a></li>
			<li><a href="/A3/UmypServlet">マイページ</a></li>
			<li><a href="/A3/LoginServlet">ログアウト</a></li>
		</ul>
	</header>
<main>
</main>
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

</body>
</html>