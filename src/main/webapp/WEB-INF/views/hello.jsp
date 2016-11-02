<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<link rel="stylesheet" href="${basePath }static/css/login/login.css">
<%@include file="/WEB-INF/views/common/header.jsp"%>
</head>
<body>
<!-- <div class="container-fluid">
	<div class="row">
	  <div class="col-md-9">.col-md-3</div>
	  <div class="col-md-3"><a style="font-size:14px;" href="#" >注册</a>  <a style="font-size:14px;" href="#" >帮助</a></div>
	</div>
</div>-->

<div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">登    陆</h2>
        <input type="email" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label style="float:left;">
            <input type="checkbox" value="remember-me">记住密码    
          </label>
		  <a style="font-size:12px;float:right;" href="#" >忘记密码?</a>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登    陆</button>
      </form>
      
      <div style="position:absolute;top:100px;width:100px;height:100px;border:1px solid red;">
      	<form action="${basePath}upload/test" enctype="multipart/form-data" method="post">
      		<input type="file" name="file" onchange="fileChange(this);"/>
      		<input type="submit" value="好的" />
      	</form>
      </div>
</div>
<%@include file="/WEB-INF/views/common/footer.jsp"%>
<script type="text/javascript">
	/*document.write($("#test").val()+"--"+basePath);*/
	$.jCover({showWait:true});
	
	setTimeout(function(){
		$.jCover({showWait:false});
	},2000);
	

</script>
</body>
</html>

