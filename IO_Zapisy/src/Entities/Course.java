package Entities;

import Enums.RoomDestination;

public class Course extends AbstractEntity {

	private RoomDestination requiredRoom;
	private String title;
	private String description;
	public Course(int id, RoomDestination requiredRoom, String title, String description) {
		super(id);
		this.requiredRoom = requiredRoom;
		this.title = title;
		this.description = description;
	}
	
}
