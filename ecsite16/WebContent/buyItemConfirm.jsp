<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItemConfirm画面</title>

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
						<p>BuyItem</p>
				</div>
				<div>
			<s:form>
			<h2>ご注文の内容は以下の通りになります。</h2>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
					</tr>

					<s:iterator value="buyItemDTOList" status="st">
						<tr>
							<td><s:property value="itemName"/></td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="count"/><span>個</span></td>
						</tr>
					</s:iterator>
				</table>
				<br>
				<h3>以下の二点のご確認をお願い致します。</h3>
				<br>
				<span>・ご注文合計金額は<b><s:property value="totalPrice"/></b>円です。</span>
				<br>
				<span>・お支払い方法は<b><s:property value="session.pay"/></b>支払いです。</span>
				<br>
				<br>
				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>
					<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
				</tr>
			</s:form>
				</div>
								<br>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action ="MyPageAction"/>'>こちら</a></p>
			</div>
			<div id="footer">
			</div>
		</div>

</body>
</html>