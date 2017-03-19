package platform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSEEchoServlet
 */
@WebServlet("/SSEEchoServlet")
public class SseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/event-stream");// 设置事件流
		response.setCharacterEncoding("UTF-8");// 设置编码
		// 获取最新时间并返回
		PrintWriter writer = response.getWriter();
		String string = new Date().toString();
		System.out.println(string);
		// send SSE
		writer.write("data: " + string + "\n\n");
		try { // 设置间隔时间
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
