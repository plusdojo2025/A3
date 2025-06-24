 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報検索</title>
<link rel="stylesheet" href="<c:url value='/css/umypchange.css'/>">
<link rel="stylesheet" href="<c:url value='/css/all.css'/>">
</head>
<body>
<ul id="niv">
<li><a href="<c:url value='/HomeServlet'/>">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet'/>">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet'/>">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet'/>">シミュレーション機能</a></li>
<li><a href="<c:url value='/LoadHistoryServlet'/>">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet'/>">マイページ</a></li>
<li><a href="<c:url value='/CLogoutServlet'/>">ログアウト</a></li>
</ul>

<div class="change">
 <h3>登録情報の変更・削除</h3>

	<form id="changeForm" method="POST" action="<c:url value='/UMyChangeServlet'/>">
	<div class="name-row">
  　　<div class="input-block">
	<label>名字<br>
	<input type="text" name="f_name" value="${sessionScope.user.fName}"><br>
	</label>
	</div>
	<div class="input-block">
	<label>名前<br>
	<input type="text" name="l_name" value="${sessionScope.user.lName}"><br>
	</label>
	</div>
	</div>
	
	<div class="name-row">
  　　<div class="input-block">
	<label>住所<br>
	<input type="text" name="address" value="${sessionScope.user.address}"><br>
	</label>
	</div>
	<div class="input-block">
	<label>生年月日<br>
	<input type="date" name="birthday" value="${sessionScope.user.birthday}"><br>
	</label>
	</div>
	</div>
	
	<div class="name-row">
  　　<div class="input-block">
	<label>電話番号<br>
	<input type="text" name="phone" value="${sessionScope.user.phone}"><br>
	</label>
	</div>
	<div class="input-block">
	<label>メールアドレス<br>
	<input type="text" name="email" value="${sessionScope.user.email}"><br>
	</label>
	</div>
	</div>
	
	<input type="submit" name="submita" value="更新">
	<input type="submit" name="submita" value="アカウント削除">
	
	<c:if test="${not empty message}">
    <p id="msg" style="color:white; font-weight: bold;">${message}</p>
	</c:if>
	
	<p style="font-size: small; color: white;">※上記以外の変更・削除についてはこちらのメールアドレスまでお問い合わせください</p>
	<p style="font-size: small; color: white;">kekkonsinasite.2025@keroro.com</p>
</form>
</div>

<script>
window.onload = function () {
    // メッセージ非表示（5秒後）
    const msg = document.getElementById("msg");
    if (msg) {
      setTimeout(() => {
        msg.style.display = "none";
      }, 5000);
    }

    // アカウント削除確認
    const form = document.getElementById("changeForm");
    const deleteBtn = form.querySelector("input[name='submita'][value='アカウント削除']");

    form.addEventListener("submit", function (e) {
      const clicked = document.activeElement;
      if (clicked === deleteBtn) {
        const confirmDelete = confirm("本当にアカウントを削除してもよろしいですか？");
        if (!confirmDelete) {
          e.preventDefault();
        }
      }
    });
  };
</script>
</body>
</html>