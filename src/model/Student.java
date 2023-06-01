package model;

/**
 * 
 * @author hu'hao
 *
 */
public class Student {
	private Integer studentId;
	private String studentName;
	private Integer sex;
	private Integer age;
	private Dept dept;
	
	public Student() {}

	public Student(Integer studentId, String studentName, Integer sex, Integer age, Dept dept) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.sex = sex;
		this.age = age;
		this.dept = dept;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", sex=" + sex + ", age=" + age
				+ ", deptId=" + dept + "]";
	}
	
}
