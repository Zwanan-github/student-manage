package test;

import java.sql.SQLException;

import controller.DeptController;

public class DeptTest {

	DeptController deptController = new DeptController();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DeptTest().run();
	}
	
	void run() throws ClassNotFoundException, SQLException {
		getAll();
	}
		
	void getAll() throws ClassNotFoundException, SQLException {
		System.out.println(deptController.selectAllDept());
	}
	
	
}
