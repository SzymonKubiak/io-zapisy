package CourseData;

import java.util.List;

import PersonData.Teacher;

public class GroupFactory {
	private List<Group> groups;

	public Group createGroup(Course course, Teacher teacher, Classroom classroom, String date) {
		
		Group group = new Group(date);
		group.setClassroom(classroom);
		group.setCourse(course);
		group.setTeacher(teacher);
		
		return group;
	}

	public List<Group> getGroups() {
		return this.groups;
	}

	public void deleteGroup(Group group) {

	}
}
