package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	String driverName = "com.mysql.cj.jdbc.Driver"; 
	String dbURL = "jdbc:mysql://localhost:3306/db_demo"; 
	String userName = "root"; 
	String userPwd = "hh031010"; 

	public Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
		return conn;
	}

	public void closeCon(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("连接异常");
			e.printStackTrace();
		}
	}

}
