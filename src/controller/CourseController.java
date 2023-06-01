package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import dao.DbUtil;
import model.Course;
import model.Dept;
import model.Student;

/**
 * 
 * @author hu'hao
 *
 */
public class CourseController {
	
	private DbUtil dbUtil = new DbUtil();
	
	private CourseDao courseDao = new CourseDao();
	
	/**
	 * 根据 id 查
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Course selectById(Integer id) throws ClassNotFoundException, SQLException {
		if (id == null || id == 0) {
			System.out.println("输入数据:学号[" + id + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = courseDao.selectById(con, id);
		Course course = new Course();
		while (rs.next()) {
			course.setCourseId(rs.getInt("course_id"));
			course.setCourseName(rs.getString("course_name"));
		}
		if (con != null) con.close();
		return course;
	}
	
	/**
	 * 查询课程名
	 * @param name 名字
	 * @return 查询出来
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Course selectByName(String name) throws SQLException, ClassNotFoundException{
		if (name == null) {
			System.out.println("输入数据:课程名[" + name + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = courseDao.selectByName(con, name);
		Course course = null;
		while (rs.next()) {
			course = new Course();
			course.setCourseId(rs.getInt("course_id"));
			course.setCourseName(rs.getString("course_name"));
		}
		if (con != null) con.close();
		return course;
	}
	
}
