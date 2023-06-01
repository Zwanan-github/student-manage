package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.Dept;
/**
 * 
 * @author hu'hao
 *
 */
public class DeptDao {
	
	/**
	 * 获取所有的院系
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectAllDept(Connection con) throws SQLException {
		 if (con == null) {
			 System.out.println("数据库连接出错!");
			 return null;
		 }
		 StringBuffer sql = new StringBuffer("select dept.dept_id,dept.dept_name from t_dept dept");
		 PreparedStatement ps = con.prepareStatement(sql.toString());
		 return ps.executeQuery();
	}
	
	/**
	 * 根据院名查询id
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet selectByName(Connection con, String name) throws SQLException {
		if (con == null) {
			 System.out.println("数据库连接出错!");
			 return null;
		 }
		 StringBuffer sql = new StringBuffer("select dept.dept_id,dept.dept_name from t_dept dept where dept_name like '")
				 .append(name).append("'");
		 PreparedStatement ps = con.prepareStatement(sql.toString());
		 return ps.executeQuery();
	}
	
}	
