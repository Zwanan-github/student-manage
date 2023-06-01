package model;

/**
 * 
 * @author hu'hao
 *
 */
public class Grade {
	private Student student;
	private Course course;
	private String scope;
	
	public Grade() {}
	
	public Grade(Student student, Course course, String scope) {
		super();
		this.student = student;
		this.course = course;
		this.scope = scope;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "Grade [student=" + student + ", course=" + course + ", scope=" + scope + "]";
	}
}
