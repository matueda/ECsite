<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Home画面</title>
</head>
<body >
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入" />
			</s:form>
			<s:form action="AdminAction">
				<s:submit value="管理者画面" />
			</s:form>
						<s:if test="#session.login_user_id ==null">
				<s:form action="ResetPasswordAction">
				<s:submit value="パスワード再設定" />
			</s:form>
						</s:if>
			<s:if test="#session.login_user_id !=null">
				<p>
					ログアウトする場合は <a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>
					<p>
					パスワードの再設定をする場合は <a href='<s:url action="ResetPasswordAction"/>'>こちら</a>
				</p>
			</s:if>
		</div>
	</div>
				<div id="layoutchangebutton">
				<s:form action="HomeChangeAction">
				<s:submit value="レイアウト変更" />
			</s:form>
			</div>
	<div id="footer"></div>
</body>
</html>