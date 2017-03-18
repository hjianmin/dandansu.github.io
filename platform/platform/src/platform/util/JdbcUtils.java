package platform.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class JdbcUtils {

    private static String driverName;
    private static String url;
    private static String user;
    private static String password;
    private static Log log = LogFactory.getLog(JdbcUtils.class);
    
    /*
     * 静态代码块，类初始化时加载数据库驱动
     */
    static {
        try {
            // 加载jdbc.properties配置文件
        	InputStream in = JdbcUtils.class.getResourceAsStream("/conf/jdbc.properties");
            Properties properties = new Properties();
            properties.load(in);

            // 获取驱动名称、url、用户名以及密码
            driverName = properties.getProperty("jdbc.driverClassName");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");

//           log.info("driverName:"+driverName+";user:"+user+";password:"+password);
            // 加载驱动
            Class.forName(driverName);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException{
    	getConnection();
    }
    
    /*
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);

    }

    /*
     * 释放资源
     */
    public static void releaseResources(ResultSet resultSet,
            Statement statement, Connection connection) {

        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement = null;
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    connection = null;
                }
            }
        }

    }

}