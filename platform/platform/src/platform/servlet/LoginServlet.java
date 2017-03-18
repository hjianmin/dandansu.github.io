package platform.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import platform.dao.UserDao;

/**
* 处理用户登录的servlet
* @author hjm
*
*/
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");     //请求
		//获取用户填写的登录用户名
		String username = request.getParameter("username");
		//获取用户填写的登录密码
		String password = request.getParameter("userpwd");
		Integer result;
		try {
			result = (Integer) UserDao.ifExitUser(username);
			if (result == 0 ) {
				System.out.println("用户不存在！");
			}else{
				System.out.println("用户存在！");
				//验证密码
				boolean flag = UserDao.verifyPwd(username,password);
				if (flag == true) {
					System.out.println("密码校验通过！");
				}else {
					System.out.println("密码输入错误！");
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}