<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧</title>
</head>
<body>
	<h2>顧客一覧</h2>
	<form method="get" action="list.jsp">
		<input type="text" id="searchName" name="searchName">
		<button type="submit">検索</button>
	</form>

	<%-- 検索ボタンが押されたか判定（searchNameが空でない場合） --%>
	<% if (request.getParameter("searchName") != null) { %>
	<p style="color: black;">検索結果はありません</p>
	<% } %>
	<form action="menu.jsp" method="get">
		<br>
		<button type="submit">メニュー画面へ</button>
	</form>

</body>
</html>