package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbUtil;
import dao.DeptDao;
import model.Dept;

/**
 * @author hu'hao
 *
 */
public class DeptController {
	
	private DbUtil dbUtil = new DbUtil();
	private DeptDao deptDao = new DeptDao();
	
	public List<Dept> selectAllDept() throws SQLException, ClassNotFoundException {
		Connection con = dbUtil.getCon();
		ResultSet res = deptDao.selectAllDept(con);
		List<Dept> depts = new ArrayList<Dept>();
		while (res.next()) {
			Dept dept = new Dept();
			dept.setDeptId(res.getInt("dept_id"));
			dept.setDeptName(res.getString("dept_name"));
			depts.add(dept);
		}
		if (con != null) {
			con.close();
		}
		return depts;
	}
		
	
}
