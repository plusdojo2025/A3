<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/cdata.css' />">
</head>

<body>
<%--時間表示 --%>
<div id="theTime" class="clock"></div>

<ul id="nav">
<li><a href="<c:url value='/PWelcomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/CDataServlet' />">顧客情報</a></li>
<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/PMypServlet' />">マイページ</a></li>
<li><a href="<c:url value='/PLogoutServlet' />">ログアウト</a></li>
</ul>


<h1>検索</h1><br>
<h3>＊入力しないと全件表示されます。</h3>


<!-- 検索フォーム -->
<form method="POST" action="<c:url value='/CDataServlet'/>" class="searcher-box">

 
<div class="form-row">
        <label>名前検索</label>
        <input type="text" name="fullName" placeholder="氏名を入力してください">
        
    </div>
    <input type="submit" name="search" value="検索" class="sercher-botton"><br>
</form>

<!-- ↓ 検索結果表示 -->

<c:forEach var="e" items="${cardList}">
  <details class="details-box">
    <summary>${e.fName} ${e.lName}</summary>
    <div class="details-conten">
      <p>性別：${e.gender}</p>
      <p>住所：${e.address}</p>
      <p>電話番号：${e.phone}</p>
    <c:if test="${not empty memoText && e.userId == param.uId}">
      <p style="color: blue;">登録済みのメモ：${memoText}</p>
	</c:if>
     <form method="POST" action="<c:url value='/CDataServlet'/>" class="searcher-box">
		記録：<input type="text" value="${e.memo}" name="memo"><br>
		<input type="hidden" name="uId" value="${e.userId}">
		<input type="hidden" name="full_name" value="${fullName}">
		<input type="submit" name="regist" value="登録" onclick="return touroku()">
    </form>
    </div>
  </details>
</c:forEach>

<c:if test="${empty cardList}">
    <p>一致するデータがありません</p>
</c:if>
<div class=gohome>
<a href="<c:url value='/PWelcomeServlet' />">ホームへ戻る</a>
</div>
</body>
<!-- ふっだーここから -->
<div class="footer">
<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
  
</div>
<!-- ふっだーここまで -->
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