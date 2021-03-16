package com.schoolmanageapp.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
 
public class JDBCUtil {
 
    public static String DRIVERNAME = null;
    public static String URL = null;
    public static String USER = null;
    public static String PASSWORD = null;
 
    public static Connection conn = null;
 
    static {
        try {
 
            Properties props = new Properties();         
            String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();  
            FileInputStream in = new FileInputStream(path);
            props.load(in);
            DRIVERNAME = props.getProperty("drivername");
            URL = props.getProperty("url");
            USER = props.getProperty("user");
            PASSWORD = props.getProperty("password");
 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    public static Connection getConnection() throws Exception {
        if (conn != null && !conn.isClosed()) {
            return conn;
        }
         
        Class.forName(DRIVERNAME);
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
 
        return conn;
    }
 
    public static void closeResource(Connection conn, PreparedStatement st) throws SQLException {
        st.close();
        conn.close();
    }
 
    public static void closeResource(Connection conn, ResultSet rs, PreparedStatement st) throws SQLException {
        st.close();
        rs.close();
        conn.close();
    }
}
