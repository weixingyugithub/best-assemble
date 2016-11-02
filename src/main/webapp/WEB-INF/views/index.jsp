<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>柘城欢迎您</title>
<%-- <link rel="stylesheet" href="${basePath}static/css/login/login.css"> --%>
<%@include file="/WEB-INF/views/common/header.jsp"%>
<style type="text/css">
body{
	margin:0;
	height:100%;
	font-size:14px;
	line-height:160%;
	color:#666;
	background:url(${basePath}static/images/index/bg.png) repeat;
	}
	
/* ===========================
--- Contact
============================ */

.form-wrapper {
	background: #f9f9f9;
	padding: 40px;
	 border-radius: 6px;
}


form#contact-form .form-group label {
	text-align: left !important;
	display: block;
	letter-spacing: 1px;
	font-size: 16px;
}
form#contact-form input,form#contact-form select,form#contact-form textarea {
	border-radius: 4px;
	border: 1px solid #eee;
  -webkit-box-shadow: none;
          box-shadow:  none;
	font-size: 16px;
	margin-bottom: 20px;
	background: #fefefe;
	color: #888;
}

form#contact-form input,form#contact-form select {
	height: 40px;
}

form#contact-form button {
	border-radius: 4px;
	height: 40px;
	text-transform: none;
	font-size: 16px;
	font-weight: 700;
}

form#contact-form input:focus,form#contact-form select:focus,form#contact-form textarea:focus {
  -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
          box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	background: #fff;
}


/* ===========================
--- Footer
============================ */

footer {
	text-align: center;
	padding: 50px 0 30px;
	background-color:#C2C2C2;
}

footer p {
	color: #f8f8f8;
}

footer a {
	color: #fff;
}

footer a:hover {
	color: #ccc;
}

/* 登陆 */
.form-horizontal {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
  padding-top: 40px;
}
.form-horizontal .form-signin-heading,
.form-horizontal .checkbox {
  margin-bottom: 10px;
  text-align:center;
}
.form-horizontal .checkbox {
  font-weight: normal;
}
.form-horizontal .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-horizontal .form-control:focus {
  z-index: 2;
}
.form-horizontal input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-horizontal input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

#loginModal .modal-dialog{
	max-width: 430px;
}


</style>
</head>
<body>
<div class="alert alert-danger" id="alertDanger">
  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
  <strong>Warning!</strong> 请先登录，以避免数据丢失，对您造成的损失.
</div>
<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">柘城之声</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">唱响柘城</a></li>
      <li><a href="#">魅力柘城</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">更多 <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">春水河畔</a></li>
          <li><a href="#">千树林</a></li>
          <li><a href="#">柘城之声3</a></li>
          <li class="divider"></li>
          <li><a href="#">柘城之声4</a></li>
          <li class="divider"></li>
          <li><a href="#">柘城之声5</a></li>
        </ul>
      </li>
    </ul>
    <form class="navbar-form navbar-left" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="柘城名胜/更多信息">
      </div>
      <button type="submit" class="btn btn-success">搜索</button>
    </form>
    <ul class="nav navbar-nav navbar-right">
      <li>
		<button type="button" class="btn btn-primary navbar-btn">注册</button>
      </li>
      <li>&nbsp;&nbsp;</li>
      <li>
      	<button type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#loginModal">登录</button>
      </li>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="${basePath}static/images/index/p_big1.jpg" style="width:100%;" alt="..."></img>
      <div class="carousel-caption">
        test001...
      </div>
    </div>
    <div class="item">
      <img src="${basePath}static/images/index/p_big2.jpg" style="width:100%;" alt="..."></img>
      <div class="carousel-caption">
        test002...
      </div>
    </div>
    <div class="item">
      <img src="${basePath}static/images/index/p_big3.jpg" style="width:100%;" alt="..."></img>
      <div class="carousel-caption">
        test003...
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>

<div class="row">
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img data-src="holder.js/300x200" style="width:300px;height:200px;" src="${basePath}static/images/index/p1.jpg" alt="...">
      <div class="caption">
        <h3>独具匠心-《山村古镇》</h3>
        <p>传承古典精华，孕育了一代又一代匠人，民风淳朴。得天地之灵秀，修万物以慰亡灵。当地多为佛教徒，每逢初一、十五都要前往钟晨寺...</p>
        <p>
           <a href="#" class="btn btn-primary" role="button">更多</a> 
