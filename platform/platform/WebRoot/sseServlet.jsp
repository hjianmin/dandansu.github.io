<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!doctype html>
        <html>
          <head>
            <meta charset="UTF-8">
            <title>Basic SSE Example</title>
            <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
            <link rel="stylesheet" type="text/css" href="css/login.css" />
			<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
			<script src="js/jquery-3.0.0.min.js" type="text/javascript"></script>
			<script src="js/jquery-ui.js" type="text/javascript"></script>
			<script src="js/md5.js" type="text/javascript"></script>
			<script src="js/jsp/register.js" type="text/javascript"></script>
			<script type="text/javascript">
				function send(){
					var message = $("#message").val();
					
					$.ajax({
				        url: getContextPath() + "/SseServlet",
				        type:"post",
				        data:{
				        	message:message
				        	},
				        success:function(){
				        	console.log("123");
							 //创建EventSource对象，将要连接的URL作为它唯一的参数
				            var es = new EventSource("<%=request.getContextPath() %>/SseServlet");
				            	es.addEventListener("message", function(e){
				              document.getElementById("x").innerHTML += "\n" + e.data;//动态修改页面内容。
				              },false);
				        },
				        error:function(e){
				            alert("错误！！!");
				        }
				    });  
				}
			</script>
          </head>
          <body>
          		<input type="text" id="message" name="message"/>
          		<button class="sub_btn" id="message" onclick="send()">注册</button>
          
          
          
            <pre id="x">初始化...</pre><!--之所以用pre，没用div或p，是为了确保（包括换行的数据能够以它被接收时的格式呈现，而不会被修改或格式化。）-->
            <script>
	           
            </script>
          </body>
        </html>