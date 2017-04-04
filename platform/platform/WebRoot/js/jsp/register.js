 function getContextPath() {
       var contextPath = document.location.pathname;
       var index = contextPath.substr(1).indexOf("/");
       contextPath = contextPath.substr(0, index + 1);
       delete index;
       return contextPath;
   }

 $(document).ready(function(){
		$("#username").focus(function(){
			 name_span.style.display = "none";
			 $("#name_span").empty();
		});
		$("#username").blur(function(){
			var name = $('#username').val();
			name_span.style.display = "block";
			if(name == ""){
				document.getElementById('name_span').innerHTML=
					 '<font style="color:red">*请输入用户名</font>';
				return;
			}
		});
		
		$("#email").focus(function(){
			 email_span.style.display = "none";
			 $("#email_span").empty();
		});
		$("#email").blur(function(){
			var email = $('#email').val();
			email_span.style.display = "block";
			if(email == ""){
				document.getElementById('email_span').innerHTML=
					 '<font style="color:red">*请输入邮箱</font>';
				return;
			}
		});
		
		$("#pwd").focus(function(){
			 pwd_span.style.display = "none";
			 $("#pwd_span").empty();
		});
		$("#pwd").blur(function(){
			var pwd = $('#pwd').val();
			pwd_span.style.display = "block";
			if(pwd == ""){
				document.getElementById('pwd_span').innerHTML=
					 '<font style="color:red">*请输入密码</font>';
				return;
			}
		});
		
		$("#confirmPwd").focus(function(){
			 pwd_span.style.display = "none";
			 $("#confirmPwd_span").empty();
		});
		$("#confirmPwd").blur(function(){
			var pwd = $('#pwd').val();
			var confirmPwd = $('#confirmPwd').val();
			confirmPwd_span.style.display = "block";
			if(pwd != confirmPwd){
				document.getElementById('confirmPwd_span').innerHTML=
					 '<font style="color:red">*密码不一致</font>';
				return;
			}
		});
	});
		
	function register(){
		var name = $('#username').val();
		var email = $('#email').val();
		var confirmPwd = $('#confirmPwd').val();
		if(name == "" || email == "" || confirmPwd == ""){
			alert("请完善资料填写！");
			return ;
		}
		
		$.ajax({
	        url: getContextPath() + "/servlet/RegisterServlet",
	        type:"post",
	        data:{
	        	username:name,
	        	userpwd:md5(confirmPwd),
	        	email:email
	        	},
	        success:function(response){
				alert(response);
	        },
	        error:function(e){
	            alert("错误！！!");
	        }
	    });  
	}
	function toLogin() {
		window.location.href = "login.jsp";
	}