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
<img src = "img/gouka.png" class="logomain">
<p class="username">
ようこそ<c:out value ="${user.fName}"></c:out><c:out value ="${user.lName}"></c:out>さん
</p>

<ul id="nov">
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<%-- <li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li> --%>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
<c:url var="chatUrl" value="/SoServlet">
  <c:param name="one" value="${sessionScope.user.userId}" />
  <c:param name="two" value="${sessionScope.applyPlanner.plannerId}" />
 <%--  <c:param name="p_name" value="${sessionScope.applyPlanner.pName}" /> --%>
<li>
  <a href="${chatUrl}">チャット(Q＆A)</a>
</li>
</c:url>
</ul>
<div class="hero">
<h2 class="herosimu">式場一覧</h2>
</div>
<div class="sikijo-container">
<c:forEach var="e" items="${sikijoList}">
	<div class="sikijo-card">
	<c:if test="${not empty e.image}">
	<img src="${pageContext.request.contextPath}/images/${e.image}" alt="式場画像" width="150">
	</c:if>
	<li><a href="<c:url value='PlannerServlet?sikijo_id=${e.sikijoId}&image=${e.image}' />">${e.sikijoName}</a></li>
	<p>${e.sikijoJmNumber}</p>
	<p>${e.sikijoAddress}</p><!-- ココ住所かも？あと、写真も入れる！！ -->
	</div>
</c:forEach>
</div>
<!-- ふっだーここから -->
<div class="footer">
<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
   
</div>
<!-- ふっだーここまで -->
</body>
</html>