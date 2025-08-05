<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客登録</title>
</head>
<body>
	<header class="header">
		<form action="logout" method="post" class="header__logout-form">
			<input type="submit" value="ログアウト" class="header__logout-btn">
		</form>
	</header>

	<h1>顧客登録画面</h1>
	<form action="/CustomerManager_kimura/RegisterServlet" method="post">

		<!-- 1. customer_idの入力追加 -->
		<label for="customer_id">ユーザID</label> <input type="text"
			id="customer_id" name="customer_id" placeholder="1" required>
		<br> <label for="customer_name">氏名</label> <input type="text"
			id="customer_name" name="customer_name" placeholder="山田太郎" required>
		<br> <label for="post_code">郵便番号</label> <input type="text"
			id="post_code" name="post_code" maxlength="7" pattern="\d{7}"
			placeholder="8120037" required> <br> <label for="area_code">地区</label>
		<select id="area_code" name="area_code" required>
			<option value="">未設定</option>
			<option value="東北">東北</option>
			<option value="関東">関東</option>
			<option value="東海">東海</option>
			<option value="関西">関西</option>
			<option value="九州">九州</option>
		</select> <br> <label>性別</label> <input type="radio" id="male"
			name="gender" value="男性" required> <label for="male">男</label>
		<input type="radio" id="female" name="gender" value="女性"> <label
			for="female">女</label> <br> <label for="birthday">生年月日</label> <input
			type="text" id="birthday" name="birthday" placeholder="19910105"
			required> <br> <label for="phone_number">電話番号</label> <input
			type="tel" id="phone_number" name="phone_number"
			pattern="[\d\-]{10,13}" maxlength="13" placeholder="09011112222"
			required> <br>

		<button type="submit">顧客登録確定</button>
		<button type="reset">クリア</button>
	</form>

	<br>

	<form action="menu.jsp" method="get">
		<button type="submit">メニュー画面へ</button>
	</form>

</body>
</html>
