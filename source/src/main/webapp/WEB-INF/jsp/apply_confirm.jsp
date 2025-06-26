<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
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
	<h2 id="regist">申し込み確認</h2>
</div>
<div class="confirm">
 	<form method="POST" action="<c:url value='/ApplyCompServlet' />">
		<span class="label">〇選択したコース</span><br>${course.courseName}コース<br>${course.intro}</p>
		
		<span class="label">〇希望式場</span><br>	
		${sikijo.sName}<br>
		<div calss="siki_img">
		<img src="${pageContext.request.contextPath}/images/${sikijo.sImage}" alt="式場画像" width="550">
		</div>
		
		<span class="label">〇オプション</span>
		<c:if test ="${not empty opMsg }">
			<p>${opMsg }</p>
		</c:if>
		<c:forEach var="e" items="${options}">
		    <li>${e.optionName} : ${e.optionPrice}万円</li>
		</c:forEach>	
		<%-- <p>【オプション合計金額】 ${opsum}万円</p>	 --%>	
		<br>
		
		<span class="label">〇備考</span><br>
		${remarks }<br>
		<br>
		
		<span class="label">【合計金額】</span><br>
		${sum} 円
		
		<p class="submit">		
		<input type="submit" name="submit" value="申し込む">
		</p>
	</form>
	<div class="return">
	<button type="submit" name="return" value="戻る" onclick="history.back();">選択へ戻る</button>
	</div>
</div>
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
  window.addEventListener('pageshow', function(event) {
    if (event.persisted || performance.getEntriesByType("navigation")[0].type === "back_forward") {
      const radios = document.querySelectorAll('input[type="radio"]');
      radios.forEach(radio => radio.checked = false);
    }
  });
</script>
</body>
</html>