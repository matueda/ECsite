<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>宛先情報登録</title>
</head>
<body>
	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>宛先情報登録ページ</p>
		</div>
		<div>
<div class="errorlist">
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

			<s:if test="familyNameErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="familyNameErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

				<s:if test="firstNameErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="firstNameErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

				<s:if test="streetAddressErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="streetAddressErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

				<s:if test="callNumberErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="callNumberErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>
</div>

<div class="inputform">
			<table>
				<s:form action="AttentionRegistrationConfirmAction" status="st" >
					<tr>
						<td align="right"><label>宛先を登録したいユーザーIDを入力してください:</label></td>
						<td><s:textfield name="loginUserId" value="" placeholder="ユーザーID" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label >名字を入力してください(姓):</label></td>
						<td><s:textfield name="familyName" value="" placeholder="例:田中" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label >名字をふりがなで入力してください:</label></td>
						<td><s:textfield name="familyNameKana" value="" placeholder="例:たなか" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label >名前を入力してください(名):</label></td>
						<td><s:textfield name="firstName" value="" placeholder="例:太郎" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label>名前をふりがなで入力してください:</label></td>
						<td><s:textfield name="firstNameKana" value="" placeholder="例:たろう" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label>住所を全て記入してください:</label></td>
						<td><s:textfield name="streetAddress" value="" placeholder="例:東京都千代田区インターノウス町1-1 システムカレッジ101" theme="simple"/></td>
					</tr>
					<tr>
						<td align="right"><label>電話番号をハイフン無しで入力してください:</label></td>
						<td><s:textfield name="callNumber" value="" placeholder="例:00011112222" theme="simple"/></td>
					</tr>
					<s:submit value="登録"/><!--align="center"-->
				</s:form>
			</table>
			</div>
			<div>
				<span>前画面に戻る場合は</span> <a href='<s:url action="AdminAction" />'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>