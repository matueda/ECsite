<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserCreate</title>
</head>
<body>
	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>パスワード再設定</p>
		</div>
		<div>
						<s:if test="userIdErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="userIdErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

			<s:if test="passwordErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="passwordErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

				<s:if test="inputErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="inputErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

				<s:if test="newPasswordErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="newPasswordErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

				<s:if test="reConfirmationNewPasswordErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="reConfirmationNewPasswordErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

	<!--
	<s:if test="passwordErrorMessageList!=null && passwordErrorMessageList.size()>0">
	<div class="error">
	<div class="error-message">
		<s:iterator value="passwordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
	</s:if>
	  -->
			<table>
				<s:form action="ResetPasswordConfirmAction" status="st" >
					<tr>
						<s:if test="#session.login_user_id ==null">
						<td align="right"><label>再設定したいIDを入力してください:</label></td>
						<td><s:textfield name="loginUserId" value="" placeholder="再設定したいユーザーID" theme="simple"/></td>
						</s:if>
						<s:if test="#session.login_user_id !=null">
						<td align="right"><label>現在のログインID:</label></td>
						<td><s:textfield name="loginUserId" value="%{#session.login_user_id}" disabled="true" theme="simple"/></td>
						</s:if>
					</tr>
					<tr>
						<td align="right"><label >現在のパスワード入力してください:</label></td>
						<td><s:textfield name="loginPassword" value="" placeholder="現在のパスワード" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label>新しいパスワードを入力してください:</label></td>
						<td><s:textfield name="newLoginUserPassword" value="" placeholder="新しいパスワード" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label>確認の為もう一度入力してください:</label></td>
						<td><s:textfield name="reNewLoginUserPassword" value="" placeholder="再度入力" theme="simple"/></td>
					</tr>
					<s:submit value="再設定"/><!--align="center"-->
				</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span> <a href='<s:url action="GoHomeAction" />'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>