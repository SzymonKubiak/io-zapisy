package AppliicationInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import CourseData.Classroom;
import CourseData.Course;
import CourseData.Enrollment;
import CourseData.Group;
import CourseData.GroupFactory;
import PersonData.PersonFactory;
import PersonData.Student;
import PersonData.Teacher;

public class Facade {
private List<Enrollment> enrollments;
private List<Classroom> classrooms;
private List<Course> courses;
private GroupFactory groupFactory;
private PersonFactory personFactory;

public boolean createCourse(String [] data) {
	Course course = new Course(data);
	this.courses.add(course);
	return true;
}

public Course findCourse(String name) {
	return null;
}

public boolean createGroup(String [] data) {
	
	Course course = courses.get(Integer.parseInt(data[0]));
	Teacher teacher = personFactory.getTeacherById(Integer.parseInt(data[1]));
	Classroom classroom = classrooms.get(Integer.parseInt(data[2]));
	String date = data[3];
	
	Group group = groupFactory.createGroup(course, teacher, classroom, date);
	
	return group != null;
}

public List<Course> getCourses(){
	return this.courses;
}
public Facade() {
	this.enrollments = new LinkedList();
	this.classrooms = new LinkedList();
	this.courses = new LinkedList();
	this.groupFactory = new GroupFactory();
	this.personFactory = new PersonFactory();
	
}

public Student createStudent(String [] data) {
	
	return personFactory.createStudent(data);
}
}
