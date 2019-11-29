<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/usercreate.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.min.js"></script>
                   <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/blue/pace-theme-corner-indicator.css" />
<title>Login画面</title>
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
  <form class="sign-up" action="UserCreateConfirmAction2">
    <h1 class="sign-up-title">Sign up and color soul!</h1>
      			<div class="errortext"><s:if test="errorMessage !=''">
				<s:property value="errorMessage" escape="false" />
				</s:if></div>
        <s:textfield name="loginUserId" class="sign-up-input" placeholder="好きなIDを入力しましょう！"/>
    <s:textfield name="loginPassword"  class="sign-up-input" placeholder="パスワードは何にしますか？"/>
    <s:textfield name="userName"  class="sign-up-input" placeholder="好きな名前を決めてね！"/>
    <input type="submit" value="さぁ登録するよ！" class="sign-up-button">
    				<div class="text-link">
						<p><a href='<s:url action="GoHomeAction2" />'>back to HOME</a></p>
				</div>
  </form>
  </div>
  </div>
</body>
</html>