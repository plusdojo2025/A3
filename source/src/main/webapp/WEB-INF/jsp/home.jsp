<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<li><a href="<c:url value='/◯◯Servlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
</ul>
<!-- ヘッダー（ここまで） -->

<!-- メイン（ここから） -->
<div class="header-list">
	<h2>ホーム</h2>
	<p>結婚式を希望される方や考えている方に最適なサイトです。</p>
</div>

<div class="main-list">
	<ul>
	<h3>本サイト機能</h3>	
	<li>各式場の好きなウェディングプランナーとマッチング</li>
	<li>結婚式での金額をシミュレーションで見積もれる</li>
	<li>プランナーとのチャット機能でいつでも質問できる</li>	
	</ul>
</div>

<div class="slider-container">

  <div class="image-container">
    <img src="${ pageContext.request.contextPath}/img/angelina.png" alt="アンジェリーナ・ジョリーン">
    <img src="${ pageContext.request.contextPath}/img/crimson.png" alt="クリムゾン・ドッピオ">
    <img src="${ pageContext.request.contextPath}/img/dwayne.png" alt="ドウェイン・ブラザー">
    <img src="${ pageContext.request.contextPath}/img/tom.png" alt="トム・クルージョン">
  </div>

  <!-- ナビゲーションコンテナ -->
  <div class="nav-container"></div>

</div>

<!-- メイン（ここまで） -->

<!-- フッター（ここから） -->
<div class="footer">
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

	//すべての画像
	const images = document.querySelectorAll('img');
	// ナビゲーションコンテナ
	const navContainer = document.querySelector('.nav-container');
	//画像の総数
	const totalImages = images.length;
	// 表示する画像を指定するインデックス
	let imageIndex = 0;
	// タイマー
	let interval;

	//新しいボタン要素を作成
	const button = document.createElement('button');
	//新しく作成したボタンにクラスを追加
	button.classList.add('nav-btn');
	//新しく作成したボタンをナビゲーションコンテナに追加
	navContainer.appendChild(button);

	for (let i = 0; i < totalImages; i++) {
	  const button = document.createElement('button');
	  button.classList.add('nav-btn');
	  navContainer.appendChild(button);
	}
	//すべてのボタンをまとめて取得
	const buttons = document.querySelectorAll('.nav-btn');

	buttons.forEach((button,index) => {
	  	button.addEventListener('click',() => {
	    	imageIndex = index;   
	    	// 画像とボタンを更新
	    	updateSlider();
	  	});
	});
	
	function updateSlider() {
	  	images.forEach(image => {
	    	image.classList.remove('image-active');
	  	});
	  	buttons.forEach(button => {
	    	button.classList.remove('btn-active');
	  	});
	  	
	  	// 表示する画像を変数imageIndexで指定しimage-activeクラスを追加
	  	images[imageIndex].classList.add('image-active')
	  	
	  	// 色を変えるボタンを変数imageIndexで指定しbtn-activeクラスを追加
	  	buttons[imageIndex].classList.add('btn-active');
	  	
	}
	
	//次の画像を指定して表示
	function nextImage() {
  		imageIndex++;
  		if (imageIndex > totalImages - 1) {
   			imageIndex = 0;
  		}
  		updateSlider();
	}

// 次の画像へ自動再生
function autoPlay() {
  interval = setInterval(nextImage, 3000);
}

// 自動再生を一旦停止してから再び再生
function resetInterval() {
  clearInterval(interval);
  autoPlay();
}

// スライドショーを開始
updateSlider();
autoPlay();
</script>
</body>
</html>
