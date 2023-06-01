package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbUtil;
import dao.DeptDao;
import dao.StudentDao;
import model.Dept;
import model.Student;
/**
 * @author hu'hao
 *
 */
public class StudentController {
	
	private StudentDao studentDao = new StudentDao();
	private DeptDao deptDao = new DeptDao();
	private DbUtil dbUtil = new DbUtil();
	
	/**
	 * 查询所有的学生信息
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Student> selectAll() throws ClassNotFoundException, SQLException {
		Connection con = dbUtil.getCon();
		ResultSet rs = studentDao.selectAll(con);
		ArrayList<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setSex(rs.getInt("sex"));
			student.setAge(rs.getInt("age"));
			student.setDept(new Dept(rs.getInt("dept_id"), rs.getString("dept_name")));
			students.add(student);
		}
		if (con != null) con.close();
		return students;
	}
	
	
	/**
	 * 根据 id 查找学生信息
	 * @param id 学号
	 * @return 查找到的学生对象
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Student> selectById(Integer id) throws SQLException, ClassNotFoundException{
		if (id == null || id == 0) {
			System.out.println("输入数据:学号[" + id + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = studentDao.selectById(con, id);
		ArrayList<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setSex(rs.getInt("sex"));
			student.setAge(rs.getInt("age"));
			student.setDept(new Dept(rs.getInt("dept_id"), rs.getString("dept_name")));
			students.add(student);
		}
		if (con != null) con.close();
		return students;
	}
	
	/**
	 * 模糊查询姓名
	 * @param name 名字
	 * @return 查询出来的集合
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Student> selectLikeName(String name) throws SQLException, ClassNotFoundException{
		if (name == null) {
			System.out.println("输入数据:姓名[" + name + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = studentDao.selectLikeName(con, name);
		ArrayList<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setSex(rs.getInt("sex"));
			student.setAge(rs.getInt("age"));
			student.setDept(new Dept(rs.getInt("dept_id"), rs.getString("dept_name")));
			students.add(student);
		}
		if (con != null) con.close();
		return students;
	}
	
	/**
	 * 根据性别查询
	 * @param sex 性别
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Student> selectBySex(String sex) throws SQLException, ClassNotFoundException{
		if (sex == null || ("男".equals(sex) == false && "女".equals(sex) == false)) {
			System.out.println("输入数据:性别[" + sex + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = studentDao.selectBySex(con, "男".equals(sex) ? 0 : 1);
		ArrayList<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setSex(rs.getInt("sex"));
			student.setAge(rs.getInt("age"));
			student.setDept(new Dept(rs.getInt("dept_id"), rs.getString("dept_name")));
			students.add(student);
		}
		if (con != null) con.close();
		return students;
	}
	
	/**
	 * 根据 年龄 查找学生
	 * @param age 年龄
	 * @return 查找到的学生
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Student> selectByAge(Integer age) throws SQLException, ClassNotFoundException{
		if (age == null || age <= 0 || age >= 200) {
			System.out.println("输入数据:年龄[" + age + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = studentDao.selectByAge(con, age);
		ArrayList<Student> students = new ArrayList<Student>();  
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setSex(rs.getInt("sex"));
			student.setAge(rs.getInt("age"));
			student.setDept(new Dept(rs.getInt("dept_id"), rs.getString("dept_name")));
			students.add(student);
		}
		if (con != null) con.close();
		return students;
	}
	
	/**
	 * 根据 学院查询
	 * @param deptName 院系名
	 * @return 查找到的学生
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Student> selectByDept(String deptName) throws ClassNotFoundException, SQLException {
		if (deptName == null) {
			System.out.println("输入数据:学院[" + deptName + "]有误!");
			return null;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = studentDao.selectByDept(con, deptName);
		ArrayList<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setSex(rs.getInt("sex"));
			student.setAge(rs.getInt("age"));
			student.setDept(new Dept(rs.getInt("dept_id"), rs.getString("dept_name")));
			students.add(student);
		}
		if (con != null) con.close();
		return students;
	}

	/**
	 * 插入学生数据
	 * @param name 姓名
	 * @param sex 性别
	 * @param age 年龄
	 * @param dept 学院
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int insertStudent(String name, String sex, Integer age, String dept) throws ClassNotFoundException, SQLException {
		if (name == null || "".equals(name) || sex == null || ("男".equals(sex) == false && "女".equals(sex) == false)  || "".equals(sex) || age <= 0 || age >= 200 || dept == null || "".equals(dept)) {
			return 0;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = deptDao.selectByName(con, dept);
		Integer dept_id = 0;
		while (rs.next()) {
			dept_id = rs.getInt("dept_id");
		}
		int row = studentDao.insertStudent(con, name, sex, age, dept_id);
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
	 * 修改
	 * @param id
	 * @param name
	 * @param sex
	 * @param age
	 * @param dept
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int updateStudent(Integer id, String name, String sex, Integer age, String dept) throws ClassNotFoundException, SQLException {
		if (name == null || "".equals(name) || sex == null || ("男".equals(sex) == false && "女".equals(sex) == false)  || "".equals(sex) || age <= 0 || age >= 200 || dept == null || "".equals(dept)) {
			return 0;
		}
		Connection con = dbUtil.getCon();
		ResultSet rs = deptDao.selectByName(con, dept);
		Integer dept_id = 0;
		while (rs.next()) {
			dept_id = rs.getInt("dept_id");
		}
		int row = studentDao.updateStudent(con, id, name, sex, age, dept_id);
		if (row == 0) {
			if (con != null) con.close();
			System.out.println("修改失败!");
			return 0;
		}
		System.out.println("修改成功!");
		if (con != null) con.close();
		return row;
	}

	/**
	 * 删除学生
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int deleteStudent(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = dbUtil.getCon();
		int row = studentDao.deleteStudent(con, id);
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
