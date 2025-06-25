<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <title>顧客選択リスト</title>
    <link rel="stylesheet" href="<c:url value='/css/all.css' />">
    <link rel="stylesheet" href="<c:url value='/css/chatselect.css' />">
</head>
<body>
<img src = "img/gouka.png" class="logomain">
	<ul id="nav">
	<li><a href="<c:url value='/PWelcomeServlet' />">ホーム</a></li>
	<li><a href="<c:url value='/CDataServlet' />">顧客情報</a></li>
	<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
	<li><a href="<c:url value='/PMypServlet' />">マイページ</a></li>
	<li><a href="<c:url value='/PLogoutServlet' />">ログアウト</a></li>
	</ul>
    <ul id="talkList">
	    <c:forEach var="e" items="${userList}">
	        <li class="talkItem">
	            <img src="${ pageContext.request.contextPath}/img/human1.png" alt="profile 1">
	            <div class="talkInfo">
	           
	                <span class="talkName">${e.fName}様</span>
	            
	                
	            </div>
	            <form action ="<c:url value='/SoServlet'/>" method="GET">
	            	<input type="hidden" name="user_name" value="${e.fName}${e.lName} 様">
	            	<input type="hidden" name="two" value="${e.userId }">
	            	<input type="hidden" name="one" value="${planner.plannerId }">
	            	<input type="hidden" name="planner_name" value="${planner.pName }">
	            	<input type="hidden" name="one" value="${planner.plannerId  }">
	            	<input type="hidden" name="two" value="${e.userId }">
	           		<input type="submit" name="sub" value="チャットを開始する">
	            </form>
	            
	         <%--     <form action ="<c:url value='/SoServlet'/>" method="POST">
	            	<input type="hidden" name="planner_name" value="${planner.pName }">
	            	<input type="hidden" name="two" value="${planner.plannerId }">
	            	<input type="hidden" name="one" value="${e.userId }">
	            	<input type="hidden" name="user_name" value="${e.fName}${e.lName}">
	            	<input type="hidden" name="one" value="${e.userId }">
	            	<input type="hidden" name="two" value="${planner.plannerId  }">
	           		<input type="submit" name="sub" value="チャットを開始する">
	            </form> --%>
	            
	            <%-- chat.jspにこんな感じで書くよ
	             var user_id_speaker = ${param.one}; 
	    		 var user_id_listener = ${param.two};  --%>
	        </li>
	     </c:forEach>
        
    </ul>
<script src="script.js"></script>
 
</body>
<script>
	const talkItems = document.querySelectorAll('.talkItem');

	talkItems.forEach(item => {
    item.addEventListener('click', () => {
        // 全ての選択状態を解除
        talkItems.forEach(item => item.classList.remove('selected'));
        // クリックされた要素に選択状態を追加
        item.classList.add('selected');
    });
});
</script>
</html>