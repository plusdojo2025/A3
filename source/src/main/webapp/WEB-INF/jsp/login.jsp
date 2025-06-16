<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/all.css">

</head>
<body>
<ul id="nav">
<li><a href="/webapp/HomeServlet">ホーム</a></li>
<li><a href="/webapp/ApplyServlet">申し込み</a></li>
<li><a href="/webapp/〇〇Servlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
<li><a href="/webapp/〇〇Servlet">チャット(Q＆A)</a></li>
<li><a href="/webapp/UmypServlet">マイページ</a></li>
</ul>

<main>
<div class="login_box">
<h2>ログイン</h2>
<form  id="check" method="POST" action="/A3/HomeServlet">
            <table>
              <tr>
                <td>
                  <label>ユーザーID<br>
                  <input type="text" name="id" id="id">
                  </label>
                </td>
              </tr>
              <tr>
                <td>
                  <label>パスワード<br>
                  <input type="password" name="pw" id="pw">
                  </label>
                </td>
              </tr>
              <tr>
                <td>
                  <input type="submit" name="submit" value="ログイン">
                  <input type="reset" name="reset" value="リセット">
                </td>
              </tr>
            </table>
            <p id="ptag"></p>
</form>            
	<form method="POST" action="/A3/RegistServlet">
	<input type="submit" name="submit" value="新規の方はこちら">	
</form>

</div>
</main>
 

 <%-- ユーザーログインの整合性を取る
 <script>
      'use strict';

    document.getElementById('check').onsubmit = function(event){
      const user_id = document.getElementById('id').value.trim();
      const user_pw = document.getElementById('pw').value.trim();
      if(user_id === '' || user_pw === '') {
        event.preventDefault();
        document.getElementById('ptag').textContent = 'IDとPWを両方入力してください！';
      } 
    };
  </script>
  --%>
  
</body>
</html>