<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/all.css' />">
<link rel="stylesheet" href="<c:url value='/css/pwelcome.css' />">
</head>
<body>
<ul id="nav">
<li><a href="<c:url value='/PWelcomeServlet' />">ホーム</a></li>
<li><a href="<c:url value='/CDataServlet' />">顧客情報</a></li>
<li><a href="<c:url value='/ChatSelectServlet' />">チャット(Q＆A)</a></li>
<li><a href="<c:url value='/PMypServlet' />">マイページ</a></li>
<li><a href="<c:url value='/PLoginServlet' />">ログアウト</a></li>
</ul>

<div class="header-area">
	<div class="name-box">
		<P>ようこそ</P>
		<c:out value="${planner.pName}"/>
		<P>さん</P>
	</div>

  	<div class="calendar-container">
    	<div class="calendar-controls">
      		<select id="year-select"></select>
      		<select id="month-select"></select>
    	</div>
    
   
	<table id="calendar">
    	<thead>
      		<tr>
        		<th>日</th>
        		<th>月</th>
        		<th>火</th>
        		<th>水</th>
        		<th>木</th>
        		<th>金</th>
        		<th>土</th>
      		</tr>
    	</thead>
   			 <tbody id="calendar-body">
      			<!-- JSでここに日付を描画 -->
   			 </tbody>
 		 </table>
  </div>
</div>
<script>
  const now = new Date();

  document.addEventListener("DOMContentLoaded", function () {
    const yearSelect = document.getElementById("year-select");
    const monthSelect = document.getElementById("month-select");

    function populateSelectors() {
      const currentYear = now.getFullYear();

      // 年のプルダウン
      for (let y = 2000; y <= 2030; y++) {
        const option = document.createElement("option");
        option.value = y;
        option.textContent = y;
        if (y === currentYear) option.selected = true;
        yearSelect.appendChild(option);
      }

      // 月のプルダウン
      const monthNames = [
  "1月", "2月", "3月", "4月", "5月", "6月",
  "7月", "8月", "9月", "10月", "11月", "12月"
];
      for (let m = 0; m < 12; m++) {
        const option = document.createElement("option");
        option.value = m;
        option.textContent = monthNames[m];
        if (m === now.getMonth()) option.selected = true;
        monthSelect.appendChild(option);
      }
    }

    function generateCalendar(year, month) {
      const tbody = document.getElementById("calendar-body");
      tbody.innerHTML = "";

      const firstDay = new Date(year, month, 1);
      const lastDate = new Date(year, month + 1, 0).getDate();
      const startDay = firstDay.getDay();

      let date = 1;
      for (let i = 0; i < 6; i++) {
        const row = document.createElement("tr");

        for (let j = 0; j < 7; j++) {
          const cell = document.createElement("td");

          if (i === 0 && j < startDay) {
            cell.textContent = "";
          } else if (date > lastDate) {
            cell.textContent = "";
          } else {
            cell.textContent = date;

            // 今日の日付なら強調
            if (
              date === now.getDate() &&
              year === now.getFullYear() &&
              month === now.getMonth()
            ) {
              cell.style.backgroundColor = "#ffe0b3";
              cell.style.fontWeight = "bold";
            }

            date++;
          }

          row.appendChild(cell);
        }

        tbody.appendChild(row);
      }
    }

    populateSelectors();

    generateCalendar(parseInt(yearSelect.value), parseInt(monthSelect.value));

    yearSelect.addEventListener("change", () => {
      generateCalendar(parseInt(yearSelect.value), parseInt(monthSelect.value));
    });

    monthSelect.addEventListener("change", () => {
      generateCalendar(parseInt(yearSelect.value), parseInt(monthSelect.value));
    });
  });
</script>
</body>
</html>