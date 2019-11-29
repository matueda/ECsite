<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>
		<div id="header">
		</div>

		<div id="main">
			<div id="top">
						<p>管理者画面</p>
			</div>
		<div id="admin_item">
					<div id="titlebox1"><span id="title">商品</span></div>
				<s:form action="ItemCreateAction">
				<s:submit value="新規商品登録" />
				</s:form>
				<s:form action="AttentionRegistrationAction">
				<s:submit value="宛先登録" />
				</s:form>
				<s:form action="ItemPageAction">
				<s:submit value="商品一覧" />
				</s:form>
		</div>
				<div id="admin_user">
				<div id="titlebox2"><span id="title">ユーザー</span></div>
				<s:form action="UserCreateAction">
				<s:submit value="新規登録" />
				</s:form>
				<s:form action="AttentionRegistrationAction">
				<s:submit value="宛先登録" />
				</s:form>
				<s:form action="AccountPageAction">
				<s:submit value="一覧" />
				</s:form>
		</div>
			</div>
					<div id="footer">
		</div>
</body>
</html>