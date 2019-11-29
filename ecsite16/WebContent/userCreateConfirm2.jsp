<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/usercreateconfirm.css">
<title>ユーザー登録確認画面</title>
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
    <h1 class="sign-up-title">Confirm for register</h1>
    				<table>
    <tr>
            <td><label >ログインID:</label></td>
    <td><div class="showdata">
    <p><s:property value="loginUserId" escape="false"/></p>
    </div></td></tr>

        <tr>
            <td><label >ログインPASS:</label></td>
    <td><div class="showdata">
    <p><s:property value="loginPassword" escape="false"/></p>
    </div></td></tr>

        <tr>
            <td><label >ユーザー名:</label></td>
    <td><div class="showdata">
    <p><s:property value="userName" escape="false"/></p>
    </div></td></tr>            </table>

    <table>
    <tr>
       <td><form action="UserCreateAction2"><input type="submit" value=" やめておく！ " class="sign-up-button"></form></td>
       <td><form action="UserCreateCompleteAction2"><input type="submit" value=" 登録するよ！ " class="sign-up-button"></form></td>
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