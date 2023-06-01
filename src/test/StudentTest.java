package test;

import java.sql.SQLException;

import controller.StudentController;
import dao.DbUtil;
import dao.StudentDao;
 
public class StudentTest {

	public static void main(String[] args) throws Exception {
		new StudentTest().run();
	}
	
	void run() throws Exception {
		selectAll();
//		selectById(1);
//		selectLikeName("晓");
//		selectLikeName("胡");
//		selectBySex("男");
//		selectBySex("女");
//		selectByAge(19);
//		selectByAge(2999);
//		selectByAge(-1);
//		selectByAge(6);
//		selectByDept("计算机与信息工程学院");
//		selectByDept("信息工程学院");
	}
	
	StudentController studentController = new StudentController();
	
	void selectAll() throws Exception {
		System.out.println(studentController.selectAll());
	}
	
	void selectById(Integer id) throws ClassNotFoundException, SQLException {
		System.out.println(studentController.selectById(id));
	}
	
	void selectLikeName(String name) throws ClassNotFoundException, SQLException {
		System.out.println(studentController.selectLikeName(name));
	}
	
	void selectBySex(String sex) throws Exception {
		System.out.println(studentController.selectBySex(sex));
	}
	
	void selectByAge(int age) throws Exception {
		System.out.println(studentController.selectByAge(age));
	}
	
	void selectByDept(String deptName) throws Exception {
		System.out.println(studentController.selectByDept(deptName));
	}
	
}
