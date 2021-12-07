package CourseData;

import PersonData.Student;

public class Enrollment {
	private int id;
	private Student student;
	private Group group;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
