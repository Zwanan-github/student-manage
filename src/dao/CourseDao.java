package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao {

	/**
	 * 查询 id
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet selectById(Connection con, Integer id) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("select t_course.course_id, t_course.course_name from t_course where t_course.course_id = ")
				.append(id);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	/**
	 * 根据 名字 查课程
	 * @param con
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet selectByName(Connection con, String name) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("select t_course.course_id, t_course.course_name from t_course where t_course.course_name like '")
				.append(name)
				.append("'");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

}
