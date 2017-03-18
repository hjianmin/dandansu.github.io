package platform.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
   
/** 
 * 数据库访问帮助类 
 * @author hjm 
 * 
 */  
public class JdbcHelper {  
   
    private static Connection conn = null;  
    private static PreparedStatement preparedStatement = null;  
    private static CallableStatement callableStatement = null;  
    private static Statement statement = null;
   
    /** 
     * 用于查询，返回结果集 
     *  
     * @param sql语句  
     * @return 结果集 
     * @throws SQLException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List query(String sql) throws SQLException {  
   
        ResultSet rs = null;  
        try {  
            getPreparedStatement(sql);  
            rs = preparedStatement.executeQuery();  
   
            return ResultToListMap(rs);  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
   
    }  
   
    /** 
     * 用于带参数的查询，返回结果集 
     *  
     * @param sql语句 
     * @param paramters 参数集合 
     * @return 结果集 
     * @throws SQLException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List query(String sql, Object... paramters)  
            throws SQLException {  
   
        ResultSet rs = null;  
        try {  
            getPreparedStatement(sql);  
   
            for (int i = 0; i < paramters.length; i++) {  
                preparedStatement.setObject(i + 1, paramters[i]);  
            }  
            rs = preparedStatement.executeQuery();  
            return ResultToListMap(rs);  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
    }  
   
    /** 
     * 不带参数返回单个结果的值，如count\min\max等等 
     *  
     * @param sql语句  
     * @return 结果集 
     * @throws SQLException 
     */  
    public static Object querySingle(String sql) throws SQLException {  
        Object result = null;  
        ResultSet rs = null;  
        try {  
            getPreparedStatement(sql);  
            rs = preparedStatement.executeQuery();  
            if (rs.next()) {  
                result = rs.getObject(1);  
            }  
            return result;  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
   
    }  
   
    /** 
     * 带参数返回单个结果值，如count\min\max等 
     *  
     * @param  sql语句  
     * @param paramters 参数列表
     * @return 结果 
     * @throws SQLException 
     */  
    public static Object querySingle(String sql, Object... paramters)  
            throws SQLException {  
        Object result = null;  
        ResultSet rs = null;  
        try {  
            getPreparedStatement(sql);  
   
            for (int i = 0; i < paramters.length; i++) {  
                preparedStatement.setObject(i + 1, paramters[i]);  
            }  
            rs = preparedStatement.executeQuery();  
            if (rs.next()) {  
                result = rs.getObject(1);  
            }  
            return result;  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
    }  
   
    /** 
     * 用于增、删、改 
     * @param sql语句
     * @return 影响行数 
     * @throws SQLException 
     */  
    public static int update(String sql) throws SQLException {  
   
        try {  
            getPreparedStatement(sql);  
   
            return preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free();  
        }  
    }  
   
    /** 
     * 用于增、删、改（带参数） 
     * @param sql语句  
     * @param paramters 参数
     * @return 影响行数 
     * @throws SQLException 
     */  
    public static int update(String sql, Object... paramters)  
            throws SQLException {  
        try {  
            getPreparedStatement(sql);  
   
            for (int i = 0; i < paramters.length; i++) {  
                preparedStatement.setObject(i + 1, paramters[i]);  
            }  
            return preparedStatement.executeUpdate();  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free();  
        }  
    }  
   
    /** 
     * 插入值后返回主键值 
     * @param 插入sql语句 
     * @return 返回结果 
     * @throws Exception 
     */  
    public static Object insertWithReturnPrimeKey(String sql)  
            throws SQLException {  
        ResultSet rs = null;  
        Object result = null;  
        try {  
            conn = JdbcUtils.getConnection();  
            preparedStatement = conn.prepareStatement(sql,  
                    PreparedStatement.RETURN_GENERATED_KEYS);  
            preparedStatement.execute();  
            rs = preparedStatement.getGeneratedKeys();  
            if (rs.next()) {  
                result = rs.getObject(1);  
            }  
            return result;  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        }  
    }  
   
    /** 
     * 插入值后返回主键值 
     * @param 插入sql语句 
     * @param paramters 参数列表
     * @return 返回结果 
     * @throws SQLException 
     */  
    public static Object insertWithReturnPrimeKey(String sql,  
            Object... paramters) throws SQLException {  
        ResultSet rs = null;  
        Object result = null;  
        try {  
            conn = JdbcUtils.getConnection();  
            preparedStatement = conn.prepareStatement(sql,  
                    PreparedStatement.RETURN_GENERATED_KEYS);  
            for (int i = 0; i < paramters.length; i++) {  
                preparedStatement.setObject(i + 1, paramters[i]);  
            }  
            preparedStatement.execute();  
            rs = preparedStatement.getGeneratedKeys();  
            if (rs.next()) {  
                result = rs.getObject(1);  
            }  
            return result;  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        }  
   
    }  
   
    /** 
     * 调用存储过程执行查询 
     * @param procedureSql 存储过程
     * @return 
     * @throws SQLException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List storedQuery(String procedureSql) throws SQLException {  
        ResultSet rs = null;  
        try {  
            getCallableStatement(procedureSql);  
            rs = callableStatement.executeQuery();  
            return ResultToListMap(rs);  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
    }  
   
    /** 
     * 调用存储过程（带参数）,执行查询 
     *  
     * @param procedureSql 存储过程
     * @param paramters 参数表
     * @return 
     * @throws SQLException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List storedQuery(String procedureSql, Object... paramters)  
            throws SQLException {  
        ResultSet rs = null;  
        try {  
            getCallableStatement(procedureSql);  
   
            for (int i = 0; i < paramters.length; i++) {  
                callableStatement.setObject(i + 1, paramters[i]);  
            }  
            rs = callableStatement.executeQuery();  
            return ResultToListMap(rs);  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
    }  
   
    /** 
     * 调用存储过程，查询单个值 
     * @param procedureSql 
     * @return 
     * @throws SQLException 
     */  
    public static Object storedQuerySingle(String procedureSql)  
            throws SQLException {  
        Object result = null;  
        ResultSet rs = null;  
        try {  
            getCallableStatement(procedureSql);  
            rs = callableStatement.executeQuery();  
            while (rs.next()) {  
                result = rs.getObject(1);  
            }  
            return result;  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
    }  
   
    /** 
     * 调用存储过程(带参数)，查询单个值 
     *  
     * @param procedureSql 
     * @param parameters 
     * @return 
     * @throws SQLException 
     */  
    public static Object storedQuerySingle(String procedureSql,  
            Object... paramters) throws SQLException {  
        Object result = null;  
        ResultSet rs = null;  
        try {  
            getCallableStatement(procedureSql);  
   
            for (int i = 0; i < paramters.length; i++) {  
                callableStatement.setObject(i + 1, paramters[i]);  
            }  
            rs = callableStatement.executeQuery();  
            while (rs.next()) {  
                result = rs.getObject(1);  
            }  
            return result;  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free(rs);  
        }  
    }  
   
    public static Object callableWithParamters(String procedureSql)  
            throws SQLException {  
        try {  
            getCallableStatement(procedureSql);  
            callableStatement.registerOutParameter(0, Types.OTHER);  
            callableStatement.execute();  
            return callableStatement.getObject(0);  
   
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free();  
        }  
   
    }  
   
    /** 
     * 调用存储过程，执行增删改 
     * @param procedureSql 存储过程
     * @return 影响行数 
     * @throws SQLException 
     */  
    public static int storedUpdate(String procedureSql) throws SQLException {  
        try {  
            getCallableStatement(procedureSql);  
            return callableStatement.executeUpdate();  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free();  
        }  
    }  
   
    /** 
     * 调用存储过程（带参数），执行增删改 
     * @param procedureSql 
     *            存储过程 
     * @param parameters 
     * @return 影响行数 
     * @throws SQLException 
     */  
    public static int storedUpdate(String procedureSql, Object... parameters)  
            throws SQLException {  
        try {  
            getCallableStatement(procedureSql);  
            for (int i = 0; i < parameters.length; i++) {  
                callableStatement.setObject(i + 1, parameters[i]);  
            }  
            return callableStatement.executeUpdate();  
        } catch (SQLException e) {  
            throw new SQLException(e);  
        } finally {  
            free();  
        }  
    }  
   
    /** 
     * 批量更新数据 
     *  
     * @param sqlList 
     *            一组sql 
     * @return 
     */  
    public static int[] batchUpdate(List<String> sqlList) {  
   
        int[] result = new int[] {};  
        try {  
            conn = JdbcUtils.getConnection();  
            conn.setAutoCommit(false);  
            statement = conn.createStatement();  
            for (String sql : sqlList) {  
            	statement.addBatch(sql);  
            }  
            result = statement.executeBatch();  
            conn.commit();  
        } catch (SQLException e) {  
            try {  
                conn.rollback();  
            } catch (SQLException e1) {  
                // TODO Auto-generated catch block  
                throw new ExceptionInInitializerError(e1);  
            }  
            throw new ExceptionInInitializerError(e);  
        } finally {  
            free(null, statement);  
        }  
        return result;  
    }  
   
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    private static List ResultToListMap(ResultSet rs) throws SQLException {  
        List list = new ArrayList();  
        while (rs.next()) {  
            ResultSetMetaData md = rs.getMetaData();  
            Map map = new HashMap();  
            for (int i = 1; i < md.getColumnCount(); i++) {  
                map.put(md.getColumnLabel(i), rs.getObject(i));  
            }  
            list.add(map);  
        }  
        return list;  
    }  
   
    /** 
     * 获取PreparedStatement 
     *  
     * @param sql 
     * @throws SQLException 
     */  
    private static void getPreparedStatement(String sql) throws SQLException {  
        conn = JdbcUtils.getConnection();  
        preparedStatement = conn.prepareStatement(sql);  
    }  
   
    /** 
     * 获取CallableStatement 
     *  
     * @param procedureSql 
     * @throws SQLException 
     */  
    private static void getCallableStatement(String procedureSql)  
            throws SQLException {  
        conn = JdbcUtils.getConnection();  
        callableStatement = conn.prepareCall(procedureSql);  
    }  
   
    /** 
     * 释放资源 
     *  
     * @param rs 
     *            结果集 
     */  
    public static void free(ResultSet rs) {  
   
    	free(rs,statement);  
    }  
   
    /** 
     * 释放资源 
     *  
     * @param statement 
     * @param rs 
     */  
    public static void free(ResultSet rs,Statement statement) {  
        JdbcUtils.releaseResources(rs,statement,conn);  
    }  
   
    /** 
     * 释放资源 
     */  
    public static void free() {  
   
        free(null);  
    }  
   
}  