<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="/A3/css/all.css">
<link rel="stylesheet" href="/A3/css/pmyp.css">
</head>
<body>
	<div class="myp">
  <form method="POST" action="/webapp/PmypServlet" style="width:100%; display:flex;">
    <div class="form-left">
      <div class="form-item">
        <label>名前：</label>
        <input type="text" name="name" required="required" value="${planner.pName}" readonly>
      </div>
      <div class="form-item">
        <label>性別：</label>
        <input type="text" name="gender" required="required" value="${planner.pGender}" readonly>
      </div>
      <div class="form-item wide">
		<label>式場住所：</label>
		<input type="text" name="siki_add" required="required" value="${planner.sikiAdd}" readonly>
	</div>
      <div class="form-item">
        <label>電話番号：</label>
        <input type="text" name="phone" required="required" value="${planner.pPhone}" readonly>
      </div>
      <div class="form-item">
        <label>得意分野：</label>
        <input type="text" name="strong_fild" required="required" value="${planner.strongFild}" readonly> 
      </div>
    </div>
    <div class="img-right">
      <img src="${planner.pImage}" alt="プランナー画像" width="150">
    </div>
  </form>
</div>
</body>
</html>