<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录界面</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<script src="js/jquery-3.0.0.min.js" type="text/javascript" ></script>
		<script src="js/bootstrap.js" type="text/javascript" ></script>
		<script src="js/md5.js" type="text/javascript" ></script>
		<script src="js/jsp/login.js" type="text/javascript" ></script>
	</head>
	<body class="login_body">
		<div class="login_div">
			<div class="col-xs-12 center_title">登录</div>
			<form action="" class="login" method="post">
				<div class="nav">
					<div class="nav login_to_input">
						<div class="col-xs-4 input_title">
							用户名:
						</div>
						<div class="col-xs-5 " style="padding-right:0px;">
							<input class="input"  type="text" name="username" id="username" 
								placeholder="&nbsp;&nbsp;请输入用户名" data-toggle="popover" 
								data-content="用户名输入错误！" />
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;line-height:40px;">
							<span id = "name_span"></span>
						</div>
					</div>
					
					<div class="nav input_margin">
						<div class="col-xs-4 input_title">
							密&nbsp;&nbsp;&nbsp;码:
						</div>
						<div class="col-xs-5" style="padding-right:0px;">
							<input class="input" type="password" name="userpwd"  id="userpwd"  
							placeholder="&nbsp;&nbsp;请输入密码" autocomplete="off" 
							data-toggle="popover" title="Example popover"/>
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;line-height:40px;">
							<span id = "pwd_span"></span>
						</div>
					</div>
					
					<div class="nav input_margin">
						<div class="col-xs-4 input_title">
							验证码:
						</div>
						<div class="col-xs-3">
							<input class="input"  type="text" name="validate"  id="validate"  placeholder="&nbsp;&nbsp;请输入验证码" autocomplete="off"/>
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;">
							<!-- 验证码图片 -->
							<img id="imgObj" alt="验证码" 
							src="<%=request.getContextPath() %>/*.images" onclick="changeImg()"/>
						</div>
						<div class="col-xs-2" style="padding:0px;font-size: 13px;">
							<a style="float:left;line-height:40px; background: transparent;" onclick="changeImg()">下一张</a>
						</div>
						<div style="text-align: center;"> 
							<span id="validate_span" ></span>
						</div>
					</div>
				</div>
			</form>
			<div class="col-xs-12 button">
				<button class="login sub_btn" value="登录" id="login" name="login" onclick="login()">登录</button>
			</div>
			<div class="col-xs-12 tip">
				<button class="tip_button" onclick="toRegister();">没有账号?前往注册</button>					
			</div>
		</div>
	</body>
</html>