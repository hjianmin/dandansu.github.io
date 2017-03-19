<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!doctype html>
        <html>
          <head>
            <meta charset="UTF-8">
            <title>Basic SSE Example</title>
          </head>
          <body>
            <pre id="x">初始化...</pre><!--之所以用pre，没用div或p，是为了确保（包括换行的数据能够以它被接收时的格式呈现，而不会被修改或格式化。）-->
            <script>
            var es = new EventSource("<%=request.getContextPath() %>/SseServlet");//创建EventSource对象，将要连接的URL作为它唯一的参数。这里是连接到basic_sse.php
            es.addEventListener("message", function(e){
              document.getElementById("x").innerHTML += "\n" + e.data;//运态修改页面内容。
              },false);
            </script>。
          </body>
        </html>