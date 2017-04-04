package platform.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import platform.util.JdbcHelper;
import platform.util.StringExchange;

/**
 * 用户注册时存储用户信息
 * 
 * @author hjm
 *
 */
public class UserDao {

	/**
	 * 添加用户
	 * 
	 * @param map
	 * @throws SQLException
	 */
	public static void addUser(Map<Object, Object> map) throws SQLException {

		String name = map.get("username").toString();
		String pwd = map.get("userpwd").toString();
		String email = map.get("email").toString();
		String sql = " insert into t_user "
				+ "(user_name,user_pwd,user_email) values (?,?,?)";
		JdbcHelper.update(sql, name, pwd, email);
	}

	/**
	 * 检查用户是否存在
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public static Object ifExitUser(String username) throws SQLException {
		Integer count = 0;
		String query = "select * from t_user where user_name=?";
		Object result = JdbcHelper.querySingle(query, username);
		if (result != null) {
			count = Integer.valueOf(result.toString());
		}
		return count;
	}

	/**
	 * 密码验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean verifyPwd(String username, String password)
			throws SQLException {
		Boolean flag = false;
		String pwd;
		String sql = "select * from t_user where user_name = ?";
		List result = JdbcHelper.query(sql, username);
		if (result != null && result.size() > 0) {
			Map map = StringExchange.exChangeMap((Map) result.get(0));
			pwd = map.get("user_pwd").toString();
			if (pwd.equals(password)) {
				flag = true;
			} else {
				return flag;
			}
		}
		return flag;
	}

}
