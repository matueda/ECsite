<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.min.js"></script>
                   <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/green/pace-theme-loading-bar.css" />
<link rel="stylesheet" type="text/css" href="./css/style2.css">
<script src="https://code.jquery.com/jquery-1.12.4.js" type="text/javascript"></script>
<title>Home画面</title>
<!-- ▼今回のスクリプト本体 -->
<script type="text/javascript">
   $(".Color1").children().addBack().contents().each(function(){
      if (this.nodeType == 3) {
         var $this = $(this);
         $this.replaceWith($this.text().replace(/(\S)/g, "<span>$&</span>"));
      }
   });
</script>
</head>
<body>
<div class="pace-running wrap">
<div class="css-fade1">
<div class="bgi">
  <img src="./image/color1.png" />
  <p class="Color1"><span>C</span><span>O</span><span>L</span><span>O</span><span>R</span> YOUR <span>S</span><span>O</span><span>U</span><span>L</span></p>
  <a href="HomeAction2" class="btn-flat-dashed-border1">BUY COLOR</a>
<a href="UserCreateAction2" class="btn-flat-dashed-border2">REGISTER</a>
<a href="ResetPasswordAction2" class="btn-flat-dashed-border3">CHANGE PASSWORD</a>
</div>
<div>
</div>
</div>
</div>





<!--
<div class="pace-running wrap">
<div class="css-fade1">
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入" />
			</s:form>
			<s:form action="AdminAction">
				<s:submit value="管理者画面" />
			</s:form>
						<s:if test="#session.login_user_id ==null">
				<s:form action="ResetPasswordAction2">
				<s:submit value="パスワード再設定" />
			</s:form>
						</s:if>
			<s:if test="#session.login_user_id !=null">
				<p>
					ログアウトする場合は <a href='<s:url action="LogoutAction"/>'>こちら</a>
				</p>
					<p>
					パスワードの再設定をする場合は <a href='<s:url action="ResetPasswordAction2"/>'>こちら</a>
				</p>
			</s:if>
		</div>
	</div>
	<div id="footer"></div>
		</div>
	</div>
		-->
</body>
</html>