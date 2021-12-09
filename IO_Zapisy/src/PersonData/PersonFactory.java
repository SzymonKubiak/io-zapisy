package PersonData;

import java.util.List;

public class PersonFactory {
	private List<Student> students;
	private List<Teacher> teachers;

	public Student createStudent(String[] data) {
		
		PersonalData personalData = new PersonalData(data);
		Student student = new Student();
		student.setPersonalData(personalData);
		
		return student;
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
	
	public Teacher getTeacherById(int id) {
		return teachers.get(id);
	}

}
