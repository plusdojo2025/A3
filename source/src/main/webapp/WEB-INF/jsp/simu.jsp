<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結婚しなサイト｜シミュレーション</title>
<link rel="stylesheet" href="css/all.css"> 
<link rel="stylesheet" href="css/Simu.css"> 
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
<h2 class="hero simu">シミュレーション</h2>
<form method="POST" action="/A3/SimuServlet">
  <label for="course">コースを選択してください</label>
  <select id="course" name="course">
    <option value="courseA">Aコース</option>
    <option value="courseB">Bコース</option>
    <option value="courseC">Cコース</option>
  </select>
</form>
</body>
</html>