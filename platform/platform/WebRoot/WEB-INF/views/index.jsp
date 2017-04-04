<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="../images/title.ico">
	<title>中国象棋游戏首页</title>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/main.css" />
	<link rel="stylesheet" type="text/css" href="../css/common.css" />
	<script src="../js/jquery-3.0.0.min.js" type="text/javascript" ></script>
	<script src="../js/bootstrap.js" type="text/javascript" ></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var username = <%=session.getAttribute("user") %>;
			if(username == "null" || username == null){
				login.style.display = "block";
				stat.style.display = "none";
			}else{
				login.style.display = "none";
				stat.style.display = "block";
			}
		
		});
		
	</script>
</head>
<body >
	<!-- <header class="navbar navbar-inverse"> -->
	<header class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <span class="logo">中国象棋</span>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">首页  <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">排行榜 </a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
	          	aria-haspopup="true" aria-expanded="false">账号信息  <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">个人资料</a></li>
	            <li><a href="#">更新资料</a></li>
	            <li class="divider"></li>
	            <li><a href="#">退出</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	      	<li ><a id="stat" style="display:none"><%=session.getAttribute("user") %>欢迎你！</a></li>
	        <li ><a id="login" style="display:none">还没登录，请登录</a></li>
	      </ul>
	    </div>
	  </div>
	</header>
	<div class="wrap">
		<%-- <input value="<%=session.getAttribute("user") %>"/> --%>
		<!-- <div class="container">
			<div style="width:480px;height: 400px;margin: auto;padding: auto;">
				<div id="carousel-example-generic" class="carousel slide">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img src="../images/bg.jpg" />
						</div>
						<div class="item">
							<img src="../images/chess.jpg" />
							图片上要显示的文字
							<div class="carousel-caption">
								<h3>象棋</h3>
							</div>
						</div>
					</div>
					Controls
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div> -->
		<div class="row" style="heigth:600px">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-default">
				  <div class="panel-body">
				    <div class="col-md-4"  style="text-align:center;">
				   		<div class="col-md-12">
				    		<img class="img-rounded" alt="" src="../images/chess.jpg">
				    	</div>
				    	<div class="col-md-12" style="margin-top:40px;margin-bottom:20px">
				    		<button type="button" class="btn btn-info btn-lg" onclick="startGame();">进入游戏</button>
				    	</div>
				    </div>
				    <div class="col-md-8">
				    	<div class="col-md-12" style="font-size: 1.7em;margin-bottom:20px">中国象棋网页版小游戏</div>
				    	<div class="col-md-12" style="margin-bottom:20px;"><div style="color: #999;">分类：</div>棋牌小游戏</div>
				    	<div class="col-md-12" >
				    		<div style="color: #999;">介绍：
				    		</div>
				    		基于 HTML5 SSE 推送技术实现的网页版象棋游戏,在这里你可以大展手，
				    		有人  VS 人对战，也有人机对战，喜欢象棋的玩家不妨来尝试一下
				    	</div>
				    	<div class="col-md-12" style="margin-top:20px;">
				    		<div style="color: #999;">玩法：
				    		</div>
				    		通过鼠标的移动实现棋子的移动
				    	</div>
				    </div>
				    
				     <div id="game">
					  	<div class="col-md-12" style="text-align:center;">
					  		<button type="button" class="btn btn-info btn-lg" onclick="startGame();">人机对战</button>
					  	</div>
					  	<div class="col-md-12" style="text-align:center;margin-top:40px;">
					  		<button type="button" class="btn btn-info btn-lg" onclick="startGame();">人人对战</button>
					  	</div>
				  	</div>
				    
				    
				  </div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		
		
		
		
	</div>

		
	<footer class="footer_style">
		<a class ="a_style" href="" target="_blank" rel="nofollow">关于</a> |     
		<a class ="a_style" href="" target="_blank" rel="nofollow">帮助</a> |     
		<a class ="a_style" href="" target="_blank" rel="nofollow">意见反馈</a> |     
		<a class ="a_style" href="" target="_blank" rel="nofollow">Copyright © 2017  适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</a>
	</footer> 
	<!--设定时间间隔，通过JavaScript，这样做相对于css属性设定而言，可以自启动，无需人为进行干预-->
	<script>
		$(".carousel").carousel({
		interval: 4000
		})
		
		
		function startGame(){
			alert("132");
		
		}
	</script>
</body>
</html>