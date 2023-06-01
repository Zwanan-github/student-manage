package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import model.Student;

/**
 * 
 * @author hu'hao
 * 提供 student 对象的接口
 */
public class StudentDao {
	
	/**
	 * 查询所有学生
	 * @param con 数据库连接对象
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet selectAll(Connection con) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("SELECT stu.student_id, stu.student_name, stu.sex, stu.age, dept.* from t_student stu,t_dept dept where stu.dept = dept.dept_id order by stu.student_id asc");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	
	/**
	 * 根据学号查询
	 * @param con 数据库连接对象
	 * @param id 学号
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectById(Connection con, Integer id) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("SELECT stu.student_id, stu.student_name, stu.sex, stu.age, dept.* from t_student stu,t_dept dept where stu.dept = dept.dept_id and stu.student_id = ")
				.append(id);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	
	/**
	 * 根据姓名查询
	 * @param con 数据库连接对象
	 * @param name 姓名
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectLikeName(Connection con, String name) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("SELECT stu.student_id, stu.student_name, stu.sex, stu.age, dept.* from t_student stu,t_dept dept where stu.dept = dept.dept_id and stu.student_name LIKE '%")
				.append(name)
				.append("%'");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	
	/**
	 * 根据性别查询
	 * @param con 数据库连接对象
	 * @param sex 性别
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectBySex(Connection con, Integer sex) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接有误!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("SELECT stu.student_id, stu.student_name, stu.sex, stu.age, dept.* from t_student stu,t_dept dept where stu.dept = dept.dept_id and stu.sex = ")
				.append(sex);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}
	
	/**
	 * 根据年龄查询
	 * @param con 数据库连接对象
	 * @param age 年龄
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectByAge(Connection con, Integer age) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("SELECT stu.student_id, stu.student_name, stu.sex, stu.age, dept.* from t_student stu,t_dept dept where stu.dept = dept.dept_id and stu.age = ")
				.append(age);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	/**
	 * 根据院系查询
	 * @param con 数据库连接对象
	 * @param deptName 院系名
	 * @return
	 * @throws SQLException
	 */
	public ResultSet selectByDept(Connection con, String deptName) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return null;
		}
		StringBuffer sql = 
				new StringBuffer("SELECT stu.student_id, stu.student_name, stu.sex, stu.age, dept.* from t_student stu,t_dept dept where dept_id = stu.dept and dept.dept_name like '%")
				.append(deptName)
				.append("%'");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();
	}

	/**
	 * 插入
	 * @param con
	 * @param name
	 * @param sex
	 * @param age
	 * @param dept
	 * @return
	 * @throws SQLException
	 */
	public int insertStudent(Connection con, String name, String sex, Integer age, Integer dept) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return 0;
		} 
		StringBuffer sql = new StringBuffer("insert INTO t_student(student_name, sex, age, dept) VALUES(?,?,?,?)");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setString(1, name);
		ps.setInt(2, "男".equals(sex) ? 0 : 1);
		ps.setInt(3, age);
		ps.setInt(4, dept);
		int row = ps.executeUpdate();
		return row;
	}

	/**
	 * 修改
	 * @param con
	 * @param id
	 * @param name
	 * @param sex
	 * @param age
	 * @param dept
	 * @return
	 * @throws SQLException 
	 */
	public int updateStudent(Connection con, Integer id, String name, String sex, Integer age, Integer dept) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return 0;
		} 
		StringBuffer sql = new StringBuffer("update t_student set student_name = ?, sex = ?, age = ?, dept = ? WHERE student_id = ?");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setString(1, name);
		ps.setInt(2, "男".equals(sex) ? 0 : 1);
		ps.setInt(3, age);
		ps.setInt(4, dept);
		ps.setInt(5, id);
		int row = ps.executeUpdate();
		return row;
	}
	/**
	 * 删除
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int deleteStudent(Connection con, Integer id) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return 0;
		} 
		StringBuffer sql = new StringBuffer("delete from t_student where t_student.student_id = ?");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setInt(1, id);
		int row = ps.executeUpdate();
		return row;
	}
}
