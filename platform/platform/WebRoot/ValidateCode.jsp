<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成图片验证码</title>
<script src="js/jquery-3.0.0.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="form-group  col-lg-6">
		<form>
		    <label for="id" class="col-sm-4 control-label">
		        验证码:
		    </label>
		    <div class="col-sm-8">
		        <input type="text" id="code" name="code" class="form-control" style="width:250px;"/>
		        <img id="imgObj" alt="验证码" src="<%=request.getContextPath() %>/*.images" onclick="changeImg()"/>
		        <a href="#" onclick="changeImg()">换一张</a>
		    </div>
		    <div>
		    	<input type="submit" class="sub_btn" value="登录" id="login" />
		    </div>
	   </form>
	</div>

	<script type="text/javascript">
	    // 刷新图片--添加随机数防止缓存
	    function changeImg() {
		    $('#imgObj').on('closed.bs.alert', function () {
		    	var url = "<%=request.getContextPath() %>"+"/imgurl.images?"+Math.random();
	    		var imgSrc = $("#imgObj");  
	       		document.getElementById("imgObj").src = url;
			})
	    }
	</script>
</body>
</html>