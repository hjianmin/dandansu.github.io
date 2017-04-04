<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>中国象棋游戏 - 人机对战</title>
	<link href="../css/zzsc.css" type="text/css" rel="stylesheet" />
	<link href="../css/common.css" type="text/css" rel="stylesheet" />
	<script src="../js/bootstrap.js" type="text/javascript" ></script>
	<style type="text/css">
		html,body{height:100%}
		.footer {margin-top:-30px;margin-bottom:0px;height:30px;background-color:#eee;}
		.wrap{min-height:100%}
		.main{padding-bottom:30px;overflow:hidden;}
	</style>
</head>
<body>
	<div class="wrap">
		<div class="box" id="box">
			<div class="chess_left">
				<canvas id="chess">对不起，您的浏览器不支持HTML5，请升级浏览器至IE9、firefox或者谷歌浏览器！</canvas>
				<audio src="../audio/click.wav" id="clickAudio" preload="auto"></audio>
				<!--<audio src="audio/check.wav" id="checkAudio" preload="auto"></audio>-->
				<audio src="../audio/select.wav" id="selectAudio" preload="auto"></audio>
				<div>
					<div class="bn_box" id="bnBox">
						<input type="button" name="offensivePlay" id="tyroPlay" value="新手水平" />
						<input type="button" name="offensivePlay" id="middlePlay" value="中级水平" />
		                <input type="button" name="offensivePlay" id="superPlay" value="大师水平" />
						<!--
					<input type="button" name="offensivePlay" id="offensivePlay" value="先手开始" />
					<input type="button" name="defensivePlay" id="defensivePlay" value="后手开始" />
					-->
						<input type="button" name="regret" id="regretBn" value="悔棋" />
						<input type="button" name="billBn" id="billBn" value="棋谱"  />
						<input type="button" name="stypeBn" id="stypeBn" value="换肤" />
					</div>
				</div>
			</div>
			<div class="chess_right" id="chessRight">
				<select name="billList" id="billList">
				</select>
				<ol id="billBox" class="bill_box">
				</ol>
			</div>
			<div id="moveInfo" class="move_info"> </div>
			<div class="move_info">聊天信息</div>
		</div>
		
		<script src="../js/chess/common.js"></script> 
		<script src="../js/chess/play.js"></script> 
		<script src="../js/chess/AI.js"></script> 
		<script src="../js/chess/bill.js"></script> 
		<script src="../js/chess/gambit.js"></script>
		
		<div style="text-align:center;clear:both">
		<p></p>
		
		</div>
	</div>
	<!-- <div class="col-xs-12 footer">
		<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,
		strength:15)" width="80%" color=#987cb9 SIZE=1>
		<div class="col-xs-1">1</div>
		<div class="col-xs-10">1</div>
		<div class="col-xs-1">1</div>
		<div style="width:80%;align:center"><span style="align:center" >456</span></div>
		这里是页脚
	</div> -->
	<footer class="footer_style">
		<a class ="a_style" href="" target="_blank" rel="nofollow">关于</a> |     
		<a class ="a_style" href="" target="_blank" rel="nofollow">帮助</a> |     
		<a class ="a_style" href="" target="_blank" rel="nofollow">意见反馈</a> |     
		<a class ="a_style" href="" target="_blank" rel="nofollow">Copyright © 2017  适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</a>
	</footer> 
</body>
</html>