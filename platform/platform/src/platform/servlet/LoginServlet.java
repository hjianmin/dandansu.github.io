package platform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import platform.dao.UserDao;

/**
 * 处理用户登录的servlet
 * 
 * @author hjm
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(LoginServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8"); // 请求
		response.setHeader("Charset", "utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取用户填写的登录用户名
		String username = request.getParameter("username");
		// 获取用户填写的登录密码
		String password = request.getParameter("userpwd");
		// 获取用户填写的验证码
		String code = request.getParameter("code");
		// 获取生成存到session的验证码
		String sessionCode = (String) session.getAttribute("code");
		String message = "";
		if (sessionCode.equalsIgnoreCase(code)) {
			log.info("验证码填写正确！");
			Integer result;
			try {
				result = (Integer) UserDao.ifExitUser(username);
				if (result == 0) {
					System.out.println("用户不存在！");
					message = "用户不存在！";
				} else {
					System.out.println("用户存在！");
					// 验证密码
					boolean flag = UserDao.verifyPwd(username, password);
					if (flag == true) {
						System.out.println("密码校验通过！");
					} else {
						message = "密码输入错误！";
					}
				}
				request.setAttribute("message", message);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			message = "验证码填写错误！";
			request.setAttribute("message", message);
		}
		PrintWriter out = response.getWriter();
		out.print(message);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}