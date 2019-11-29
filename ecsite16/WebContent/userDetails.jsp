<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザーページ詳細画面</title>
</head>
<body>

		<div id="header">
		</div>

		<div id="main">
			<div id="top">
						<p>MyPage</p>
			</div>
			<div>
				<s:if test="accountPageDTO==null">
							<h3>ユーザー情報はありません。</h3>
				</s:if>
				<s:elseif test="message==null">
							<h3>ユーザー情報は以下になります。</h3>
							<table border="1">
							<tr>
								<th>ID</th>
								<td><s:property value="accountPageDTO.id"/></td>
							</tr>
							<tr>
								<th>ログインID</th>
								<td><s:property value="accountPageDTO.loginId"/></td>
							</tr>
							<tr>
								<th>パスワード</th>
								<td><s:property value="accountPageDTO.loginPass"/></td>
							</tr>
							<tr>
								<th>ユーザー名</th>
								<td><s:property value="accountPageDTO.userName"/></td>
							</tr>
							<tr>
								<th>登録日</th>
								<td><s:property value="accountPageDTO.insert_date"/></td>
							</tr>
							<tr>

								<th>更新日</th>
								<td><s:property value="accountPageDTO.update_date"/></td>
							</tr>
							</table>
					<s:form action="UserDeleteConfirmAction">
						<s:submit value="削除" />
						<s:hidden name="loginId" value="%{loginId}"/>
					</s:form>
						</s:elseif>

					<div id="text-right">
							<p>管理者TOP画面に戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
							<p>前のページに戻る場合は<a href='<s:url action="AccountPageAction"/>'>こちら</a></p>
					</div>
			</div>
		</div>
		<div id="footer">
		</div>
</body>
</html>