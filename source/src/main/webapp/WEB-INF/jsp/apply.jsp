<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>申し込み</title>
	<link rel="stylesheet" href="css/all.css">
	<link rel="stylesheet" href="css/Apply.css">
</head>

<body>
	<header>
<!-- 		<h1>aaaaaaaaaa</h1>-->
		<ul id="nav">
			<li><a href="/webapp/HomeServlet">ホーム</a></li>
			<li><a href="/webapp/ApplyServlet">申し込み</a></li>
			<li><a href="/webapp/CourseServlet">式場/コース/プランナー 一覧</a></li>
			<li><a href="/webapp/SimuServlet">シミュレーション機能</a></li>
			<li><a href="/webapp/〇〇Servlet">チャット(Q＆A)</a></li>
			<li><a href="/webapp/UmypServlet">マイページ</a></li>
		</ul>
	</header>
	
<main>
	<div class="hero">
		<h2>申し込み</h2>
 	</div>
 	<form method="POST" action="/A3/ApplyConfirmServlet">
 	    <input type="radio" name="course" value="Acourse" onchange="showDiv('Acourse')">Aコース<br>
		<div id="divA" style="display:none;">
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
	                <!-- hidden=次から選択できない -->
	                <option value=""  hidden>選択してください</option>
	                <option name="sikijo" value="select1">トム</option>
	                <option name="sikijo" value="select2">D</option>
	                <option name="sikijo" value="select3">ブラザー</option>
	                <option name="sikijo" value="select4">エマ</option>
	            </select>
	        </div>
        
	        <div class="col-auto my-5">
	            <!-- style="display:none;で初期表示で表示しない -->
	            <!-- トムを選んだら表示されるもの -->
	            <div id="Box1" class="my-5" style="display:none;">
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="himeno">
	                    ①姫野　麗</label><br>
	                    <label><input type="radio" name="planner" value="reo">
	                    ②平野　玲央</label><br>
	                    <label><input type="radio" name="planner" value="satiko">
	                    ③幸沢　幸子</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>
	                </p>
	            </div>
	
	            <!-- d4cを選んだら表示されるもの -->
	            <div id="Box2" class="my-5" style="display:none;">  
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="abu">
	                    ①阿武　羅多芽</label><br>
	                    <label><input type="radio" name="planner" value="koime">
	                    ②安治　鯉女</label><br>
	                    <label><input type="radio" name="planner" value="sakura">
	                    ③スプリング　サクラ</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>                    
	                </p>
	            </div>
	
	            <!-- ブラザーを選んだら表示されるもの -->
	            <div id="Box3" class="my-5" style="display:none;">  
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="rasen">
	                    ①渦巻　螺旋</label><br>
	                    <label><input type="radio" name="planner" value="hijiki">
	                    ②磯野　ひじき</label><br>
	                    <label><input type="radio" name="planner" value="ajino">
	                    ③味之　幹雄</label><br>
	                    <label><input type="radio" name="planner" value="no">
	                    ④選択しない</label><br>                    
	                </p>
	            </div>
	
	            <!-- エマを選んだら表示されるもの -->
	            <div id="Box4" class="my-5" style="display:none;">
	                <p>
	                    プランナー<br>
	                    <label><input type="radio" name="planner" value="shigoro">
	                    ①佐藤　四五六</label><br>
	                    <label><input type="radio" name="planner" value="sum">
	                    ②ステイSUM</label><br>
	                    <label><input type="radio" name="planner" value="tyamu">
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
	   	<br>
	   	
	    <input type="radio" name="course" value="Bcourse" onchange="showDiv('Bcourse')">Bコース<br>
	    <div id="divB" style="display:none;">
	     	Bが選択された時に表示される要素
	   	</div>
	   	<br>
	   	
	    <input type="radio" name="course" value="Ccourse" onchange="showDiv('Ccourse')">Cコース<br>
	   	<div id="divC" style="display:none;">
	     	Cが選択された時に表示される要素
	   	</div>

        <p><input type="submit" id="search" name="submit" value="申し込む"></p>	
 		
 		
 		
 	</form>
</main>
<footer>

</footer>

<script>
//コース選択で表示
function showDiv(value) {
    const A = document.getElementById('divA');
    const B = document.getElementById('divB');
    const C = document.getElementById('divC');

    A.style.display = 'none';
    B.style.display = 'none';
    C.style.display = 'none';

    if (value === 'Acourse') {
      A.style.display = 'block';
    } else if (value === 'Bcourse') {
      B.style.display = 'block';
    } else if (value === 'Ccourse') {
      C.style.display = 'block';
    }
}

function viewChange(){
    if(document.getElementById('hall')){
        id = document.getElementById('hall').value;
        // Aコース(select1)を選択したら、id=box1のスタイルをdisplay: ;にし、
        // id="Box2"とid="Box3"の要素にはdisplay:none;を適用する。
        if(id == 'select1'){
            document.getElementById('Box1').style.display = "";
            document.getElementById('Box2').style.display = "none";
            document.getElementById('Box3').style.display = "none";
            document.getElementById('Box4').style.display = "none";
        }else if(id == 'select2'){
            document.getElementById('Box1').style.display = "none";
            document.getElementById('Box2').style.display = "";
            document.getElementById('Box3').style.display = "none";
            document.getElementById('Box4').style.display = "none";
        }else if(id == 'select3'){
            document.getElementById('Box1').style.display = "none";
            document.getElementById('Box2').style.display = "none";
            document.getElementById('Box3').style.display = "";
            document.getElementById('Box4').style.display = "none";
        }else if(id == 'select4'){
            document.getElementById('Box1').style.display = "none";
            document.getElementById('Box2').style.display = "none";
            document.getElementById('Box3').style.display = "none";
            document.getElementById('Box4').style.display = "";
        }
    }
    window.onload = viewChange;
}



</script>
</body>
</html>