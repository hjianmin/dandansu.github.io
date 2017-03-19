package platform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import platform.util.ValidateCode;

/**
 * 图片验证码servlet
 * 
 * @author hjm
 *
 */
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ValidateCodeServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		HttpSession session = request.getSession();
		// 生成图片的width、height、个数、干扰数
		ValidateCode vCode = new ValidateCode(120, 35, 5, 50);
		session.setAttribute("code", vCode.getCode());// 将验证码存到session中
		vCode.write(response.getOutputStream());

		// String code = request.getParameter("code");
		String sessionCode = (String) session.getAttribute("code");
		log.info("生成的验证码：" + sessionCode);
	}
	/**
	 * web.xml 添加servlet <servlet>
	 * <servlet-name>validateCodeServlet</servlet-name>
	 * <servlet-class>cn.dsna.util.images.ValidateCodeServlet</servlet-class>
	 * </servlet> <servlet-mapping>
	 * <servlet-name>validateCodeServlet</servlet-name>
	 * <url-pattern>*.images</url-pattern> </servlet-mapping>
	 * 
	 * 在地址栏输入XXX/dsna.images 测试
	 */

}
