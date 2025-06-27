<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザーマイページ</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/umyp.css' />">
</head>
	
<body>
<img src = "img/gouka.png" class="logomain">
<div id="theTime" class="clock"></div>


<ul id="nov">
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
<c:url var="chatUrl" value="/SoServlet">
  <c:param name="one" value="${sessionScope.user.userId}" />
  <c:param name="two" value="${sessionScope.applyPlanner.plannerId}" />
 <%--  <c:param name="p_name" value="${sessionScope.applyPlanner.pName}" /> --%>
</c:url>
</ul>



	<div class="myp">
		<h2>登録情報確認</h2>
		
		 <!-- 仮の画像枠 -->
		 
    <div class="user-image">
    <img src="${ pageContext.request.contextPath}/img/human2.png">
    </div>
	
    <!-- 名前表示（仮） -->
    <%-- <div class="user-name">ボス（ディアボロ）</div> --%>
    <div class="namer-area">
	<c:out value="${user.fName} ${user.lName}さん"/>
   </div>
    
    <%--  <c:forEach var="e" items="${cardList}">
    <div class="user-name">
      <p>ユーザー名：${e.fullName}</p>
    </div>
  </details>
</c:forEach>
     --%>
    
    #SEplus2025SEplus'
    
    
		<form method="get" action="/A3/UMyChangeServlet" method="get" class="umyp-form" action="<c:url value='/UMyChangeServlet' />">
			<button type="submit">登録情報の確認、変更</button>
		</form>
		
		<%--<form method="get" action="/A3/UMypServlet" >
		<button type="submit">申し込み履歴</button>
		</form>--%>
		
		<form method="get" action="<c:url value='/HomeServlet' />">
		<button type="submit">ホームへ戻る</button><br>
		</form>
		
		
		<form method="get" action="<c:url value='/CLogoutServlet' />">
		<button type="submit">ログアウト</button><br>
		</form>
	</div>
</body>

<%--時間表示スクリプト --%>
<script>
  'use strict';
  function updateTime() {
	  const now=new Date ();
	  const hours=now.getHours();
	  const minutes=now.getMinutes();
	  const seconds=now.getSeconds();
	  const theTime = document.getElementById("theTime");
	  theTime.innerText=hours + "時" + minutes + "分" + seconds + "秒";
    }
    updateTime();
    setInterval(updateTime,1000);
    
</script>
</html>