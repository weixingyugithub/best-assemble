<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<meta http-equiv= "Expires " content= "0 "> 
<meta http-equiv= "kiben " content= "no-cache "> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/common/header.jsp" %>
</head>
<body>
我是首页奥
<a href="">asdf</a>
<%=request.getContextPath() %>
<c:out value="${basePath}"></c:out>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>