<!--            <a href="#" class="btn btn-default" role="button">Button</a> -->
        </p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img data-src="holder.js/300x200" style="width:300px;height:200px;" src="${basePath}static/images/index/p2.jpg" alt="...">
      <div class="caption">
        <h3>少女思情-《忆情林》</h3>
        <p>此地另一名胜地《忆情林》，此地多匠人，遂以匠士多为推崇。少女恋匠人，匠人多出行。少女多来此处，希望那远方的情人...</p>
		<p>
           <a href="#" class="btn btn-primary" role="button">更多</a> 
<!--            <a href="#" class="btn btn-default" role="button">Button</a> -->
        </p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img data-src="holder.js/300x200" style="width:300px;height:200px;" src="${basePath}static/images/index/p3.jpg" alt="...">
      <div class="caption">
        <h3>鹊桥圣地-《千树林》</h3>
        <p>本地男女谈情之地-千树林，千树林非千棵树，而为千种树，虽未有人数。但只多不少，林中多处古亭，以备游客观赏，亭下有小溪，一对对鱼儿在湖中嬉戏...</p>
		<p>
           <a href="#" class="btn btn-primary" role="button">更多</a> 
<!--            <a href="#" class="btn btn-default" role="button">Button</a> -->
        </p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-3">
    <div class="thumbnail">
      <img data-src="holder.js/300x200" style="width:300px;height:200px;" src="${basePath}static/images/index/p4.jpg" alt="...">
      <div class="caption">
        <h3>春水河畔-《西城名郡》</h3>
        <p>西城名郡位于城西，春水河东，可一览柘城八大景之一 春水河，这条河也是城区的分界线，景色宜人，西城名郡为城区最高楼，楼高三十一层...</p>
		<p>
           <a href="#" class="btn btn-primary" role="button">更多</a> 
<!--            <a href="#" class="btn btn-default" role="button">Button</a> -->
        </p>
      </div>
    </div>
  </div>
</div>

<!-- Section: contact -->
   <section id="contact" class="home-section text-center">
	<div class="heading-contact">
		<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-offset-2">
				
				<div class="section-heading">
				<div class="wow bounceInDown" data-wow-delay="0.4s">
				<h2>欢迎发送短信或者邮箱给我</h2>
				</div>
				<p class="wow lightSpeedIn" data-wow-delay="0.3s">告诉我你的想法和建议</p>
				</div>
				
			</div>
		</div>
		</div>
	</div>
	<div class="container">

   <div class="row">
       <div class="col-lg-8 col-md-offset-2">
           <div class="form-wrapper marginbot-50">
               <form id="contact-form" method="post" action="#">
               <div class="row">
   
                       <div class="form-group">
                           <label for="name">
                               您 的名字</label>
                           <input type="text" class="form-control" id="name" placeholder="姓名" required="required" />
                       </div>
                       <div class="form-group">
                           <label for="email">
                               您 的邮箱或者手机</label>
                               <input type="email" class="form-control" id="email" placeholder="邮箱  or 手机" required="required" />
                       </div>
                       <div class="form-group">
                           <label for="subject">
                               建议类型</label>
                           <select id="subject" name="subject" class="form-control" required="required">
                               <option value="na" selected="selected">选择:</option>
                               <option value="job">工作机会</option>
                               <option value="propose">网站建议</option>
                               <option value="cooperate">合作机会</option>
                               <option value="other">其它</option>
                           </select>
                       </div>
         
            
                       <div class="form-group">
                           <label for="name">
                               具体内容</label>
                           <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                               placeholder="内容"></textarea>
                       </div>
      
          
                       <button type="submit" class="btn btn-primary btn-block" id="btnContactUs">发送</button>

               </div>
               </form>
			
           </div>
		<div class="text-center">
				<p class="lead"><i class="fa fa-phone"></i> Call me +<a href="tel:13391531597">133 9153 1597</a></p>
		</div>
       </div>

   </div>	

	</div>
