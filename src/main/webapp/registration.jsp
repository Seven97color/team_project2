<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客登録</title>
</head>
<body>
	<h1>顧客登録画面</h1>
	<form action="list.jsp" method="get">
		<label for="customerName">氏名</label> <input type="text"
			id="customerName" name="customer_Name" placeholder="山田太郎" required>
		<br> <label for="customerkana">かな</label> <input type="text"
			id="customerkana" name="customer_kana" placeholder="やまだたろう" required>
		<br> <label for="zipcode">郵便番号</label> <input type="text"
			id="zipcode" name="zipcode" maxlength="7" pattern="\d{7}"
			placeholder="8120037" required> <br>
		<lavel for="area">地区</lavel>
		<select id="area" name="area" required>
			<option value="">未設定</option>
			<option value="東北">東北</option>
			<option value="関東">関東</option>
			<option value="関西">関西</option>
			<option value="九州">九州</option>
		</select> <br>
		<lavel>性別</lavel>
		<input type="radio" id="male" name="gender" value="男性" required>
		<label for="male">男</label> <input type="radio" id="female"
			name="gender" value="女性">
		<lavel for="female">女</lavel>
		<br>
		<lavel for="birthday">生年月日</lavel>
		<input type="text" id="birthday" name="birthday"
			placeholder="19910105" required> <br> <label for="tel">電話番号</label>
		<input type="tel" id="tel" name="tel" pattern="[\d\-]{10,13}"
			maxlength="13" placeholder="09011112222" required> <br>
		<button type="submit">顧客登録確定</button>
		<button type="reset">クリア</button>
	</form>
	<br>
	<form action="menu.jsp" method="get">
		<button type="submit">メニュー画面へ</button>
	</form>
</body>
</html>