<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.beijing.wei.login.model.ProjectUser"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/common/header.jsp"%>
</head>
<body>
	<form action="${basePath}user/userList">
		<c:forEach items="${page.list}" var="user" varStatus="status">
			${user.userId}----${user.userName} ----${user.userPass}---<br/>
		</c:forEach>
		<jsp:include page="/WEB-INF/views/common/page.jsp"></jsp:include>
	</form>

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

