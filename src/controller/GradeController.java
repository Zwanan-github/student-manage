package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbUtil;
import dao.GradeDao;
import model.Course;
import model.Grade;
import model.Student;

public class GradeController {

	private DbUtil dbUtil = new DbUtil();
	private GradeDao gradeDao = new GradeDao();
	
	/**
	 * 根据 id 查询选课成绩
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Grade> selectById(Integer id) throws ClassNotFoundException, SQLException {
		if (id == null || id == 0) {
			System.out.println("输入数据:学号[" + id + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = gradeDao.selectById(con, id);
		List<Grade> grades = new ArrayList<Grade>();
		while (rs.next()) {
			Grade grade = new Grade();
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			grade.setStudent(student);
			Course course = new Course();
			course.setCourseName(rs.getString("course_name"));
			grade.setCourse(course);
			grade.setScope(rs.getString("scope"));
			grades.add(grade);
		}
		if (con != null) {
			con.close();
		}
		return grades;
	}

	/**
	 * 插入
	 * @param sid
	 * @param cid
	 * @param scope
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int insertGrade(Integer sid, Integer cid, String scope) throws SQLException, ClassNotFoundException {
		if (sid == null || cid == null) {
			return 0;
		}
		Connection con = dbUtil.getCon();
		int row = gradeDao.insertGrade(con, sid, cid, scope);
		if (row == 0) {
			if (con != null) con.close();
			System.out.println("添加失败!");
			return 0;
		}
		System.out.println("添加成功!");
		if (con != null) con.close();
		return row;
	}
	
	/**
	 * 更新
	 * @param sid
	 * @param cid
	 * @param scope
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int updateGrade(Integer sid, Integer cid, String scope) throws ClassNotFoundException, SQLException {
		if (sid == null || cid == null) {
			return 0;
		}
		Connection con = dbUtil.getCon();
		int row = gradeDao.updateGrade(con, sid, cid, scope);
		if (row == 0) {
			if (con != null) con.close();
			System.out.println("更新失败!");
			return 0;
		}
		System.out.println("更新成功!");
		if (con != null) con.close();
		return row;
	}
	
	/**
	 * 删除
	 * @param sid
	 * @param cid
	 * @param scope
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int deleteGrade(Integer sid, Integer cid, String scope) throws ClassNotFoundException, SQLException {
		if (sid == null || cid == null) {
			return 0;
		}
		Connection con = dbUtil.getCon();
		int row = gradeDao.deleteGrade(con, sid, cid, scope);
		if (row == 0) {
			if (con != null) con.close();
			System.out.println("删除失败!");
			return 0;
		}
		System.out.println("删除成功!");
		if (con != null) con.close();
		return row;
	}
	
	
	
}
