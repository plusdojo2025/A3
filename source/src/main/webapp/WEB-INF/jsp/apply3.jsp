<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み</title>
	<link rel="stylesheet" href="<c:url value='/css/all.css' />">
	<link rel="stylesheet" href="<c:url value='/css/Apply.css' />">
</head>

<body>
<img src = "img/gouka.png" class="logomain">
<p class="username">
ようこそ<c:out value ="${user.fName}"></c:out><c:out value ="${user.lName}"></c:out>さん
</p>
	<header>
		<ul id="nov">
			<li><a href="<c:url value='/HomeServlet' />">ホーム</a></li>
			<li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li>
			<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
			<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
			<%-- <li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li> --%>
			<li><c:url var="chatUrl" value="/SoServlet">チャット(Q＆A)
				  <c:param name="one" value="${sessionScope.user.userId}" />
				  <c:param name="two" value="${sessionScope.applyPlanner.plannerId}" />
				 <%--  <c:param name="p_name" value="${sessionScope.applyPlanner.pName}" /> --%>
				</c:url></li>
			<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>式場・オプション選択</h2>
 	</div>
<form method="POST" action="<c:url value='/ApplyConfirmServlet' />">
 	<c:if test="${not empty errorMsg }">
 		<p>${errorMsg }
 	</c:if>	
 	<div class="sikijo">
	 	<c:forEach var="e" items="${sikijoList}">
	 		<div class="sikijo_card">
		 		<div class="left">		
					<input type="radio" name="sikijo" value="${e.sikijoId }" onchange="showPlanner(${e.sikijoId})" required>
					${e.sName}:${e.sPrice }円
					<p>${e.sAddress}</p>
					
									
					<div id="plist${e.sikijoId}" class="plist">
						<p>プランナー</p>
						<c:forEach var="p" items="${e.plannerList}">
						<div class="pname">
							<input type="radio" name="planner" value="${p.plannerId}" disabled required>
							 ${p.plannerName}（${p.gender}）<br>
						</div>
						</c:forEach>
					</div>
				</div> <!-- left -->
				<div class="card_img">			
					<c:if test="${not empty e.sImage}">
					<img src="${pageContext.request.contextPath}/images/${e.sImage}" alt="式場画像" width="350">
					</c:if><br>			
				</div>			
			</div><!-- sikjo_card -->			
		</c:forEach>	
	</div> <!-- sikijo_card --> 
	<div class="option_card">
		<label class="option">オプション</label><br>
		<div class="op">
			<c:forEach var="e" items="${optionList}">
				<div class="option_list">
					<input type="checkbox" name="option" value="${e.optionId }"><%-- ${e.optionId }, --%>
					${e.optionName }:
					${e.optionPrice }円
					
				</div>
			</c:forEach>
		</div>
	</div><!-- option_card -->
	<br>
	<div class="aaa">
	    <label>備考<br>
		<textarea class="remarks" name="remarks" rows=4 cols=40></textarea><br></label>
	    <p><input type="submit" name="submit" value="申し込み確認へ"></p> 		
	</div>
</form>
	<div class="return">
	<button type="submit" name="return" value="戻る" onclick="history.back();">コース選択へ戻る</button>
	</div>
</main>
<footer>
<div class="footer">
	<ul>
		<li><a href="<c:url value='/HomeServlet' />">トップに戻る</a></li>
		<%-- <li><a href="<c:url value='/ApplyCourseServlet' />">申し込み</a></li> --%>
		<li><a href="<c:url value='/CourseServlet' />">式場/コース/プランナー 一覧</a></li>
		<li><a href="<c:url value='/SimuServlet' />">シミュレーション機能</a></li>
		<li><a href="<c:url value='/SoServlet' />">チャット(Q＆A)</a></li>
		<li><a href="<c:url value='/UMypServlet' />">マイページ</a></li>
	</ul>
   <p>&copy;Copyright plusDOJO(SE plus). All rights reserved.</p>
</div>
</footer>

<script>
function showPlanner(sikijoId) {
    // まず全部のブロックを非表示
    let blocks = document.querySelectorAll('.plist');
    blocks.forEach(function(block) {
        block.style.display = 'none';
        let radios = block.querySelectorAll('input[type="radio"]');
        radios.forEach(r => r.disabled = true); // ラジオボタン無効化
    });

    // 選ばれた式場のプランナーだけ表示
    let selected = document.getElementById('plist' + sikijoId);
    if (selected) {
        selected.style.display = 'block';
        let radios = selected.querySelectorAll('input[type="radio"]');
        radios.forEach(r => r.disabled = false); // 選ばれた式場のラジオボタンを有効化
    }
}

</script>
</body>
</html>