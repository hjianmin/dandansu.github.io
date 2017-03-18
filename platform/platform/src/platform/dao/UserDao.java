package platform.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import platform.util.JdbcCURD;
import platform.util.JdbcHelper;
import platform.util.StringExchange;

/**
 * 用户注册时存储用户信息
 * @author hjm
 *
 */
public class UserDao {
	JdbcCURD curd=new JdbcCURD();
    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {

    	JdbcCURD curd=new JdbcCURD();
        String queryString = "select username from t_user where id = '1'";
        curd.Query(queryString);
        String addString = "insert into t_user  (id,username,userpwd,email,birthday) values (2,2,2,2,sysdate)";
        curd.addElement(addString);
        Map<Object, Object> map = new HashMap<>();
        map.put("id", "3");
        map.put("username", "张三");
        map.put("userpwd", "123456");
        map.put("email", "1134994815@qq.com");
        
        addUser(map);
    }
    
    public void queryUser(String string){
    	
    }
    
    public static void addUser(Map<Object, Object> map) throws SQLException {
    	String id = map.get("id").toString();
		String name = map.get("username").toString();
		String pwd = map.get("userpwd").toString();
		String email = map.get("email").toString();
		String sql = " insert into t_user "
					+ "(id,username,userpwd,email) "
					+ "values (?,?,?,?)";
		JdbcHelper.update(sql,id,name,pwd,email);
    }

	public static Object ifExitUser(String username) 
			throws SQLException {
		Integer count = 0;
		String query = "select * from t_user where username=?";
		Object result = JdbcHelper.querySingle(query, username);
		if (result != null) {
			count = Integer.valueOf(result.toString());
		}
		return count;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean verifyPwd(String username, String password) 
			throws SQLException {
		Boolean flag = false;
		String pwd;
		String sql = "select * from t_user where username=?";
		List result = JdbcHelper.query(sql, username);
		if (result !=null && result.size()>0) {
			Map map = StringExchange.exChangeMap((Map) result.get(0));
			pwd = map.get("userpwd").toString();
			if(pwd.equals(password)){
				flag=true;
			}else{
				return flag;
			}
		}
		return flag;
	}
	
    
}
