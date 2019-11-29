<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/usercreateconfirm.css">
<title>パスワードリセット確認画面</title>
		<script type="text/javascript">
			function submitAction(url){
					$('form').attr('action',url);
					$('form').submit();
			}
		</script>
</head>
<body>
<div class="pace-running wrap">
<div class="css-fade1">
  <div class="sign-up">
    <h1 class="sign-up-title">Confirm for reset password</h1>
    				<table>
    <tr>
            <td><label >変更するID:</label></td>
    <td><div class="showdata">
    <p><s:property value="loginUserId" escape="false"/></p>
    </div></td></tr>

        <tr>
            <td><label >新しいパスワード:</label></td>
    <td><div class="showdata">
    <p><s:property value="newLoginUserPassword" escape="false"/></p>
    </div></td></tr></table>

    <table>
    <tr>
       <td><form action="ResetPasswordAction2"><input type="submit" value=" やめておく！ " class="sign-up-button"></form></td>
       <td><form action="ResetPasswordCompleteAction2"><input type="submit" value=" 設定するよ！ " class="sign-up-button"></form></td>
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