package AppliicationInterface;

import java.util.List;

import CourseData.Course;

public class Starter {

	public static void main(String[] args) {
		Facade facade = new Facade();
		String [] courseData = {"RegularClassroom","Inzynieria Oprogramowania", "Zajecia obejmuja modelowanie oprogramowania za pomoca UML"};
		facade.createCourse(courseData);
		String [] courseData1 = {"Lecture","Urzadzenia Peryferyjne", "Zajecia obejmuja obsluge urzadzen"};
		facade.createCourse(courseData1);
		List<Course> courses = facade.getCourses();
		System.out.println(courses);

	}

}
