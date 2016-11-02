<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Expires " content= "0 "> 
<meta http-equiv= "kiben " content= "no-cache "> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<link href="login/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="login/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="login/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="login/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="login/js/Validform_v5.3.2_min.js"></script>

<script>

$(function(){

$(".i-text").focus(function(){
$(this).addClass('h-light');
});

$(".i-text").focusout(function(){
$(this).removeClass('h-light');
});

$("#username").focus(function(){
 var username = $(this).val();
 if(username=='输入账号'){
 $(this).val('');
 }
});

$("#username").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入账号');
 }
});


$("#password").focus(function(){
 var username = $(this).val();
 if(username=='输入密码'){
 $(this).val('');
 }
});


$("#yzm").focus(function(){
 var username = $(this).val();
 if(username=='输入验证码'){
 $(this).val('');
 }
});

$("#yzm").focusout(function(){
 var username = $(this).val();
 if(username==''){
 $(this).val('输入验证码');
 }
});



$(".registerform").Validform({
	tiptype:function(msg,o,cssctl){
		var objtip=$(".error-box");
		cssctl(objtip,o.type);
		objtip.text(msg);
	},
	ajaxPost:true
});

});


function checkImg(obj){
	obj.src="img/execute?"+Math.random();
}
</script>


</head>

<body>


<div class="header">
  <h1 class="headerLogo"><a title="后台管理系统" target="_blank" href="javascript:#;"><img alt="logo" src="login/images/logo.gif"></a></h1>
	<div class="headerNav">
		<a target="_blank" href="javascript:#;">**官网</a>
		<a target="_blank" href="javascript:#;">关于**</a>
		<a target="_blank" href="javascript:#;">开发团队</a>
		<a target="_blank" href="javascript:#;">意见反馈</a>
		<a target="_blank" href="javascript:#;">帮助</a>	
	</div>
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
   <form class="registerform" method="post" action="login/validate" >
   <div class="fm-item">
	   <label for="logonId" class="form-label">****系统登陆：</label>
	   <input name="usersName" type="text" value="输入账号" maxlength="100" id="username" class="i-text" ajaxurl="demo/valid.jsp"  datatype="s6-18" errormsg="用户名至少6个字符,最多18个字符！"  >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">登陆密码：</label>
	   <input name="usersPass" type="password" value="" maxlength="100" id="password" class="i-text" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！">    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item pos-r">
	   <label for="logonId" class="form-label">验证码</label>
	   <input name="validate" type="text" value="输入验证码" maxlength="100" id="yzm" class="i-text yzm" nullmsg="请输入验证码！" >    
       <div class="ui-form-explain"><img src="img/execute" onclick="checkImg(this)" class="yzm-img" /></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
       <div class="ui-form-explain"></div>
  </div>
  
  </form>
  
  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url(login/themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a target="_blank" href="javascript:#;"></a></li>
			<li style="background:url(login/themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank" href="javascript:#;"></a></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
   <p>Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="javascript:#;/">调试页面</a></p>
</div>
</body>
</html>
