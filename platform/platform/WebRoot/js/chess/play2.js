

var play2 = play2||{};

play2.init = function (){
	
	play2.my				=	1;				//玩家方
	play2.map 			=	com.arr2Clone (com.initMap);		//初始化棋盘
	play2.nowManKey		=	false;			//现在要操作的棋子
	play2.pace 			=	[];				//记录每一步
	play2.isplay2 		=	true ;			//是否能走棋
	play2.mans 			=	com.mans;
	play2.bylaw 			= 	com.bylaw;
	play2.show 			= 	com.show;
	play2.showPane 		= 	com.showPane;
	play2.isOffensive	=	true;			//是否先手
	play2.depth			=	play2.depth || 2;				//搜索深度
	
	play2.isFoul			=	false;	//是否犯规长将
	
	
	
	com.pane.isShow		=	 false;			//隐藏方块
	
	//初始化棋子
	for (var i=0; i<play2.map.length; i++){
		for (var n=0; n<play2.map[i].length; n++){
			var key = play2.map[i][n];
			if (key){
				com.mans[key].x=n;
				com.mans[key].y=i;
				com.mans[key].isShow = true;
			}
		}
	}
	play2.show();
	
	//绑定点击事件
	com.canvas.addEventListener("click",play2.clickCanvas)
	//clearInterval(play2.timer);
	//com.get("autoplay2").addEventListener("click", function(e) {
		//clearInterval(play2.timer);
		//play2.timer = setInterval("play2.AIplay2()",1000);
	//	play2.AIplay2()
	//})
	/*
	com.get("offensiveplay2").addEventListener("click", function(e) {
		play2.isOffensive=true;
		play2.isplay2=true ;	
		com.get("chessRight").style.display2 = "none";
		play2.init();
	})
	
	com.get("defensiveplay2").addEventListener("click", function(e) {
		play2.isOffensive=false;
		play2.isplay2=true ;	
		com.get("chessRight").style.display2 = "none";
		play2.init();
	})
	*/
	
	
	com.get("regretBn").addEventListener("click", function(e) {
		play2.regret();
	})
	
	/*
	var initTime = new Date().getTime();
	for (var i=0; i<=100000; i++){
		
		var h=""
		var h=play2.map.join();
		//for (var n in play2.mans){
		//	if (play2.mans[n].show) h+=play2.mans[n].key+play2.mans[n].x+play2.mans[n].y
		//}
	}
	var nowTime= new Date().getTime();
	z([h,nowTime-initTime])
	*/
	
}



//悔棋
play2.regret = function (){
	var map  = com.arr2Clone(com.initMap);
	//初始化所有棋子
	for (var i=0; i<map.length; i++){
		for (var n=0; n<map[i].length; n++){
			var key = map[i][n];
			if (key){
				com.mans[key].x=n;
				com.mans[key].y=i;
				com.mans[key].isShow = true;
			}
		}
	}
	var pace= play2.pace;
	pace.pop();
	pace.pop();
	
	for (var i=0; i<pace.length; i++){
		var p= pace[i].split("")
		var x = parseInt(p[0], 10);
		var y = parseInt(p[1], 10);
		var newX = parseInt(p[2], 10);
		var newY = parseInt(p[3], 10);
		var key=map[y][x];
		//try{
	 
		var cMan=map[newY][newX];
		if (cMan) com.mans[map[newY][newX]].isShow = false;
		com.mans[key].x = newX;
		com.mans[key].y = newY;
		map[newY][newX] = key;
		delete map[y][x];
		if (i==pace.length-1){
			com.showPane(newX ,newY,x,y)	
		}
		//} catch (e){
		//	com.show()
		//	z([key,p,pace,map])
			
		//	}
	}
	play2.map = map;
	play2.my=1;
	play2.isplay2=true;
	com.show();
}



//点击棋盘事件
play2.clickCanvas = function (e){
	if (!play2.isplay2) return false;
	var key = play2.getClickMan(e);
	var point = play2.getClickPoint(e);
	
	var x = point.x;
	var y = point.y;
	
	if (key){
		play2.clickMan(key,x,y);	
	}else {
		play2.clickPoint(x,y);	
	}
	play2.isFoul = play2.checkFoul();//检测是不是长将
}

