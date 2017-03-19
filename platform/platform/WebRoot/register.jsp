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
		<script src="js/jquery-3.0.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery-ui.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/jquery-ui.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$('#register').click(function() {
				var name_r_state = $('#name_r');
				var psd_r_state = $('#psd_r');
				var affirm_psd_state = $('#affirm_psd');
				var name_r = $('#name_r').val();
				var psd_r = $('#psd_r').val();
				var affirm_psd = $('#affirm_psd').val();
				if (name_r == '') {
					name_r_state.parent().next().next().css("display", "block");
					return false;
				} else if (psd_r == '') {
					psd_r_state.parent().next().next().css("display", "block");
					return false;
				} else if (affirm_psd == '') {
					affirm_psd_state.parent().next().next().css("display", "block");
					return false;
				} else if (psd_r != affirm_psd) {
					return false;
				} else {
					$('.register').submit();
				}
			});
			function toLogin() {
				window.location.href = "login.jsp";
			}
		</script>
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
						<div class="col-xs-6">
							<input class="input" type="text" name="name_r" id="name_r" value="" placeholder="&nbsp;&nbsp;请输入用户名/手机号" onBlur="javascript:ok_or_errorByRegister(this)" />
						</div>
					</div>
					<div class="nav input_margin">
						<div class="col-xs-4 input_title" >
							邮&nbsp;&nbsp;&nbsp;箱:
						</div>
						<div class="col-xs-6">
							<input class="input" type="email" name="emailName" id="email" value="" 
								placeholder="&nbsp;&nbsp;请输入邮箱"  />
						</div>
					</div>
					<div class="nav input_margin">
						<div class="col-xs-4 input_title">
							密&nbsp;&nbsp;&nbsp;码:
						</div>
						<div class="col-xs-6">
							<input class="input" type="password" name="pwd" id="r_pwd" value="" placeholder="&nbsp;&nbsp;请输入密码" onBlur="javascript:ok_or_errorByRegister(this)" />
						</div>
					</div>
					<div class="nav input_margin">
						<div class="col-xs-4 input_title">
							确认密码:
						</div>
						<div class="col-xs-6">
							<input class="input" type="password" name="confirmPwd" id="affirm_psd" value="" placeholder="&nbsp;&nbsp;请输入确认密码" onBlur="javascript:ok_or_errorByRegister(this)" />
						</div>
					</div>
					<div class="col-xs-12 button">
						<input type="submit" class="sub_btn" value="注册" id="register" />
					</div>
				</div>
			</form>
			<div class="col-xs-12 tip">
				<button class="tip_button" onClick="toLogin()" style="">已有秘籍?返回登录</button>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	    
	</script>
</html>
