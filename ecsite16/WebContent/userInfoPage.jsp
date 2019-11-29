<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ユーザー一覧画面</title>
</head>
<body>

		<div id="header">
		</div>

		<div id="main">
			<div id="top">
						<p>MyPage</p>
			</div>
			<div>
				<s:if test="userPageList==null">
							<h3>ユーザー情報はありません。</h3>
				</s:if>
				<s:elseif test="message==null">
							<h3>ユーザー情報は以下になります。</h3>
							<table border="1">
							<tr>
									<th>ID</th>
									<th>ログインID</th>
									<th>パスワード</th>
									<th>ユーザー名</th>
									<th>登録日</th>
									<th>更新日</th>
									<th>詳細</th>
							</tr>
						<s:iterator value="userPageList">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="loginId"/></td>
								<td><s:property value="loginPass"/></td>
								<td><s:property value="userName"/></td>
								<td><s:property value="insert_date"/></td>
								<td><s:property value="update_date"/></td>
								<td>
								<a href='<s:url action="UserDetailsAction">
									<s:param name="loginId" value="%{loginId}"/>
									</s:url>'>詳細</a>
								</td>
							</tr>
							</s:iterator>
							</table>
							<s:form action="UserListDeleteConfirmAction">
								<s:submit value="削除"/>
							</s:form>
						</s:elseif>

					<div id="text-right">
							<p>管理者TOP画面に戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
					</div>
			</div>
		</div>
		<div id="footer">
		</div>
</body>
</html>