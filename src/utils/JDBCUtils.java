package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author AoTxLand
 * @date 2020-06-11 23:08
 */
public class JDBCUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> connThread = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动连接池
     * @return conn
     */
    public static Connection getConnection() {
        Connection conn = connThread.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                connThread.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }


    public static void rollbackAndClose(){
        Connection connection = connThread.get();
        if(connection != null) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        connThread.remove();
    }

    public static void commitAndClose() {
        Connection connection = connThread.get();
        if(connection != null) {
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        connThread.remove();
    }
}
