package platform.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * 定义对数据库的增、刪、改、查
 * @author hjm
 *
 */
public class JdbcCURD {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private Logger log = Logger.getLogger("");
 	
    //更新操作---创建、修改、删除表，添加、删除、修改元组以及查询sql语句
    public void update(String sql) {
        try {
            connection = JdbcUtils.getConnection();//获得连接
            statement = connection.createStatement();//用于执行静态SQL语句并返回它所生成结果的对象
            //可执行创建、修改、删除表，添加、删除、修改元组以及查询sql语句
            statement.execute(sql);
            log.info("执行更新操作！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResources(resultSet, statement, connection);
        }
    }
	    
    //查询操作
    public void Query(String sql) {
        try {
            connection = JdbcUtils.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            log.info("执行查询操作！");
//            while(resultSet.next()){
//                System.out.println("name:"+resultSet.getString("username"));
//            }
//            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseResources(resultSet, statement, connection);//释放资源
        }
    }
    
    //添加操作
    public void addElement(String sql) {
        update(sql);
    }
    
    //删除操作
    public void removeElement(String sql) {
        update(sql);
    }
	
    //创建一个表
    public void createTable(String sql){
        update(sql);
    }
    
    //删除一个表
    public void dropTable(String sql){
        update(sql);
    }

}

