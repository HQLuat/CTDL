package Lab9_Task1;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}

	public boolean hasMoreStudentThan(List<Student> ls) {
		return students.size() > ls.size();
	}
	
	public boolean isPracticalCourse() {
		return type.equals("TH");
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public String getType() {
		return type;
	}

	public String toString() {
		return "[" + id + ", " + title + ", " + type + ", " + students + ", "
				+ lecturer + "]";
	}
}
