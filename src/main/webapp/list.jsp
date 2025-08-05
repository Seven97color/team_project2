<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧</title>
</head>
<body>
	<h2>顧客一覧</h2>

	<c:if test="${not empty errorMsg}">
		<p style="color: black;">${errorMsg}</p>
	</c:if>

	<table border="1">
		<tr>
			<th>氏名</th>
			<th>郵便番号</th>
			<th>地区</th>
			<th>性別</th>
			<th>生年月日</th>
			<th>電話番号</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td>${customer.customer_name}</td>
				<td>${customer.post_code}</td>
				<td>${customer.area_code}</td>
				<td>${customer.gender}</td>
				<td>${customer.birthday}</td>
				<td>${customer.phone_number}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="menu.jsp" method="get">
		<br>
		<button type="submit">メニュー画面へ</button>
	</form>
</body>
</html>
