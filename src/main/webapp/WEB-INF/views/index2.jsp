<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<style type="text/css">
*{margin:0px;padding:0px;list-style-type:none;}
body{margin:0 auto; background:url(images/homepage/bg.jpg) fixed no-repeat 50% 5%;}
#left{float:left;height:46px;width:8px;margin-left:20px;}
#right{float:right;height:46px;width:8px;}

/* header */
.header{width:958px;height:23px;line-height:23px;margin:40px auto;} /*border:#333333 solid 1px;*/

/* menu */
.menu{ width:1000px;height:700px;margin:0 auto; background:url(images/homepage/bg_menu.jpg) no-repeat 50% 50%;
	filter:alpha(opacity=50);
	/*-moz-opacity:0.5;
	-khtml-opacity: 0.5;
	opacity: 0.5;*/
	}

/* nav */
.nav{width:950px;height:46px;background:#4d7c80;margin:40px auto;margin-top:0px;}/*url(images/homepage/nav_bg.jpg) repeat-x;margin:40px auto;*/
.nav li{float:left;width: 108px;height:46px;line-height:46px;text-align:center;font-size:14px;position:relative;z-index:100;}
.nav li a{color:#FFF;text-decoration:none;display:block;font-weight:bold;}
.nav li a.link{float:left;width: 108px;}
.nav ul li a:hover{background:url(images/homepage/nav_hover.jpg) no-repeat;display:block;}
.nav dl{width:108px;border:1px solid #81b9b9;font-size:12px;background:#bfd4d6;position:absolute;top:46px;left:0px;}
.nav dl dd a{color:#fff;}
.nav dl dd a:hover{color:#000;background:#81b9b9;opacity:0.5;}

/* main */
.main{width:900px;height:570px;border:1px solid #81b9b9;margin:0 auto; position:relative;z-index:90;}


/* footer */
.footer{width:1000px;};
</style>
</head>

<body>

<div class="header">
	<p style="display:inline; margin-left:100px;color:red;">[<a style="color:red;" href="login">登入</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a style="color:red;" href="#">免费注册</a>]</p>
	<span style="font-size:12px; margin-left:340px;color:#fff">	
			业界分析&nbsp;&nbsp;|&nbsp;&nbsp;个性化推荐&nbsp;&nbsp;|&nbsp;&nbsp;礼品|团购&nbsp;&nbsp;|&nbsp;&nbsp;|帮助
	</span>
</div>
<div class="menu">
	<div class="nav">
		<div id="left"><!--<img src="images/homepage/nav_l.jpg">--></div>
		<ul>
			<li><a class="link" href="#">网站首页</a></li>
			<li class="mainmenu">
				<a class="link" href="#">电子商务</a>
				<dl>
					<dd><a href="#">零度对策</a></dd>
					<dd><a href="#">网站建设</a></dd>
					<dd><a href="#">网络营销</a></dd>
					<dd><a href="#">电子商务</a></dd>
					<dd><a href="#">广告代码</a></dd>
					<dd><a href="#">网页菜单</a></dd>
				</dl>
			</li>
			<li class="mainmenu">
				<a class="link" href="#">网络营销</a>
				<dl>
					<dd><a href="#">零度对策</a></dd>
					<dd><a href="#">网站建设</a></dd>
					<dd><a href="#">网络营销</a></dd>
					<dd><a href="#">电子商务</a></dd>
					<dd><a href="#">广告代码</a></dd>
					<dd><a href="#">网页菜单</a></dd>
				</dl>
			</li>
			<li class="mainmenu">
				<a class="link" href="#">客户服务</a>
				<dl>
					<dd><a href="#">零度对策</a></dd>
					<dd><a href="#">网站建设</a></dd>
					<dd><a href="#">网络营销</a></dd>
					<dd><a href="#">电子商务</a></dd>
					<dd><a href="#">广告代码</a></dd>
					<dd><a href="#">网页菜单</a></dd>
				</dl>    
			</li>
			<li class="mainmenu">
				<a class="link" href="#">工程案例</a>
				<dl>
					<dd><a href="#">零度对策</a></dd>
					<dd><a href="#">网站建设</a></dd>
					<dd><a href="#">网络营销</a></dd>
					<dd><a href="#">电子商务</a></dd>
					<dd><a href="#">广告代码</a></dd>
					<dd><a href="#">网页菜单</a></dd>
				</dl>  
			</li>
			<li class="mainmenu">
				<a class="link" href="#">行业资讯</a>
				<dl>
					<dd><a href="#">零度对策</a></dd>
					<dd><a href="#">网站建设</a></dd>
					<dd><a href="#">网络营销</a></dd>
					<dd><a href="#">电子商务</a></dd>
					<dd><a href="#">广告代码</a></dd>
					<dd><a href="#">网页菜单</a></dd>
				</dl>  
			</li>

			<li class="mainmenu"><a href="homepage/help"  target="_blank">联系我们</a></li>
		</ul>
		<div id="right"><!--<img src="images/homepage/nav_r.jpg">--></div>
	</div>
	<div class="main"> 
		<iframe id="main_iframe" name="main_iframe" src="<c:url value='homepage' />"  width="100%" height="100%" scrolling="no" frameborder="0"></iframe>
	</div>
</div>

<div style="text-align:center;margin:30px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. </p>
<p>简介：<a href="http://www.weixingyu.cn/" target="_blank">个人测试网页</a></p>
</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<script type="text/javascript">
	$(function(){
	
		$("dl").hide();
		
		$("li.mainmenu").hover(function(){
			$(this).find("dl").stop(true,true);
			$(this).find("dl").slideDown();
		},function(){
			$(this).find("dl").stop(true,true);
			$(this).find("dl").slideUp();
		});
		
	})
	
	document.write($("#test").val()+"--"+basePath);
	$.jCover({showWait:true});
	
	setTimeout(function(){
		$.jCover({showWait:false});
	},1000);
	var pp = $(window.frames["main_iframe"].document);//.find("#test");
	var nn = document.getElementById('main_iframe').contentWindow.document.getElementById('test');
	
</script>
