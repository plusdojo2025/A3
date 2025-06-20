<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結婚しなサイト｜シミュレーション</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/simu.css' />">
<link rel="stylesheet" href="css/all.css"> 
<link rel="stylesheet" href="css/simu.css"> 
</head>
<body>
<!-- ヘッダーここkら -->
<c:out value ="${user.lName}"/>
<ul id="nav">
<li><a href="/A3/HomeServlet">ホーム</a></li>
<li><a href="/A3/ApplyCourseServlet">申し込み</a></li>
<li><a href="/A3/SikijoServlet">式場/コース/プランナー 一覧</a></li>
<li><a href="/A3/SimuServlet">シミュレーション機能</a></li>
<li><a href="/A3/OOServlet">チャット(Q＆A)</a></li>
<li><a href="/A3/UMypServlet">マイページ</a></li>
<li><a href="/A3/LoginServlet">ログアウト</a></li>
</ul>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<div class="hero">
<h2 class="herosimu">シミュレーション</h2>
</div>
<form method="POST" id="simu" action="/A3/SimuServlet">
  
<!-- Aコース -->

<label for="course" id=sentaku>コースを選択</label>
<div class="tab">
<details>
	<summary>
	  <input type="radio" name="course" value="1800000">Aコース<br>
	</summary>
		<table class="course">
			<tr>
				<td>
				  <p>オプション選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="checkbox" name="option" value="1300000">マグロ入刀<br>
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="checkbox" name="option" value="60000">鏡開き<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="checkbox" name="option" value="90000">鏡抜き<br>
					  </label>
				  </td>
			  </tr>
		  </table>

		  <table class="course">
			<tr>
				<td>
				  <p>式場選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="radio" name="sikijo" value="550000">トム・クルージョン<br>
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="120000">D4C館<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="520000">ドウェイン・ブラザー<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="290000">エマ・ワトシン<br>
					  </label>
				  </td>
			  </tr>
		  </table>
</details>
<!-- Aコース -->
<br>
<!-- Bコース -->
<details>
	<summary>
	  <input type="radio" name="course" value="2100000">Bコース<br>
	</summary>
		<table class="course">
			<tr>
				<td>
				  <p>オプション選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="checkbox" name="option" value="200000">シャンパンタワー<br>
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="checkbox" name="option" value="20000">ピニャータ<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="checkbox" name="option" value="70000">巨大ハンバーガ入刀<br>
					  </label>
				  </td>
			  </tr>
		  </table>

		  <table class="course">
			<tr>
				<td>
				  <p>式場選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="radio" name="sikijo" value="480000">アンジェリーナ・ジョリーン<br>
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="550000">トム・クルージョン<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="380000">クリムゾン・ドッピオ<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="520000">ドウェイン・ブラザー<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="410000">テイラー２２<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="290000">エマ・ワトシン<br>
					  </label>
				  </td>
			  </tr>
		  </table>
</details>
<!-- Bコース -->
<br>
<!-- Cコース -->
<details>
	<summary>
	  <input type="radio" name="course" value="2700000">Cコース<br>
	</summary>
		<table class="course">
			<tr>
				<td>
				  <p>オプション選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="checkbox" name="option"  value="250000">打ち上げ花火<br>
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="checkbox" name="option" value="65000">かぼちゃ割り<br>
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="checkbox" name="option" value="60000">寿司ケーキ<br>
					  </label>
				  </td>
			  </tr>
		  </table>

		  <table class="course">
			<tr>
				<td>
				  <p>式場選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="radio" name="sikijo" value="550000">トム・クルージョン<br>
					</label>
				</td>
			</tr>
			<tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="520000">ドウェイン・ブラザー<br>
					  </label>
				  </td>
			</tr>
			<tr>
				<td>
					  <label>
					  <input type="radio" name="sikijo" value="290000">エマ・ワトシン<br>
					  </label>
				  </td>
			</tr>
		  </table>
</details>
<!-- Cコース -->

<input type="button" onclick="return calc()" value="計算する">
	<br>
合計<output name="price" id="pr"></output> 円
</div>
<!-- <button onclick="calculate()">計算</button>
<div id="result"></div> -->

<!-- ふっだーここから -->
<div id="footer">
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
<!-- ふっだーここまで -->
</form>
<script>
function calc() {
	  const checked = document.querySelectorAll('input[name="option"]:checked');
	  const values = Array.from(checked).map(cb => Number(cb.value));
	  /* constは値画変えられないのでansはletで設定 */
	  let ans = 0;
	  for (let i = 0; i < values.length; i++) {
	    ans += values[i];
	  }
	  /* コースと式場がチェックされたら */
	  const course = document.querySelector('input[name="course"]:checked');
	  const sikijo = document.querySelector('input[name="sikijo"]:checked');
	  /* course ? Number(course.value)で文字列になってしまっている値を数字に変える */
	  const courseValue = course ? Number(course.value) : 0;
	  const sikijoValue = sikijo ? Number(sikijo.value) : 0;
	  /* 足し算 */
	  const total = ans + courseValue + sikijoValue;
	  const price = document.getElementById("pr");
	  price.value = total;
	}

</script>

</body>
</html>