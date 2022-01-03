package Entities;

import Enums.RoomDestination;

public class Course extends AbstractEntity {

	public RoomDestination requiredRoom;
	public String title;
	public String description;
	public int yearOfStudy;
	public String educationSubject;
	public Course(int id, RoomDestination requiredRoom, String title, String description, int yearOfStudy,
			String educationSubject) {
		super(id);
		this.requiredRoom = requiredRoom;
		this.title = title;
		this.description = description;
		this.yearOfStudy = yearOfStudy;
		this.educationSubject = educationSubject;
	}
}
