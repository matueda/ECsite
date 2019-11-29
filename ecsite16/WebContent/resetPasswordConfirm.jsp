<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>パスワード再設定確認画面</title>
		<script type="text/javascript">
			function submitAction(url){
					$('form').attr('action',url);
					$('form').submit();
			}
			</script>


</head>
<body>
		<div id="header">
		</div>
		<div id="main">
				<div id="top">
						<p>DeleteItem</p>
				</div>
				<div>
			<s:form>
										<table border="1">
							<tr>
									<th>ユーザーID</th>
									<th>新しいパスワード</th>
							</tr>
						<s:iterator value="execute()">
							<tr>
								<td><s:property value="loginUserId" /></td>
								<td><s:property value="newLoginUserPassword" /></td>
							</tr>
							</s:iterator>
							</table>
			<h3>上記の内容でパスワードを再設定します。本当によろしいですか？</h3>
				<tr>
					<td><input type="button" value="キャンセル" onclick="submitAction('ResetPasswordAction')"/></td>
					<td><input type="button" value="OK" onclick="submitAction('ResetPasswordCompleteAction')"/></td>
				</tr>
			</s:form>
				</div>
			<div>
				<p>HOME画面に戻る場合は<a href='<s:url action="HomeAction"/>'>こちら</a></p>
			</div>
			<div id="footer">
			</div>
		</div>

</body>
</html>