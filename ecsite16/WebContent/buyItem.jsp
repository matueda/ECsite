<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItem画面</title>
<script type="text/javascript">

	function test() {
		var checkList= document.getElementById('checkbox').value;
		alert(checkList);

	}
</script>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:if test="errorMessageList">
				<s:iterator value="errorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
			</s:if>
			<s:form action="BuyItemAction" theme="simple">
				<table border="1">
					<tr>
						<th>チェック</th>
						<th>商品名</th>
						<th>値段</th>
						<th>在庫</th>
						<th>個数</th>
					</tr>

					<s:iterator value="session.buyItemDTOList" status="st">
						<tr>
<!-- 							<td><input type="checkbox" id="checkbox" name="checkList" value="%{#st.index}" ></td> -->
							<td><s:checkbox name="checkList" value="checked" fieldValue="%{#st.index}"/></td>
							<td><s:property value="itemName" /> </td>
							<td><s:property value="itemPrice" /><span>円</span></td>
							<td><s:property value="itemStock" /><span>個</span></td>
							<td><select name="counts">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select></td>
						</tr>
					<input type="hidden" value="<s:property value="id"/>" name="ids">
										<input type="hidden" value="<s:property value="itemName"/>" name="itemNames">
					<input type="hidden" value="<s:property value="itemPrice"/>" name="itemPrices">
					<input type="hidden" value="<s:property value="itemStock"/>" name="itemStocks">
					</s:iterator>
				</table>
				<tr>
					<td><span>支払い方法</span></td>
					<td><input type="radio" name="pay" value="1" checked="checked">現金払い
						<input type="radio" name="pay" value="2">クレジットカード</td>
				</tr>
				<table>

					<tr>
						<td><s:submit value="購入"  onclick="test() "/></td>
					</tr>
				</table>
			</s:form>
			<div>
				<p>
					前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
				</p>
				<p>
					マイページは<a href='<s:url action="MyPageAction" />'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>