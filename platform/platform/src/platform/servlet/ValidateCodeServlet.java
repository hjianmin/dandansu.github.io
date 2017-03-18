package platform.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.String;

import org.apache.tomcat.util.codec.binary.StringUtils;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import platform.util.ValidateCode;

/**
 * 图片验证码servlet
 * @author hjm
 *
 */
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		HttpSession session = request.getSession();
		
		ValidateCode vCode = new ValidateCode(120,40,5,50);
		session.setAttribute("code", vCode.getCode());
		vCode.write(response.getOutputStream());
		
		String code = request.getParameter("code");  
		String sessionCode = (String) session.getAttribute("code");  
		if (!sessionCode.equalsIgnoreCase(code)) {  //忽略验证码大小写  
			String message = "验证码不正确";
			request.setAttribute("message",message);
		} 
	}
/**
 * web.xml 添加servlet
	<servlet>
		<servlet-name>validateCodeServlet</servlet-name>
		<servlet-class>cn.dsna.util.images.ValidateCodeServlet</servlet-class>
	</servlet>	
	<servlet-mapping>
		<servlet-name>validateCodeServlet</servlet-name>
		<url-pattern>*.images</url-pattern>
	</servlet-mapping>

在地址栏输入XXX/dsna.images 测试
 */

}
