<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <title>顧客選択リスト</title>
    <link rel="stylesheet" href="<c:url value='/css/all.css' />">
    <link rel="stylesheet" href="<c:url value='/css/ChatSelect.css' />">
</head>
<body>
    <ul id="talkList">
        <li class="talkItem">
            <img src="../img/angelina.png" alt="profile 1">
            <div class="talkInfo">
                <span class="talkName">User 1</span>
                <span class="lastMessage">メッセージ1</span>
            </div>
        </li>
        <li class="talkItem">
            <img src="../img/crimson.png" alt="profile 2">
            <div class="talkInfo">
                <span class="talkName">User 2</span>
                <span class="lastMessage">メッセージ2</span>
            </div>
        </li>
        <li class="talkItem">
            <img src="../img/ema.png" alt="profile 3">
            <div class="talkInfo">
                <span class="talkName">User 3</span>
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