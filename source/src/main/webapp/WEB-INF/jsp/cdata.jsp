<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報</title>
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/cdata.css">
</head>

<body>
<h1>検索</h1><br>
<hr>

<!-- 検索フォーム -->
<form method="POST" action="/A3/CDataServlet" class="searcher-box">

   <%-- <div class="form-row">
	<label>名前検索</label>
	<input type="text" name="full_name" placeholder="氏名を入力してください">
	</div>
	
 
	<div class="form-row">
	<label>ミョウジ</label>
	<input type="text" name="k_f_name"></div><br>
		
	<div class="form-row">
	<label>苗字</label>
	<input type="text" name="f_name"></div><br>
		
	<div class="form-row">
	<label>ナマエ</label>
	<input type="text" name="k_l_name"></div><br>
		
	<div class="form-row">
	<label>名前</label>
	<input type="text" name="l_name"></div><br>
		
	<div class="form-row">
	<label>電話番号</label>
	<input type="text" name="phone"></div><br>
	
	<input type="submit" name="search" value="検索" class=sercher-botton><br>
	
</form>
--%>
<div class="form-row">
        <label>名前検索</label>
        <input type="text" name="full_name" placeholder="氏名を入力してください">
    </div>
    <input type="submit" name="search" value="検索" class="sercher-botton"><br>
</form>

<!-- ↓ 検索結果表示 -->
<c:forEach var="e" items="${cardList}">
  <details class="details-box">
    <summary>${e.fName} ${e.lName}</summary>
    <div class="details-content">
      <p>性別：${e.gender}</p>
      <p>住所：${e.address}</p>
      <p>電話番号：${e.phone}</p>
    </div>
  </details>
</c:forEach>
<c:if test="${empty cardList && searched}">
    <p>一致するデータがありません</p>
</c:if>

<a href="/A3/HomeServlet">ホームへ戻る</a>
</body>
</html>