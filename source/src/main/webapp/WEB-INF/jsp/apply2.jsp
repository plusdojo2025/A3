<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>結婚しなサイト｜申し込み</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>

<body>
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
			<%-- <li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li> --%>
			<li><c:url var="chatUrl" value="/SoServlet">チャット(Q＆A)
				  <c:param name="one" value="${sessionScope.user.userId}" />
				  <c:param name="two" value="${sessionScope.applyPlanner.plannerId}" />
				 <%--  <c:param name="p_name" value="${sessionScope.applyPlanner.pName}" /> --%>
				</c:url></li>
			<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>コース選択</h2>
 	</div>
	<form method="POST" action="<c:url value='/ApplySikijoServlet' />">
	 	<div class="course">
		 	<c:forEach var="e" items="${courseList}" >
			 	<div class="course_card">
						<input type="radio" name="course" value="${e.courseId}" required>
						${e.courseName}コース:${e.coursePrice }円<br>
					
					<p>${e.comment}</p>
				</div>
			</c:forEach>	
		</div><!-- class="course" --> 	    
	    <div class="next">
	        <p><input type="submit" id="search" name="submit" value="次へ"></p>		
		</div>
	</form>
 
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
   
</div>
</footer>
<script>
</script>
</body>
</html>