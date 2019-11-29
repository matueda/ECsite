<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>アイテム情報の削除確認画面</title>
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
						<p>アイテム情報の削除確認</p>
				</div>
				<div>
			<s:form>
			<h3>アイテム名[<s:property value="itemName" />]の商品を削除します。よろしいですか?</h3>
				<tr>
					<td><input type="button" value="キャンセル" onclick="submitAction('ItemDetailsAction')"/></td>
					<td><input type="button" value="OK" onclick="submitAction('ItemDeleteCompleteAction')"/></td>
					<s:hidden name="id" value="%{id}"/>
					<s:hidden name="itemName" value="%{itemName}"/>

				</tr>
			</s:form>
				</div>
			<div>
				<p>管理者TOP画面は<a href='<s:url action ="AdminAction"/>'>こちら</a></p>
				<p>アイテム情報の一覧画面に戻る場合は<a href='<s:url action="ItemPageAction"/>'>こちら</a></p>
			</div>
			<div id="footer">
			</div>
		</div>

</body>
</html>