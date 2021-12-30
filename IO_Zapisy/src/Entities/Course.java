package Entities;

import Enums.RoomDestination;

public class Course extends AbstractEntity {

	public RoomDestination requiredRoom;
	public String title;
	public String description;
	public Course(int id, RoomDestination requiredRoom, String title, String description) {
		super(id);
		this.requiredRoom = requiredRoom;
		this.title = title;
		this.description = description;
	}
	
}
