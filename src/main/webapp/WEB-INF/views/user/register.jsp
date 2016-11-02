<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login/login.css">
<%@include file="/WEB-INF/views/common/header.jsp"%>
</head>
<body>

	<form class="form-horizontal">
		<fieldset>
			<div id="legend" class="">
				<legend class="">注册</legend>
			</div>
			<div class="control-group">

				<!-- Text input-->
				<label class="control-label" for="input01">邮箱</label>
				<div class="controls">
					<input type="text" placeholder="xxx@xx.xx" class="input-xlarge">
					<p class="help-block">请输入正确的邮箱</p>
				</div>
			</div>
			<div class="control-group">

				<!-- Text input-->
				<label class="control-label" for="input01">确认密码</label>
				<div class="controls">
					<input type="text" placeholder="*******" class="input-xlarge">
					<p class="help-block">密码大于6位，并且与上相同</p>
				</div>
			</div>
			<div class="control-group">

				<!-- Text input-->
				<label class="control-label" for="input01">密码</label>
				<div class="controls">
					<input type="text" placeholder="*******" class="input-xlarge">
					<p class="help-block">密码大于6位</p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label"></label>
				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success">提交</button>
				</div>
			</div>
		</fieldset>
	</form>

	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script type="text/javascript">
		/*document.write($("#test").val()+"--"+basePath);*/
		$.jCover({
			showWait : true
		});

		setTimeout(function() {
			$.jCover({
				showWait : false
			});
		}, 2000);
	</script>
</body>
</html>

