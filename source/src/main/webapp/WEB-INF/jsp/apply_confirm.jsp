<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF8");
String option = request.getParameter("option");
String sikijo = request.getParameter("sikijo");
String planner = request.getParameter("planner");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main>
</main>
<h2 id="regist">申し込み</h2>
 	<form method="POST" action="/A3/ApplyServlet"
			id="apply_confirm_form">
	
    <div>
        <details name="a_course">
            <summary><input type="radio" name="course" value="Jpn">Aコース</summary>
            <p>
                和装レンタル、和風装飾など、<br>
                日本の文化や伝統、和の要素を取り入れた結婚式のスタイル
            </p>
            <p>
                オプション<br>
                <label><input type="checkbox" name="option" value="tuna">
                  ①マグロ入刀
                </label><br>
                <label><input type="checkbox" name="option" value="osake">
                  ②鏡抜き
                </label><br>
                <label><input type="checkbox" name="option" value="omochi">
                  ③鏡開き
                </label><br>
            </p>
            <form name="hall" id="radio_id">
	            <div class="radio_container1">
                    <label>式場</label>
                    <div>
                        <label><input type="radio" name="sikijo" id="radio_change" value="0" onClick="rdo(this);">
                        トム・クルージョン</label>
                    </div>
                    <div class="radio_inner">
                        <span name="0" id="0" style="display:none;">プランナー<br>
                            <label><input type="radio" name="planner" value="katasa">
                            ①麺乃　片佐</label><br>
                            <label><input type="radio" name="planner" value="raoome">
                            ②阿武　羅多芽</label><br>
                            <label><input type="radio" name="planner" value="koime">
                            ③安治　鯉女</label><br>
                            <label><input type="radio" name="planner" value="no">
                            ④選択しない</label><br>
                            <br>
                        </span>
                    </div>
                </div>
                <div class="radio_container2">
                    <div>
                        <label><input type="radio" name="sikijo" id="radio_change" value="1" onClick="rdo(this);">
                        D4C館</label>
                    </div>
                    <div class="radio_inner">
                        <span name="1" id="1" style="display:none;">ラジオ2をオンにした時の中身</span>
                    </div>
                </div>
	            <div class="radio_container2">
                    <div>
                        <label><input type="radio" name="sikijo" id="radio_change" value="2" onClick="rdo(this);">
                        ドウェイン・ブラザー</label>
                    </div>
                    <div class="radio_inner">
                        <span name="2" id="2" style="display:none;">
                        ラジオ3をオンにした時の中身</span>
                    </div>
                </div>
                <div class="radio_container3">
                    <div>
                        <label><input type="radio" name="sikijo" id="radio_change" value="3" onClick="rdo(this);">
                        エマ・ワトシン</label>
                    </div>
                    <div class="radio_inner">
                        <span name="3" id="3" style="display:none;">ラジオ3をオンにした時の中身</span>
                    </div>
	            </div>
	            <p></p>
            </form>
        </details>

        <details name="b_course">
            <summary><input type="radio" name="course" value="West">
            Bコース</summary>
            <p>
                オプション<br>
            </p>
        </details>
        <details name="c_course">
            <summary><input type="radio" name="course" value="JpnWest">
            Cコース</summary>
            <p>
                オプション<br>
            </p>
        </details>
    </div>

	<p><input type="submit" id="search" name="submit" value="申し込む"></p>

	 </form>

</body>
</html>