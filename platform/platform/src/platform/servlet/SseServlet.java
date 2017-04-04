package platform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import platform.dao.ChessDao;

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

		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8"); // 请求
		response.setHeader("Charset", "utf-8");
		response.setCharacterEncoding("UTF-8");// 设置编码
		response.setContentType("text/event-stream");// 设置事件流
		// 获取用户填写的登录用户名
		String message = request.getParameter("message");
		session.setAttribute("message", message);
		try {
			message = ChessDao.getMessage("张三");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 获取最新时间并返回
		PrintWriter writer = response.getWriter();
		String string = new Date().toString();
		System.out.println(string + message);

		writer.write("data: " + string + message + "\n\n");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
