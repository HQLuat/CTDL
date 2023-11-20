package Lab9_Task1;

import java.util.ArrayList;
import java.util.List;

public class TestTask1 {
	public static void main(String[] args) {
		List<Student> stList1 = new ArrayList<Student>();
		List<Student> stList2 = new ArrayList<Student>();
		Student st1 = new Student("1001", "A", 2004);
		Student st2 = new Student("1002", "B", 2003);
		Student st3 = new Student("1003", "C", 2001);
		Student st4 = new Student("1004", "D", 2004);
		Student st5 = new Student("1005", "E", 2002);
		
		//List student
		stList1.add(st1);
		stList1.add(st3);
		stList1.add(st4);
		
		stList2.add(st1);
		stList2.add(st2);
		stList2.add(st4);
		stList2.add(st5);
		
		//Course
		Course c1 = new Course("01", "CTDL", "TH", stList1,  "Thay A");
		Course c2 = new Course("02", "GTNM", "LT", stList2, "Thay B");
		Course c3 = new Course("03", "LTNC", "TH", stList2,  "Co C");
		
		//Faculty
		List<Course> cList = new ArrayList<Course>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		Faculty fa = new Faculty("CNTT", "DaiHocNongLam", cList);
		
		//Testing getMaxPracticalCourse() method
		System.out.println(fa.getMaxPracticalCourse());
		System.out.println();
		
		//Testing groupStudentsByYear() method
		System.out.println(fa.groupStudentsByYear());
		System.out.println();
		
		//Testing filterCourses() method
		System.out.println(fa.filterCourses(null));
	}
}
