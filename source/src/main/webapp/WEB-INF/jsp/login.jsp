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
<img src = "img/gouka.png" class="logomain">
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
<form  id="check" method="POST" action="<c:url value='/LoginServlet'/>">
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


<c:if test="${not empty message}">
    <p style="text-align:center;">${message}</p>
</c:if>       
     
<c:if test="${not empty errorMsg}">
    <p id="errorMsg" style="color:white;">${errorMsg}</p>
    
</c:if>
        
	<form method="GET" action="<c:url value='/RegistServlet'/>">
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
      document.getElementById('ptag');
      if(user_id === '' || user_pw === '') {
        event.preventDefault();
        ptag.textContent = 'IDとPWを両方入力してください！';
        ptag.style.display = 'block';
        
        setTimeout(function() {
            ptag.textContent = '';
          }, 5000);
      } 
    };
    
    const username = document.getElementById('check');
    sessionStorage.setItem('username', username);//ユーザー名を保存（セッションストレージ）
    
    // 5秒後にエラーメッセージを非表示にする
    setTimeout(function () {
      const msg = document.getElementById("errorMsg");
      if (msg) {
        msg.style.display = "none";
      }
    }, 5000); // 5000ミリ秒 = 5秒
  </script>

  
</body>
</html>