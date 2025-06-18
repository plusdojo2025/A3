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
<link rel="stylesheet" href="css/all.css"> 
<link rel="stylesheet" href="css/home.css"> 

</head>
<body>
<ul id="nav">
<li><a href="/A3/HomeServlet">ホーム</a></li>
<li><a href="/A3/ApplyServlet">申し込み</a></li>
<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
<li><a href="/A3/○○Servlet">チャット(Q＆A)</a></li>
<li><a href="/A3/UmypServlet">マイページ</a></li>
</ul>
<!-- ヘッダー（ここまで） -->

<!-- メイン（ここから） -->
<h2>ホーム</h2>
<p>結婚式を希望される方や考えている方に最適なサイトです。</p>
<ul>
<h3>本サイト機能</h3>
<li>各式場の好きなウェディングプランナーとマッチング</li>
<li>結婚式での金額をシミュレーションで見積もれる</li>
<li>プランナーとのチャット機能でいつでも質問できる</li>
</ul>
<!-- メイン（ここまで） -->


<!-- フッター（ここから） -->
<div id="footer">
<li><a href="/A3/HomeServlet">トップに戻る</a></li>
<li><a href="/A3/ApplyServlet">申し込み</a></li>
<li><a href="/A3/CourseServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
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
