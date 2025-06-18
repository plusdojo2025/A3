<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/login.css' />">


</head>
<body>

<main>
<!--<c:choose>
    <c:when test="${not empty userName}">
        <h2>ようこそ、${userName} さん！</h2>
        <p>ここはホーム画面です。</p>
    </c:when>

    <c:otherwise>
-->    
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
        
        <c:if test="${not empty errorMsg}">
            <p style="color:white;">${errorMsg}</p>
        </c:if>
        
	<form method="POST" action="/A3/RegistServlet">
	<input type="submit" name="submit" value="新規の方はこちら">	
	</form>
        </div>
   <!--  </c:otherwise>
</c:choose>
 -->


</main>
 

 
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
    
    const username = document.getElementById('check');
    sessionStorage.setItem('username', username);//ユーザー名を保存（セッションストレージ）
  </script>

  
</body>
</html>