<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧</title>
</head>
<body>
	<h2>顧客一覧</h2>
	<form method="get" action="ListServlet">
		<input type="text" id="searchName" name="searchName">
		<button type="submit">検索</button>
	</form>

	<%-- 検索結果が0件の場合のメッセージ --%>
	<%
	if (request.getAttribute("customers") != null && ((List<?>) request.getAttribute("customers")).isEmpty()
			&& request.getParameter("searchName") != null) {
	%>
	<p style="color: black;">検索結果はありません</p>
	<%
	}
	%>

	<table border="1">
		<tr>
			<th>氏名</th>
			<th>かな</th>
			<th>郵便番号</th>
			<th>地区</th>
			<th>性別</th>
			<th>生年月日</th>
			<th>電話番号</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td>${customer.name}</td>
				<td>${customer.kana}</td>
				<td>${customer.zipcode}</td>
				<td>${customer.area}</td>
				<td>${customer.gender}</td>
				<td>${customer.birthday}</td>
				<td>${customer.tel}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="menu.jsp" method="get">
		<br>
		<button type="submit">メニュー画面へ</button>
	</form>
</body>
</html>
