<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>パスワード再設定完了画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>パスワードが変更されました</p>
		</div>
		<div>
						<p><a href='<s:url action ="ResetPasswordAction"/>'>パスワード再設定画面へ戻る</a></p>
						<p><a href='<s:url action ="HomeAction"/>'>HOME画面へ戻る</a></p>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>