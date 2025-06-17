<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="hero">
<h2 class="herosimu">シミュレーション</h2>
</div>
<form method="POST" id="simu" action="/A3/SimuServlet">
  <label for="course">コースを選択</label>
<!-- Aコース -->
<div class="tab">
<details>
	<summary>
	  <input type="radio" name="course" value="350000">Aコース<br>
	</summary>
		<table>
			<tr>
				<td>
				  <p>オプション選択</p>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="checkbox" name="option" value="1300000">魚入刀（本マグロ５０キロ）<br>
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

		  <table>
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
<!-- Bコース -->
<details>
	<summary>
	  <input type="radio" name="course" value="1810000">Bコース<br>
	</summary>
		<table>
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

		  <table>
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
<!-- Cコース -->
<details>
	<summary>
	  <input type="radio" name="course" value="">Cコース<br>
	</summary>
		<table>
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
					  <input type="checkbox" name="option" value="60000">寿司ケーキあーん<br>
					  </label>
				  </td>
			  </tr>
		  </table>

		  <table>
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
<input type="button" onclick="price.value=Math.round(Number(option.value)+Number(sikijo.value));" value="計算する"><br>
合計<output name="price"></output> 円
</div>
<!-- <button onclick="calculate()">計算</button>
<div id="result"></div> -->

<!-- ふっだーここから -->
<div id="footer">
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
<!-- ふっだーここまで -->
</form>


</body>
</html>