package com.company.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//druid连接池工具类
public class JDBCUtils {
    //定义成员变量ds  可以切换不同连接池
    private static DataSource ds;

    //初始化配置
    static {
        try{
            //加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取  定义成员变量DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
    public static void close(Statement stmt, Connection conn){
        close(null,stmt,conn);
    }
    public static void close(ResultSet rs,Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

    }
    }
    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource(){
        return  ds;
    }
}
