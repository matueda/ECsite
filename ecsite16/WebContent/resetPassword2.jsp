<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/resetpassword.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.min.js"></script>
                   <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/purple/pace-theme-corner-indicator.css" />
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
  <form class="sign-up" action="ResetPasswordConfirmAction2">
    <h1 class="sign-up-title">Reset Password</h1>
						<s:if test="userIdErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="userIdErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>
							<s:if test="inputErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="inputErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>
        <s:textfield name="loginUserId" class="sign-up-input" placeholder="再設定したいユーザーID"/>
        			<s:if test="passwordErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="passwordErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>

							<s:if test="inputErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="inputErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>
    <s:textfield name="loginPassword"  class="sign-up-input" placeholder="現在のパスワード"/>

    				<s:if test="newPasswordErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="newPasswordErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>
    <s:textfield name="newLoginUserPassword"  class="sign-up-input" placeholder="新しいパスワード"/>


    				<s:if test="reConfirmationNewPasswordErrorMessageList">
				<div class="error">
				<div class="error-message">
				<s:iterator value="reConfirmationNewPasswordErrorMessageList" var="target" status="st">
				<div>
					<s:property escape="false" />
				</div>
				</s:iterator>
				</div>
				</div>
			</s:if>
        <s:textfield name="reNewLoginUserPassword"  class="sign-up-input" placeholder="再度入力"/>
    <input type="submit" value="再設定するよ！" class="sign-up-button">
    				<div class="text-link">
						<p><a href='<s:url action="GoHomeAction2" />'>back to HOME</a></p>
				</div>
  </form>
  </div>
  </div>
</body>
</html>