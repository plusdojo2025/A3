<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み完了</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>
<body>
	<header>
<!-- 		<h1>aaaaaaaaaa</h1>-->
		<ul id="nav">
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
			<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
			<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
			<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
			<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
		</ul>
	</header>
<main>
<div class="hero">
	<h2>申し込み完了</h2>
</div>
<div class="comp">
	<p>〇 申し込み内容 〇</p>
	<c:forEach var="a" items="${appList}">
<%-- 		<table>
			<td>
				<tr>${a.courseName}コース<br>
						${a.intro}</tr>
				<tr>希望式場<br>
						${a.sName}</tr>
				<tr>オプション<br>
						${a.optionName}</tr>
				<tr>備考<br>
						${a.remarks}</tr>
				<tr></tr>
			</td>
		</table>
 --%>			  
<%-- 			  
		<p>${a.sName}</p>
		<p>${a.optionName}</p>
		<p>${a.remarks}</p>
		<p><c:forEach var="opt" items="${a.optionNames}" varStatus="status">
			      ${opt}<c:if test="${!status.last}">, </c:if></c:forEach>
		</p> --%>
		<div class="apply-card">
			<div class="row"><span class="label">コース:</span> ${a.courseName}</div>
		    <div class="row"><span class="label">コース紹介:</span> ${a.intro}</div>
		    <div class="row"><span class="label">式場:</span> ${a.sName}</div>
		    <div class="row"><span class="label">オプション:</span>
	        <c:forEach var="opt" items="${a.optionNames}" varStatus="status">
	          ${opt}<c:if test="${!status.last}">, </c:if>
	        </c:forEach>
	    </div>
	    	<div class="row"><span class="label">備考:</span> ${a.remarks}</div>
	    	</div>
	 </c:forEach>

	
</div>		
</main>


</body>
</html>