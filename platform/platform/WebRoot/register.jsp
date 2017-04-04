<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>欢迎注册</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
		<script src="js/jquery-3.0.0.min.js" type="text/javascript"></script>
		<script src="js/jquery-ui.js" type="text/javascript"></script>
		<script src="js/md5.js" type="text/javascript"></script>
		<script src="js/jsp/register.js" type="text/javascript"></script>
	</head>
	
	<body class="login_body">
		<div class="login_div">
			<div class="col-xs-12 center_title">注册</div>
			<form class="register" action="<%=request.getContextPath() %>/servlet/RegisterServlet" method="post">
				<div class="nav">
					<div class="nav register_to_input">
						<div class="col-xs-4 input_title">
							用户名:
						</div>
						<div class="col-xs-5" style="padding-right:0px;">
							<input class="input" type="text" name="username" id="username" 
								value="" placeholder="&nbsp;&nbsp;请输入用户名/手机号" />
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;line-height:40px;">
							<span id = "name_span"></span>
						</div>
					</div>
					<div class="nav input_margin">
						<div class="col-xs-4 input_title" >
							邮&nbsp;&nbsp;&nbsp;箱:
						</div>
						<div class="col-xs-5" style="padding-right:0px;">
							<input class="input" type="email" name="email" id="email" 
								value="" placeholder="&nbsp;&nbsp;请输入邮箱"  />
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;line-height:40px;">
							<span id = "email_span"></span>
						</div>
					</div>
					<div class="nav input_margin">
						<div class="col-xs-4 input_title">
							密&nbsp;&nbsp;&nbsp;码:
						</div>
						<div class="col-xs-5" style="padding-right:0px;">
							<input class="input" type="password" name="pwd" id="pwd" 
								value="" placeholder="&nbsp;&nbsp;请输入密码" />
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;line-height:40px;">
							<span id = "pwd_span"></span>
						</div>
					</div>
					<div class="nav input_margin">
						<div class="col-xs-4 input_title">
							确认密码:
						</div>
						<div class="col-xs-5">
							<input class="input" type="password" name="confirmPwd" 
								id="confirmPwd" value="" placeholder="&nbsp;&nbsp;请输入确认密码" />
						</div>
						<div class="col-xs-3" style="float: left;padding:0px;line-height:40px;">
							<span id = "confirmPwd_span"></span>
						</div>
					</div>
				</div>
			</form>
			<div class="col-xs-12 button">
				<button class="sub_btn" id="register" onclick="register()">注册</button>
			</div>
			<div class="col-xs-12 tip">
				<button class="tip_button" onClick="toLogin()" >已有秘籍?返回登录</button>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	    
	</script>
</html>
