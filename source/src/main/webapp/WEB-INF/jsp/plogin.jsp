<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/login.css' />">
</head>
<body>

<main>
<div class="login_box">
<h2>ログイン</h2>
<form  id="check" method="POST" action="<c:url value='/PLoginServlet'/>">
            <table>
              <tr>
                <td>
                  <label>プランナーID<br>
                  <input type="text" name="id" id="id">
                  </label>
                </td>
              </tr>
              <tr>
                <td>
                  <label>パスワード<br>
                  <input type="password" name="password" id="pw">
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
            <p id="ptag" style="color: white; display: none;"></p>
</form>
        <c:if test="${not empty errorMsg}">
            <p id="errorMsg" style="color:white;">${errorMsg}</p>
        </c:if>
</div>

</main>
 

 <%-- ユーザーログインの整合性を取る--%>
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
        
        // 5秒後に非表示
        setTimeout(function () {
          ptag.textContent = '';
        }, 5000);
        
      } 
    };
    
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