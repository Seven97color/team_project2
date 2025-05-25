
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="assets/stylesheets/app.css">
</head>
<body>
	<div class="main">
		<main>
			<div class="main__imageBox">
				<img class="main__image" src="assets/images/seassist_logo.png"
					alt="ロゴ">
			</div>
			<h2>顧客管理システム</h2>
			<form action="login" method="post">
				<label for="userId">ユーザ名</label><br> <input type="text"
					name="id" placeholder=""><br> <label for="password">パスワード</label><br>
				<input type="password" name="password" placeholder=""><br>
				<br> <input type="submit" value="ログイン">
			</form>
		</main>
	</div>
</body>
</html>
