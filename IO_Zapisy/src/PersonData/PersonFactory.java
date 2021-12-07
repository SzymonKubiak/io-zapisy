package PersonData;

import java.util.List;

public class PersonFactory {
	private List<Student> students;
	private List<Teacher> teachers;

	public boolean createStudent(String[] data) {
		return false;
	}

	public boolean createTeacher(String[] data) {
		return false;
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void deleteTeacher(Teacher teacher) {
		teachers.remove(teacher);
	}
	
	public void deleteStudent(Student teacher) {
		students.remove(teacher);
	}

}
