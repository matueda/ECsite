<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/resetpasswordcomplete.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/pace.min.js"></script>
                   <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pace/1.0.2/themes/purple/pace-theme-corner-indicator.css" />
<title>パスワードリセット完了画面</title>
<script type="text/javascript">
	Pace.on('done', function(){
        $('.wrap').fadeIn();
        $('.fadeIn').fadeIn();
        $('body').fadeIn();
    });
</script>
		<script type="text/javascript">

		</script>
</head>
<body>
<div class="pace-running wrap">
<div class="css-fade1">
   <div class="font1"><label>変更完了！</label><br></div>
    <div class="font2"> <label>パスワードの再設定が終わりました！</label></div>
  <div class="font3">
  <a href="GoHomeAction2" class="btn-flat-dashed-border1">HOMEに帰りましょう！</a></div>
  </div>
  </div>
</body>
</html>