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
	<div class="myp">
		<h2>登録情報確認</h2>
		
		 <!-- 仮の画像枠 -->
		 
    <div class="user-image"><img src="${ pageContext.request.contextPath}/img/human2.png" alt="profile 2"></div>
	
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
    
    
    
    
		<form method="get" action="/A3/UMyChangeServlet" method="get" class="umyp-form">
			<button type="submit">登録情報の確認、変更</button>
		</form>
		
		<form method="get" action="/A3/UMypServlet" >
		<button type="submit">申し込み履歴</button>
		</form>
		
		<form method="get" action="/A3/HomeServlet" >
		<button type="submit">ホームへ戻る</button><br>
		</form>
		
		
		<form method="get" action="/A3/PLoginServlet" >
		<button type="submit">ログアウト</button><br>
		</form>
	</div>
</body>
</html>