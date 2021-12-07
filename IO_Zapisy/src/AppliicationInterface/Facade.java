package AppliicationInterface;

import java.util.List;

import CourseData.Classroom;
import CourseData.Course;
import CourseData.Enrollment;
import CourseData.GroupFactory;
import PersonData.PersonFactory;

public class Facade {
private List<Enrollment> enrollments;
private List<Classroom> classrooms;
private List<Course> courses;
private GroupFactory groupFactory;
private PersonFactory personFactory;

public boolean createCourse(String [] data) {
	return false;
}
public Course findCourse(String name) {
	return null;
}

public boolean createGroup(String [] data) {
	return groupFactory.createGroup(data);
}
}
