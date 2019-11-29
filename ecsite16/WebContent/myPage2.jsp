<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/mypage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.min.js"></script>
                   <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/yellow/pace-theme-center-atom.css" />
<title>BuyItem画面</title>
<script type="text/javascript">

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
<div class="sign-up">
				<s:if test="myPageList==null">
							<h3>あら！どうやら購入したものはないみたいだ…</h3>
				</s:if>
				<s:elseif test="message==null">
			    <h1 class="sign-up-title">購入したものを並べるよ！</h1>
							<table >
							<tr>
									<th>商品名</th>
									<th>値段</th>
									<th>購入個数</th>
									<th>支払い方法</th>
									<th>購入日</th>
							</tr>
						<s:iterator value="myPageList">
							<tr>
								<td><s:property value="itemName"/></td>
								<td><s:property value="totalPrice"/><span>円</span></td>
								<td><s:property value="totalCount"/><span>個</span></td>
								<td><s:property value="payment"/></td>
								<td><s:property value="insert_date"/></td>
							</tr>
							</s:iterator>
							</table>
							<s:form action="MyPageAction2" class="delete">
								<input type="hidden" name="deleteFlg" value="1">
								<s:submit value="削除するよ！"  class="sign-up-button"/>
							</s:form>
						</s:elseif>
						<s:if test="message!=null">
							<h3><s:property value="message"/></h3>
						</s:if>
					<div id="text-right">
							<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction2"/>'>こちら</a></p>
							<p>ログアウトする場合は<a href='<s:url action="LogoutAction2"/>'>こちら</a></p>
					</div>
				</div>
			<div>
			</div>
		</div>
	</div>

</body>
</html>