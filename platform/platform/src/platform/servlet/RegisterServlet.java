package platform.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import oracle.jdbc.util.Login;
import platform.dao.UserDao;
import sun.util.logging.resources.logging;

/**
 * 处理用户注册的servlet
 * @author hjm
 *
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(RegisterServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理中文的乱码
		response.setContentType("text/html;charset=utf-8");//响应
        request.setCharacterEncoding("utf-8");     //请求
        String name = request.getParameter("username"); //username是输入框对应的name                          
        String pwd =  request.getParameter("userpwd"); 
        log.info("注册用户！");
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", "3");
        map.put("username", name);
        map.put("userpwd", pwd);
        map.put("email", "122121@qq.com");
        try {
			UserDao.addUser(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.doPost(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		super.doGet(request, response);
	}

}
