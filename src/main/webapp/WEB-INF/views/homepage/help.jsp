<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>帮助页面</title>
<%@include file="/WEB-INF/views/common/header.jsp" %>
</head>
<body>
	<center>
	<p><h1>欢迎进入</h1></p>
	<p>联系人：魏星玉</p>
	<p>邮     箱：com.beijing.wei@live.com</p>
	<p>    QQ：<a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=de1eb5327c9de71965f033193df0f228a5e8efa4ddd44f27"><img border="0" src="http://wpa.qq.com/imgd?IDKEY=de1eb5327c9de71965f033193df0f228a5e8efa4ddd44f27&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></p>
	</center>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script type="text/javascript">
	document.write($("#test").val()+"--"+basePath);
	$.jCover({showWait:true});
	
	setTimeout(function(){
		$.jCover({showWait:false});
	},3000);
</script>
