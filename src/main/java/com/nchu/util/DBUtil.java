package com.nchu.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtil {

    private static DataSource dataSource;

    static {
        try {
            Properties props = new Properties();
            InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            if (is == null) {
                throw new RuntimeException("数据库配置文件 db.properties 未找到，请先复制 db.properties.example 为 db.properties 并配置！");
            }
            props.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            throw new RuntimeException("读取数据库配置文件失败", e);
        } catch (Exception e) {
            throw new RuntimeException("初始化数据库连接池失败", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
