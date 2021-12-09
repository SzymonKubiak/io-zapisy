package CourseData;

import java.util.Date;

import PersonData.Teacher;

public class Group {
	private int id;
	private Teacher teacher;
	private Date time;
	private Course course;
	private Classroom classroom;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	public Group(String date) {
		this.time = new Date(date);
	}

}
