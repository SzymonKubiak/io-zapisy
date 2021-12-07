package PersonData;

import java.util.List;

import CourseData.Course;

public class Teacher {
	private int id;
	private PersonalData personalData;
	private List<Course> competencies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

	public void addCompetency(Course course) {
		competencies.add(course);
	}

	public void removeCompetency(Course course) {
		competencies.remove(course);
	}
	public Teacher() {
		
	}
}
