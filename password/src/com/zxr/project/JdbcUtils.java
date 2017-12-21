package com.zxr.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author zxr:zhaoxinran_dlmuit@163.com
 * @version 创建时间：2017年12月21日 上午10:24:18 类说明
 */
public class JdbcUtils {
	private static String user = "root";
	private static String password = "root";
	private static String dbName = "db_password";
	private static String url = "jdbc:mysql://localhost:3306/" + dbName + "?user=" + user + "&password=" + password
			+ "&useUnicode=true&characterEncoding=gb2312";

	private static DataSource dataSource = null;

	// ===加载驱动===
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		}
	}

	private JdbcUtils() {

	}

	// ===获取连接=====
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url);
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	// ===释放资源======
	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}