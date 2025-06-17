<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結婚しなサイト｜新規登録</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/regist.css' />">
<link rel="stylesheet" href="css/all.css"> 
<link rel="stylesheet" href="css/regist.css"> 
</head>
<body>
<!-- ヘッダーここkら -->
<ul id="nav">
<li><a href="/webapp/HomeServlet">ホーム</a></li>
<li><a href="/webapp/ApplyServlet">申し込み</a></li>
<li><a href="/webapp/SikijoServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
<li><a href="/webapp/OOServlet">チャット(Q＆A)</a></li>
<li><a href="/webapp/UmypServlet">マイページ</a></li>
</ul>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<div class="hero">
<h2 class="herocontact">新規登録</h2>
</div>
<form method="POST" id="form" action="/A3/RegistServlet">
<table>
<tr>
	<td>
		<label>ID(必須)<span id="error_message"></span></label>
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
		<input type="text" name="f_name"><br>
		</label>
	</td>
	<td>
		<label>
		<input type="text" name="l_name"><br>
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
		<input type="text" name="k_f_name"><br>
		</label>	
	</td>
	<td>
		<label>
		<input type="text" name="k_l_name"><br>
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
		<input type="radio" name="gender "value="male"onclick="radioDeselection(this, 1)">男性</label><br>
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
		<label>メールアドレス(@マークも入力してください)</label>
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
</form>
<form method="POST" action="/A3/RegistServlet">
<input type="submit" name="regist" value="登録" onclick="return touroku()">
</form>
<!-- メインここまで -->
<!-- ふっだーここから -->
<div id="footer">
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

let formObj = document.getElementById('regist_form');
let errorMessageObj = document.getElementById('error_message');

/* ボタンをクリックしたときの処理 */
  /* IDPWを必須入力項目とします */

    /* document.getElementById('form').onsubmit = function(event){
        const user_id = document.getElementById('id').value.trim();
        const user_pw = document.getElementById('pw').value.trim();
        if(user_id === '' || user_pw === '') {
          event.preventDefault();
          document.getElementById('error_message').textContent = 'IDとPWを両方入力してください！';
        }
      }; */
      
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
		return false;
	} 
}

</script>
</body>
</html>