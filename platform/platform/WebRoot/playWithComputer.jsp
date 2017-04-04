<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>中国象棋游戏 - 人机对战</title>
<link href="css/zzsc.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="box" id="box">
		<div class="chess_left">
			<canvas id="chess">对不起，您的浏览器不支持HTML5，请升级浏览器至IE9、firefox或者谷歌浏览器！</canvas>
			<audio src="audio/click.wav" id="clickAudio" preload="auto"></audio>
			<!--<audio src="audio/check.wav" id="checkAudio" preload="auto"></audio>-->
			<audio src="audio/select.wav" id="selectAudio" preload="auto"></audio>
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
	</div>
	
	<script src="js/common.js"></script> 
	<script src="js/play.js"></script> 
	<script src="js/AI.js"></script> 
	<script src="js/bill.js"></script> 
	<script src="js/gambit.js"></script>
	
	<div style="text-align:center;clear:both">
	<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
	</div>
</body>
</html>