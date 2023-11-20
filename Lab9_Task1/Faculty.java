package Lab9_Task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;
	
	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course re = null;
		for (int i = 0; i < courses.size(); i++) {
			Course c = courses.get(i);
			
			if(re == null && c.isPracticalCourse()) {
				re = c;
			}
			
			if(re != null) {
				if(c.hasMoreStudentThan(re.getStudents()) && c.isPracticalCourse() ) {
					re = courses.get(i);
				}
			}
			
		}
		return re;
	}
	
	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> map = new HashMap<Integer, List<Student>>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				List<Student> tmp = new ArrayList<Student>();
				if(map.containsKey(student.getYear())) {
					tmp = map.get(student.getYear());
					tmp.add(student);
				}else {
					tmp.add(student);
				}
				map.put(student.getYear(), tmp);
			}
		}
		return map;
	}
	public Set<Course> filterCourses(String type) {
		Set<Course> treeMap = new TreeSet<Course>(new Comparator<Course>() {
			public int compare(Course c1, Course c2) {
				return c2.getStudents().size() - c1.getStudents().size();
			}
		});
		for (Course c : courses) {
			if(c.getType().equals(type)) {
				treeMap.add(c);
			}
		}
		return treeMap;
	}
}
