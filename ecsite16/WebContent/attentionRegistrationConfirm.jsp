<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>宛先登録確認画面</title>
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
						<p>宛先登録確認ページ</p>
				</div>
				<div>
			<s:form>
										<table border="1">
						<s:iterator value="execute()">
							<tr>
								<th>ユーザーID</th>
								<td><s:property value="loginUserId" /></td>
								</tr>
								<tr>
								<th>名字</th>
								<td><s:property value="familyName" />(<s:property value="familyNameKana" />)</td>
								</tr>
								<tr>
								<th>名前</th>
								<td><s:property value="firstName" />(<s:property value="firstNameKana" />)</td>
								</tr>
								<tr>
								<th>住所</th>
								<td><s:property value="streetAddress" /></td>
								</tr>
								<tr>
								<th>電話番号</th>
								<td><s:property value="callNumber" /></td>
							</tr>
							</s:iterator>
							</table>
			<h3>上記の内容で宛先を登録します。本当によろしいですか？</h3>
				<tr>
					<td><input type="button" value="キャンセル" onclick="submitAction('AttentionRegistrationAction')"/></td>
					<td><input type="button" value="OK" onclick="submitAction('AttentionRegistrationCompleteAction')"/></td>
				</tr>
			</s:form>
				</div>
			<div>
				<span>TOP画面に戻る場合は</span> <a href='<s:url action="AdminAction" />'>こちら</a>
			</div>
			<div id="footer">
			</div>
		</div>

</body>
</html>