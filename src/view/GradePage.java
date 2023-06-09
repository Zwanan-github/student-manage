/*
 * StudentPage.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import controller.CourseController;
import controller.DeptController;
import controller.GradeController;
import controller.StudentController;
import dao.DbUtil;
import model.Course;
import model.Grade;
import util.DataUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Point;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author  __USER__
 */
public class GradePage extends javax.swing.JFrame {
	
	/** Creates new form StudentPage 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException */
	public GradePage() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException  {
		setLocation(new Point(500, 400));
		setType(Type.POPUP);
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		// 当前系统的风格
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		UIManager.setLookAndFeel(lookAndFeel);
		setTitle("成绩管理");
		
		idLabel = new JLabel("学号：");
		
		idEdit = new JTextField();
		idEdit.setColumns(10);
		
		gradeBtn = new JButton("查询");
		gradeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchGrade();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		scrollPane = new JScrollPane();
		
		sidLabel = new JLabel("学号：");
		
		sidEdit = new JTextField();
		sidEdit.setEditable(false);
		sidEdit.setColumns(10);
		
		JLabel snameLabel = new JLabel("姓名：");
		
		snEdit = new JTextField();
		snEdit.setEditable(false);
		snEdit.setColumns(10);
		
		courseLabel = new JLabel("课程：");
		
		cnEdit = new JTextField();
		cnEdit.setColumns(10);
		
		scopeLabel = new JLabel("成绩：");
		
		scope = new JTextField();
		scope.setColumns(10);
		
		JButton addBtn = new JButton("增加");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addGrade();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton deleteBtn = new JButton("删除");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteGrade();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton updateBtn = new JButton("修改");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateGrade();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(25)
					.addComponent(idLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idEdit, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gradeBtn, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(courseLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(sidLabel, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cnEdit)
								.addComponent(sidEdit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scopeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(snameLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scope)
								.addComponent(snEdit, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(updateBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(addBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteBtn))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(19)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(idEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(gradeBtn))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sidLabel)
						.addComponent(sidEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(snameLabel)
						.addComponent(snEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addBtn)
						.addComponent(deleteBtn))
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(courseLabel)
						.addComponent(cnEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scopeLabel)
						.addComponent(scope, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateBtn))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		gradeTable = new JTable();
		gradeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gradeTablePressed();
			}
		});
		gradeTable.setRowHeight(25);
		gradeTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u8BFE\u7A0B", "\u6210\u7EE9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(gradeTable);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
	
	public void gradeTablePressed() {
		int row = gradeTable.getSelectedRow();
		sidEdit.setText(String.valueOf(gradeTable.getValueAt(row, 0)));
		snEdit.setText(String.valueOf(gradeTable.getValueAt(row, 1)));
		cnEdit.setText(String.valueOf(gradeTable.getValueAt(row, 2)));
		scope.setText(String.valueOf(gradeTable.getValueAt(row, 3)));
	}

	public void searchGrade() throws ClassNotFoundException, SQLException {
		DefaultTableModel dtm = (DefaultTableModel) gradeTable.getModel();
		String searchText = idEdit.getText();
		if (searchText == null || "".equals(searchText) || !DataUtil.isInteger(searchText)) {
			JOptionPane.showMessageDialog(null, "学号有误","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		dtm.setRowCount(0);
		Integer id = Integer.valueOf(searchText);
		List<Grade> grades = gradeController.selectById(id);
		if (grades != null) {
			for (Grade grade : grades) {
				Vector v = new Vector();
				v.add(grade.getStudent().getStudentId());
				v.add(grade.getStudent().getStudentName());
				v.add(grade.getCourse().getCourseName());
				v.add(grade.getScope());
				dtm.addRow(v);
			}
		}
	}
	
	public void addGrade() throws ClassNotFoundException, SQLException {
		String sidStr = sidEdit.getText();
		String snameStr = snEdit.getText();
		String counStr = cnEdit.getText();
		String scoStr = scope.getText();
		Course course = courseController.selectByName(counStr);
		if (sidStr == null || DataUtil.isInteger(sidStr) == false || "".equals(sidStr)) {
			JOptionPane.showMessageDialog(null, "没有学号或学号错误","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (course == null) {
			JOptionPane.showMessageDialog(null, "没有课程[" + counStr +"]","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		System.out.println(sidStr + " " + course.getCourseId() + " " + scoStr);
		int row = gradeController.insertGrade(Integer.valueOf(sidStr), course.getCourseId(), scoStr);
		if (row == 0) {
			JOptionPane.showMessageDialog(null, "添加失败","添加", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, "添加了" + row + "条数据","添加", JOptionPane.ERROR_MESSAGE);
		searchGrade();
	}
	
	/**
	 * 更新
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateGrade() throws ClassNotFoundException, SQLException {
		String sidStr = sidEdit.getText();
		String snameStr = snEdit.getText();
		String counStr = cnEdit.getText();
		String scoStr = scope.getText();
		Course course = courseController.selectByName(counStr);
		if (sidStr == null || DataUtil.isInteger(sidStr) == false || "".equals(sidStr)) {
			JOptionPane.showMessageDialog(null, "没有学号或学号错误","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (course == null) {
			JOptionPane.showMessageDialog(null, "没有课程[" + counStr +"]","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int row = gradeController.updateGrade(Integer.valueOf(sidStr), course.getCourseId(), scoStr);
		if (row == 0) {
			JOptionPane.showMessageDialog(null, "更新失败","更新", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, "更新了" + row + "条数据","更新", JOptionPane.ERROR_MESSAGE);
		searchGrade();
	}
	
	/**
	 * 删除
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteGrade() throws ClassNotFoundException, SQLException {
		String sidStr = sidEdit.getText();
		String snameStr = snEdit.getText();
		String counStr = cnEdit.getText();
		String scoStr = scope.getText();
		Course course = courseController.selectByName(counStr);
		if (sidStr == null || DataUtil.isInteger(sidStr) == false || "".equals(sidStr)) {
			JOptionPane.showMessageDialog(null, "没有学号或学号错误","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (course == null) {
			JOptionPane.showMessageDialog(null, "没有课程[" + counStr +"]","参数错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int row = gradeController.deleteGrade(Integer.valueOf(sidStr), course.getCourseId(), scoStr);
		if (row == 0) {
			JOptionPane.showMessageDialog(null, "更新失败","更新", JOptionPane.ERROR_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, "更新了" + row + "条数据","更新", JOptionPane.ERROR_MESSAGE);
		searchGrade();
	}

	/**
	 * @param args the command line arguments
	 */
//	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new GradePage().setVisible(true);
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InstantiationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (UnsupportedLookAndFeelException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	private CourseController courseController = new CourseController();
	private GradeController gradeController = new GradeController();
	
	private JTextField idEdit;
	private JTable gradeTable;
	private JLabel idLabel;
	private JButton gradeBtn;
	private JScrollPane scrollPane;
	private JLabel sidLabel;
	private JTextField sidEdit;
	private JTextField snEdit;
	private JLabel courseLabel;
	private JTextField cnEdit;
	private JLabel scopeLabel;
	private JTextField scope;
}