//点击棋子，两种情况，选中或者吃子
play2.clickMan = function (key,x,y){
	var man = com.mans[key];
	//吃子
	if (play2.nowManKey&&play2.nowManKey != key && man.my != com.mans[play2.nowManKey ].my){
		//man为被吃掉的棋子
		if (play2.indexOfPs(com.mans[play2.nowManKey].ps,[x,y])){
			man.isShow = false;
			var pace=com.mans[play2.nowManKey].x+""+com.mans[play2.nowManKey].y
			//z(bill.createMove(play2.map,man.x,man.y,x,y))
			delete play2.map[com.mans[play2.nowManKey].y][com.mans[play2.nowManKey].x];
			play2.map[y][x] = play2.nowManKey;
			com.showPane(com.mans[play2.nowManKey].x ,com.mans[play2.nowManKey].y,x,y)
			com.mans[play2.nowManKey].x = x;
			com.mans[play2.nowManKey].y = y;
			com.mans[play2.nowManKey].alpha = 1
			
			play2.pace.push(pace+x+y);
			play2.nowManKey = false;
			com.pane.isShow = false;
			com.dot.dots = [];
			com.show()
			com.get("clickAudio").play2();
			setTimeout("play2.AIplay2()",500);
			if (key == "j0") play2.showWin (-1);
			if (key == "J0") play2.showWin (1);
		}
	// 选中棋子
	}else{
		if (man.my===1){
			if (com.mans[play2.nowManKey]) com.mans[play2.nowManKey].alpha = 1 ;
			man.alpha = 0.6;
			com.pane.isShow = false;
			play2.nowManKey = key;
			com.mans[key].ps = com.mans[key].bl(); //获得所有能着点
			com.dot.dots = com.mans[key].ps
			com.show();
			//com.get("selectAudio").start(0);
			com.get("selectAudio").play2();
		}
	}
}

//点击着点
play2.clickPoint = function (x,y){
	var key=play2.nowManKey;
	var man=com.mans[key];
	if (play2.nowManKey){
		if (play2.indexOfPs(com.mans[key].ps,[x,y])){
			var pace=man.x+""+man.y
			//z(bill.createMove(play2.map,man.x,man.y,x,y))
			delete play2.map[man.y][man.x];
			play2.map[y][x] = key;
			com.showPane(man.x ,man.y,x,y)
			man.x = x;
			man.y = y;
			man.alpha = 1;
			play2.pace.push(pace+x+y);
			play2.nowManKey = false;
			com.dot.dots = [];
			com.show();
			com.get("clickAudio").play2();
			setTimeout("play2.AIplay2()",500);
		}else{
			//alert("不能这么走哦！")	
		}
	}
	
}

//Ai自动走棋
play2.AIplay2 = function (){
	//return
	play2.my = -1 ;
	var pace=AI.init(play2.pace.join(""))
	if (!pace) {
		play2.showWin (1);
		return ;
	}
	play2.pace.push(pace.join(""));
	var key=play2.map[pace[1]][pace[0]]
		play2.nowManKey = key;
	
	var key=play2.map[pace[3]][pace[2]];
	if (key){
		play2.AIclickMan(key,pace[2],pace[3]);	
	}else {
		play2.AIclickPoint(pace[2],pace[3]);	
	}
	com.get("clickAudio").play2();
	
	
}

//检查是否长将
play2.checkFoul = function(){
	var p=play2.pace;
	var len=parseInt(p.length,10);
	if (len>11&&p[len-1] == p[len-5] &&p[len-5] == p[len-9]){
		return p[len-4].split("");
	}
	return false;
}

play2.indexOfPs = function (ps,xy){
	for (var i=0; i<ps.length; i++){
		if (ps[i][0]==xy[0]&&ps[i][1]==xy[1]) return true;
	}
	return false;
	
}

//获得点击的着点
play2.getClickPoint = function (e){
	var domXY = com.getDomXY(com.canvas);
	var x=Math.round((e.pageX-domXY.x-com.pointStartX-20)/com.spaceX)
	var y=Math.round((e.pageY-domXY.y-com.pointStartY-20)/com.spaceY)
	return {"x":x,"y":y}
}

//获得棋子
play2.getClickMan = function (e){
	var clickXY=play2.getClickPoint(e);
	var x=clickXY.x;
	var y=clickXY.y;
	if (x < 0 || x>8 || y < 0 || y > 9) return false;
	return (play2.map[y][x] && play2.map[y][x]!="0") ? play2.map[y][x] : false;
}

play2.showWin = function (my){
	play2.isplay2 = false;
	if (my===1){
		alert("恭喜你，你赢了！");
	}else{
		alert("很遗憾，你输了！");
	}
}

