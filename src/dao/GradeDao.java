package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * @author hu'hao
 *
 */
public class GradeDao {
	
	/**
	 * 根据 id 查询
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
				new StringBuffer("SELECT stu.student_id, stu.student_name, cou.course_id, cou.course_name, gra.scope from t_student stu, t_course cou, t_grade gra where stu.student_id = gra.student_id and cou.course_id = gra.course_id and stu.student_id = ")
				.append(id);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		return ps.executeQuery();	 
	}
	
	/**
	 * 插入
	 * @param con
	 * @param sid
	 * @param cid
	 * @param scope
	 * @return
	 * @throws SQLException 
	 */
	public int insertGrade(Connection con, Integer sid, Integer cid, String scope) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return 0;
		} 
		StringBuffer sql = new StringBuffer("INSERT INTO t_grade(t_grade.student_id, t_grade.course_id, t_grade.scope) value(?, ?, ?)");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setInt(1, sid);
		ps.setInt(2, cid);
		ps.setString(3, scope);
		int row = ps.executeUpdate();
		return row;
	}
	
	/**
	 * 更新
	 * @param con
	 * @param sid
	 * @param cid
	 * @param scope
	 * @return
	 * @throws SQLException 
	 */
	public int updateGrade(Connection con, Integer sid, Integer cid, String scope) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return 0;
		} 
		StringBuffer sql = new StringBuffer("update t_grade set t_grade.scope = ? where t_grade.student_id = ? and t_grade.course_id = ?");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setString(1, scope);
		ps.setInt(2, sid);
		ps.setInt(3, cid);
		int row = ps.executeUpdate();
		return row;
	}

	/**
	 * 删除
	 * @param con
	 * @param sid
	 * @param cid
	 * @param scope
	 * @return
	 * @throws SQLException 
	 */
	public int deleteGrade(Connection con, Integer sid, Integer cid, String scope) throws SQLException {
		if (con == null) {
			System.out.println("数据库连接出错!");
			return 0;
		} 
		StringBuffer sql = new StringBuffer("delete from t_grade where t_grade.student_id = ? and t_grade.course_id = ?");
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ps.setInt(1, sid);
		ps.setInt(2, cid);
		int row = ps.executeUpdate();
		return row;
	}
}
