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
<!-- <link rel="stylesheet" href="css/all.css"> 
<link rel="stylesheet" href="css/simu.css">  -->
</head>
<body>
<!-- ヘッダーここkら -->
<img src = "img/gouka.png" class="logomain">
<p class="username">
ようこそ<c:out value ="${user.fName}"></c:out><c:out value ="${user.lName}"></c:out>さん
</p>
<ul id="nov" class="hed">
<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
<c:url var="chatUrl" value="/SoServlet">
  <c:param name="one" value="${sessionScope.user.userId}" />
  <c:param name="two" value="${sessionScope.applyPlanner.plannerId}" />
 <%--  <c:param name="p_name" value="${sessionScope.applyPlanner.pName}" /> --%>
</c:url>
</ul>
<!-- ヘッダーここまで -->
<!-- メインここから -->
<div class="hero">
<h2 class="herosimu">シミュレーション</h2>
</div>
<form method="POST" id="simu" action=<c:url value='/SimuServlet' />>
  
<!-- Aコース -->

<label for="course" id=sentaku>コース・式場・オプションを選択</label>
<div class="tab">
<details>
	<summary>
	  <input type="radio" name="course"  value="1800000">Aコース<br>
	  <a>和装レンタル、和風装花など、<br>日本の文化や伝統や、和の要素を<br>取り入れた和婚式スタイル</a>
	</summary>
		<table class="course">
			<tr>
				<td>
				<br>
				  <label>オプション選択</label>
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
				<br>
				  <label>式場選択</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="radio" name="sikijo" value="550000">トム・クルージョン<br>
					<img src="${ pageContext.request.contextPath}/images/siki_tom.png" width="300" height="200" alt="トム・クルージョン">
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="120000">D4C館<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_D4c.png" width="300" height="200" alt="D4C館">
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="520000">ドウェイン・ブラザー<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_dwein.png" width="300" height="200" alt="ドウェイン・ブラザー">
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="290000">エマ・ワトシン<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_ema.png" width="300" height="200" alt="エマ・ワトシン">
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
	  <a>白を基調とした厳かな挙式<br>バージンロードの入場、会場など<br>ロマンチックな雰囲気</a>
	</summary>
		<table class="course">
			<tr>
				<td>
				  <br>
				  <label>オプション選択</label>
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
				  <br>
				  <label>式場選択</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="radio" name="sikijo" value="480000">アンジェリーナ・ジョリーン<br>
					<img src="${ pageContext.request.contextPath}/images/siki_angelina.png" width="300" height="200" alt="アンジェリーナ・ジョリーン">
					</label>
				</td>
			</tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="550000">トム・クルージョン<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_tom.png" width="300" height="200" alt="トム・クルージョン">
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="380000">クリムゾン・ドッピオ<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_crimson.png" width="300" height="200" alt="クリムゾン・ドッピオ">
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="520000">ドウェイン・ブラザー<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_dwein.png" width="300" height="200" alt="ドウェイン・ブラザー">
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="410000">テイラー２２<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_taylor.jpeg" width="300" height="200" alt="テイラー２２">
					  </label>
				  </td>
			  </tr>
			  <tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="290000">エマ・ワトシン<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_ema.png" width="300" height="200" alt="エマ・ワトシン">
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
	  <a>和の伝統美と洋の華やかさが調和<br>どちらも楽しめる<br>和洋折衷ウェディング</a>
	</summary>
		<table class="course">
			<tr>
				<td>
				  <br>
				  <label>オプション選択</label>
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
				  <br>
				  <label>式場選択</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>
					<input type="radio" name="sikijo" value="550000">トム・クルージョン<br>
					<img src="${ pageContext.request.contextPath}/images/siki_tom.png" width="300" height="200" alt="トム・クルージョン">
					</label>
				</td>
			</tr>
			<tr>
				  <td>
					  <label>
					  <input type="radio" name="sikijo" value="520000">ドウェイン・ブラザー<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_dwein.png" width="300" height="200" alt="ドウェイン・ブラザー">
					  </label>
				  </td>
			</tr>
			<tr>
				<td>
					  <label>
					  <input type="radio" name="sikijo" value="290000">エマ・ワトシン<br>
					  <img src="${ pageContext.request.contextPath}/images/siki_ema.png" width="300" height="200" alt="エマ・ワトシン">
					  </label>
				  </td>
			</tr>
		  </table>
</details>
<!-- Cコース -->
<br>
<input type="button" onclick="return calc()" value="計算する">
	<br>
合計<output name="price" id="pr"></output>円
</div>
<!-- <button onclick="calculate()">計算</button>
<div id="result"></div> -->

<!-- ふっだーここから -->
<div class="footer">
<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
  
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
	  price.value = total.toLocaleString();
	}

</script>

</body>
</html>