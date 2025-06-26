<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>結婚しなサイト｜申し込み完了</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>
<body>
<img src = "img/gouka.png" class="logomain">
<p class="username">
ようこそ<c:out value ="${user.fName}"></c:out><c:out value ="${user.lName}"></c:out>さん
</p>
	<header>
		<ul id="nav">
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
			<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
			<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
			<%--<li> <a href="<c:url value='/SoServlet' />"> --%>
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
	<h2>申し込み完了</h2>
</div>
<div class="comp">
	<p class="finish">〇 申し込み内容 〇</p>
	<c:forEach var="a" items="${appList}">
		<div class="apply-card">
			<div class="row">
				<span class="label"> ${a.courseName}コース</span><br>${a.intro}
			</div>
		    <div class="row">
		    <span class="label">希望式場</span><br>${a.sName}<br>		    
			<img src="${pageContext.request.contextPath}/images/${a.sImage}" alt="式場画像" width="550">
			</div>
			<div class="row">
				<span class="label">プランナー</span><br>
				${a.pName }(${a.pGender })<br>
				得意分野：${a.strongFild}
			</div>			
		    <div class="row">
		    	<span class="label">オプション</span><br>
		    	<c:if test ="${empty a.optionNames}">
					<p>未選択</p>
				</c:if>
		        <c:forEach var="opt" items="${a.optionNames}" varStatus="status">
		          ${opt}<c:if test="${!status.last}">, </c:if>
		        </c:forEach>
	    	</div>
	    	<div class="row">
	    		<span class="label">備考</span><br> ${a.remarks}
	    	</div>
	    </div>	
	</c:forEach>
 	<div class="row"><span class="label">合計金額</span>：${totalPrice} 円</div>
</div><!-- class=comp -->
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

</body>
</html>