</section>
<!-- /Section: contact -->

<footer class="footer ">
  <div class="container">
    <div class="row footer-top">
      <div class="col-sm-6 col-lg-6">
        <h4>
          <img src="http://wenda.bootcss.com/static/css/default/logo/logo.png">
        </h4>
        <p>本网站所列开源项目的中文版文档全部由<a href="http://www.bootcss.com/" target="_blank">Bootstrap中文网</a>成员翻译整理，并全部遵循 <a href="http://creativecommons.org/licenses/by/3.0/" target="_blank">CC BY 3.0</a>协议发布。</p>
      </div>
      <div class="col-sm-6  col-lg-5 col-lg-offset-1">
        <div class="row about">
          <div class="col-xs-4">
            <h4>关于</h4>
            <ul class="list-unstyled">
              <li><a href="http://www.bootcss.com/about/" target="_blank">关于我们</a></li>
              <li><a href="http://www.bootcss.com/ad/" target="_blank">广告合作</a></li>
              <li><a href="http://www.bootcss.com/links/" target="_blank">友情链接</a></li>
            </ul>
          </div>
          <div class="col-xs-4">
            <h4>联系方式</h4>
            <ul class="list-unstyled">
              <li><a href="http://weibo.com/bootcss" title="Bootstrap中文网官方微博" target="_blank">新浪微博</a></li>
              <li><a href="mailto:admin@bootcss.com">电子邮件</a></li>
            </ul>
          </div>
          <div class="col-xs-4">
            <h4>旗下网站</h4>
            <ul class="list-unstyled">
              <li><a href="http://www.golaravel.com/" target="_blank">Laravel中文网</a></li>
              <li><a href="http://www.ghostchina.com/" target="_blank">Ghost中国</a></li>
            </ul>
          </div>
        </div>

      </div>
    </div>

    <div class="row footer-bottom">
      <ul class="list-inline text-center">
        <li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a></li><li>京公网安备11010802014853</li>
      </ul>
    </div>
  </div>
</footer>

<!-- 注册信息  start -->
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">登 陆</h4>
      </div>
      <div class="modal-body">
        <form id="signinForm" class="form-horizontal" role="form" method="post" action="${basePath}login/validate">
	        <div class="form-group">
	      	  <input type="email" name="userName" class="form-control" placeholder="Email address" required autofocus>
	        </div>
	        <div class="form-group">
	      	  <input type="password" name="userPass" class="form-control" placeholder="Password" required>
	        </div>
	        <div class="checkbox">
	          <label style="float:left;">
	            <input type="checkbox" value="remember-me">记住密码    
	          </label>
			  <a style="font-size:12px;float:right;" href="#" >忘记密码?</a>
	        </div>
	        <div class="form-group">
	        	<button class="btn btn-lg btn-primary btn-block" type="submit" id="signinSub">登    陆</button>
	     	</div>
	      </form>
      </div>
<!--       <div class="modal-footer"> -->
<!--         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
<!--         <button type="button" class="btn btn-primary">Save changes</button> -->
<!--       </div> -->
    </div>
  </div>
</div>

<!-- 注册信息  end -->


<%@include file="/WEB-INF/views/common/footer.jsp"%>
<script type="text/javascript">

$(document).ready(function() {
    $('#signinForm').bootstrapValidator({
//        live: 'disabled',
		message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                validators: {
                    emailAddress: {
//                         message: 'The input is not a valid email address'
                    }
                }
            },
            userPass: {
                validators: {
                    notEmpty: {
//                         message: 'The password is required and cannot be empty'
                    },
                    identical: {
                        field: 'confirmPassword',
//                         message: 'The password and its confirm are not the same'
                    },
                    different: {
                        field: 'username',
//                         message: 'The password cannot be the same as username'
                    }
                }
            }
        }
    });
 // Validate the form manually
    $('#signinSub').click(function() {
        $('#signinForm').bootstrapValidator('validate');
    });

//     $('#resetBtn').click(function() {
//         $('#signinForm').data('bootstrapValidator').resetForm(true);
//     });
});
    
</script>
</body>
</html>

