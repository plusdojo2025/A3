<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申し込み確認</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
<main>
</main>
<h2 id="regist">申し込み確認</h2>
 	<form method="POST" action="/A3/ApplyServlet"
			id="apply_confirm_form">
	
	<p>
	${param.course}
	<input type="radio" name="course" value="<%=request.getAttribute("course") %>">Aコース<br>
	<input type="radio" name="course" value="<%=request.getAttribute("course") %>">Bコース<br>
	<input type="radio" name="course" value="<%=request.getAttribute("course") %>">Cコース<br>
	</p>
	<p>
	オプション<br>
	<label><input type="checkbox" name="option" value="tuna">①マグロ入刀</label><br>
	<label><input type="checkbox" name="option" value="osake">②鏡抜き</label><br>
	<label><input type="checkbox" name="option" value="omochi">③鏡開き</label><br>      
	</p>
	<p>
	式場<input type="checkbox" name="sikijo" value="<%=request.getAttribute("sikijo") %>">
	</p>
	<p>
	プランナー<input type="checkbox" name="planner" value="<%=request.getAttribute("planner") %>">
	</p>
	
	
<!-- 	<div id="divA" style="display:none;">
		    <details>
	            <summary>オプション</summary>
	            <label><input type="checkbox" name="option" value="tuna">①マグロ入刀</label><br>
	            <label><input type="checkbox" name="option" value="osake">②鏡抜き</label><br>
	            <label><input type="checkbox" name="option" value="omochi">③鏡開き</label><br>      
	        </details>
	        <br>

	        <div class="col-auto my-1">
	            <label for="hall">希望式場</label><br>
	            <select class="form-control" id="hall" onchange="viewChange();">
	                hidden=次から選択できない
	                <option value=""  hidden>選択してください</option>
	                <option name="sikijo" value="select1">トム</option>
	                <option name="sikijo" value="select2">D</option>
	                <option name="sikijo" value="select3">ブラザー</option>
	                <option name="sikijo" value="select4">エマ</option>
	            </select>
	        </div>
        
	        <div class="col-auto my-5">
	            style="display:none;で初期表示で表示しない
	            トムを選んだら表示されるもの
	            <div id="Box1" class="my-5" style="display:none;">
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="katasa">
	                    ①姫野　麗</label><br>
	                    <label><input type="radio" name="planner" value="raoome">
	                    ②平野　玲央</label><br>
	                    <label><input type="radio" name="planner" value="koime">
	                    ③幸沢　幸子</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>
	                </p>
	            </div>
	
	            d4cを選んだら表示されるもの
	            <div id="Box2" class="my-5" style="display:none;">  
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="katasa">
	                    ①阿武　羅多芽</label><br>
	                    <label><input type="radio" name="planner" value="raoome">
	                    ②安治　鯉女</label><br>
	                    <label><input type="radio" name="planner" value="koime">
	                    ③スプリング　サクラ</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>                    
	                </p>
	            </div>
	
	            ブラザーを選んだら表示されるもの
	            <div id="Box3" class="my-5" style="display:none;">  
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="katasa">
	                    ①渦巻　螺旋</label><br>
	                    <label><input type="radio" name="planner" value="raoome">
	                    ②磯野　ひじき</label><br>
	                    <label><input type="radio" name="planner" value="koime">
	                    ③味之　幹雄</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>                    
	                </p>
	            </div>
	
	            エマを選んだら表示されるもの
	            <div id="Box4" class="my-5" style="display:none;">
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="katasa">
	                    ①佐藤　四五六</label><br>
	                    <label><input type="radio" name="planner" value="raoome">
	                    ②ステイSUM</label><br>
	                    <label><input type="radio" name="planner" value="koime">
	                    ③ステイチャム</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>
	                </p>
	            </div>
	        </div>
	   
        	<div id="Box2" class="my-5" style="display:none;">  
                <p>Bコース</p>
            </div>
            <div id="Box3" class="my-5" style="display:none;">  
                <p>Cコース</p>
            </div>
		</div>
	   	<br> -->
	
 

	<p><input type="submit" id="search" name="submit" value="申し込む"></p>

	 </form>

</body>
</html>