package Entities;

import java.sql.Time;
import java.util.Date;

public class Group extends AbstractEntity{

	public PersonalData teacher;
	public Time time;
	public int day;
	public Course course;
	public Classroom classroom;
	public Group(int id, PersonalData teacher, Time time, int day, Course course, Classroom classroom) {
		super(id);
		this.teacher = teacher;
		this.time = time;
		this.day = day;
		this.course = course;
		this.classroom = classroom;
	}

	
	
}
