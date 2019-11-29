<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/buyitem.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.min.js"></script>
                   <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/yellow/pace-theme-center-atom.css" />
<title>BuyItem画面</title>
<script type="text/javascript">

	function test() {
		var checkList= document.getElementById('checkbox').value;
		alert(checkList);

	}

	Pace.on('done', function(){
        $('.wrap').fadeIn();
        $('.fadeIn').fadeIn();
        $('body').fadeIn();
    });
</script>
</head>
<body>
<div class="pace-running wrap">
<div class="css-fade1">
		</div>
		<div>
			<s:form action="BuyItemAction2" class="sign-up" theme="simple">
			    <h1 class="sign-up-title">Let me pray to color your soul!</h1>
				<table >
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

				<table>
				<tr>
					<td><span>支払い方法</span></td>
					<td><input type="radio" name="pay" value="1" checked="checked">現金払い
						<input type="radio" name="pay" value="2">クレジットカード</td>
				</tr>
				</table>
									<tr>
					    <td><div class="buyit"><s:submit value="購入！" onclick="test()" class="sign-up-button"/></div></td>
					</tr>
							<s:if test="errorMessageList">
				<s:iterator value="errorMessageList" var="target" status="st">
				<div class="errortext">
					<s:property escape="false" />
				</div>
				</s:iterator>
			</s:if>
											<p>
					前画面に戻る場合は<a href='<s:url action="GoHomeAction2" />'>こちら!</a>
				</p>
				<p>
					マイページは<a href='<s:url action="MyPageAction2" />'>こちら!</a>
				</p>
			</s:form>
			<div>
			</div>
		</div>
	</div>

</body>
</html>