package Entities;

import java.util.Date;

public class Group extends AbstractEntity{

	private Teacher teacher;
	private Date time;
	private Course course;
	private Classroom classroom;
	public Group(int id, Teacher teacher, Date time, Course course, Classroom classroom) {
		super(id);
		this.teacher = teacher;
		this.time = time;
		this.course = course;
		this.classroom = classroom;
	}
	
	
}
