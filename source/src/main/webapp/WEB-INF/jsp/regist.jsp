<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結婚しなサイト｜新規登録</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/regist.css' />">
<!-- <link rel="stylesheet" href="css/all.css"> 
<link rel="stylesheet" href="css/regist.css">  -->
</head>
<body>
<!-- ヘッダーここkら -->
<%-- <ul id="nav">
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
</ul> --%>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<div class="hero">
<h2 class="herocontact">新規登録</h2>
</div>
<form method="POST" id="form" action="<c:url value='/RegistServlet' />" >
<table>
<tr>
	<td>
		<label>ID(必須)</label>
	</td>
	<td>
		<label>Password(必須)</label>
		
	</td>
<tr>
	<td>
	<input type="text" name="id" id="id"><br>
	</td>

	<td>
		<label>
		<input type="text" name="pw" id="pw"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>姓</label>
	</td>
	<td>
		<label>名</label>
	</td>
</tr>
<tr>
	<td>
	<label>
		<input type="text" name="fName"><br>
		</label>
	</td>
	<td>
		<label>
		<input type="text" name="lName"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>セイ</label>
	</td>

	<td>
	<label>メイ</label>
	</td>
</tr>
<tr>
	<td>
		<label>
		<input type="text" name="kfName"><br>
		</label>	
	</td>
	<td>
		<label>
		<input type="text" name="klName"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>生年月日</label>
	</td>
</tr>
<tr>
	<td>
		<label>
		<input type="date" name="birthday"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>性別</label>
	</td>
</tr>
<tr>
	<td>
		<label id="genderbox">
		<input type="radio" name="gender"value="male"onclick="radioDeselection(this, 1)" checked>男性</label><br>
    </td>
    <td>
        <label>
        <input type="radio" name="gender" value="female" onclick="radioDeselection(this, 2)">女性<br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>郵便番号</label>
	</td>
</tr>
<tr>
	<td>
		<label>
		<input type="text" name="zipcode"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>住所</label>
	</td>
</tr>
<tr>
	<td>
		<label>
		<input type="text" name="address"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
	<span id="error_message2"></span>
		<label>メール(@以降も入力)</label>
	</td>
</tr>
<tr>
	<td>
		<label>
		<input type="text" name="email"><br>
		</label>
	</td>
</tr>
<tr>
	<td>
		<label>電話</label>
	</td>
</tr>
<tr>
	<td>
		<label>
		<input type="text" name="phone"><br>
		</label>
	</td>
</tr>
</table>

<p id="error_message"></p>
<span style="color:red;" id="error_message"></span>
<input type="submit" name="regist" value="登録" onclick="return touroku()">
<%-- <c:if test="${not empty error}">
    <p style="text-align:center;">${error}</p>
</c:if> --%>
<c:set var="isPost" value="${isPost != null ? isPost : false}" />
${error}
</form>

<!-- メインここまで -->
<!-- ふっだーここから -->

<div class="footer">
<li><a href="/A3/HomeServlet">トップに戻る</a></li>
<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
<!-- ふっだーここまで -->
<script>
'use strict';
var remove = 0;

function radioDeselection(already, numeric) {
  if(remove == numeric) {
    already.checked = false;
    remove = 0;
  } else {
    remove = numeric;
  }
}

/* let formObj = document.getElementById('regist_form'); */
let errorMessageObj = document.getElementById('error_message');


      
  /* 確認ダイアログボックスを表示します */
function touroku(event){
    	 
     const user_id = document.getElementById('id').value.trim();
    const user_pw = document.getElementById('pw').value.trim();
    
    if(user_id === '' || user_pw === '') {
      /* event.preventDefault(); */
      document.getElementById('error_message').textContent = 'IDとPWを両方入力してください！';
   
      return false;
      
    }  
    
     if (!window.confirm('実行します。よろしいですか？')) {
	   	 /* event.preventDefault();  */
		
	} 
}

</script>
</body>
</html>