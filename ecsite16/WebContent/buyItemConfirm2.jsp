<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/buyitemconfirm.css">
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
<body>
<div class="pace-running wrap">
<div class="css-fade1">
  <div class="sign-up">
    <h1 class="sign-up-title">購入するものはこれでいいかな？</h1>
    				<table>
					<s:iterator value="buyItemDTOList" status="st">
						<tr>
							<td><s:property value="itemName"/></td>
							<td><s:property value="itemPrice"/><span>円</span></td>
							<td><s:property value="count"/><span>個</span></td>
						</tr>
					</s:iterator> </table>
				<br>
								<br><div class="tyumon">
				<h3> 以下の二点も確認してね！</h3>
				<span>・注文合計金額は<b><s:property value="totalPrice"/></b>円だよ。</span>
				<br>
				<span>・支払い方法は<b><s:property value="session.pay"/></b>支払いだよ</span>
				</div>
				<br>
				<br>
    <table>
    <tr>
       <td><form action="BuyItemAction2"><input type="submit" value=" やめておく！ " class="sign-up-button"></form></td>
       <td><form action="BuyItemConfirmAction2"><input type="submit" value=" 購入するよ！ " class="sign-up-button"></form></td>
        </tr>
            </table>
    				<div class="text-link">
						<p><a href='<s:url action="GoHomeAction2" />'>back to HOME</a></p>
				</div>
  </div>
  </div>
  </div>
</body>
</html>