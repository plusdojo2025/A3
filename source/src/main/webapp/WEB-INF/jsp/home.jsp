<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!--  ページのコンテンツタイプと文字エンコーディングをUTF-8のHTMLに設定-->
<!DOCTYPE html>
<!--HTML文書の開始を宣言-->
<html>

<!-- ヘッダー（ここから） -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">  
</head>
<body>
<ul>
<li><a href="/webapp/HomeServlet">ホーム</a></li>
<li><a href="/webapp/ApplyServlet">申し込み</a></li>
<!-- ><li><a href="/webapp/〇〇Servlet">式場/コース/プランナー 一覧</a></li> -->
<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
<!-- ><li><a href="/webapp/〇〇Servlet">チャット(Q＆A)</a></li> -->
<li><a href="/webapp/UmypServlet">マイページ</a></li>
</ul>
<!-- ヘッダー（ここまで） -->

<!-- メイン（ここから） -->
<h2>見出し</h2>
<p id="welcome_message">ようこそ、${username}さん！</p>
<ul>
<h3>見出し1</h3>
<h3></h3>
<li>本文</li>
<li>本文</li>
<li>本文</li>
</ul>
<form method="POST" action="">
	<input type="text" name="test">
	<input type="submit" value="クリック">
</form>

<a href ="サーブレットのパス">クリック</a>
<!-- メイン（ここまで） -->

<!-- フッター（ここから） -->
<div id="footer">
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
<!-- フッター（ここまで） -->

<script>
let username=sessionStorage.getItem('username')
if(username){
  document.getElementById('welcome_message').textContent=`ようこそ、${username}さん！`;
}


</script>
</body>
</html>
