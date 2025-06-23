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
    <ul id="talkList">
        <li class="talkItem">
            <img src="${ pageContext.request.contextPath}/img/human1.png" alt="profile 1">
            <div class="talkInfo">
                <span class="talkName">小尾利 爪溜</span>
                <span class="lastMessage">メッセージ1</span>
            </div>
        </li>
        <li class="talkItem">
            <img src="${ pageContext.request.contextPath}/img/human2.png" alt="profile 2">
            <div class="talkInfo">
                <span class="talkName">綿名 画目</span>
                <span class="lastMessage">メッセージ2</span>
            </div>
        </li>
        <li class="talkItem">
            <img src="${ pageContext.request.contextPath}/img/human3.png" alt="profile 3">
            <div class="talkInfo">
                <span class="talkName">亜夢 彪夢</span>
                <span class="lastMessage">メッセージ3</span>
            </div>
        </li>
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