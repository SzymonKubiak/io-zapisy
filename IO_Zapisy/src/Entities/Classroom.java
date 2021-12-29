package Entities;

import Enums.RoomDestination;

public class Classroom extends AbstractEntity {

	private RoomDestination destination;
	private String building;
	private String roomId;
	public Classroom(int id, RoomDestination destination, String building, String roomId) {
		super(id);
		this.destination = destination;
		this.building = building;
		this.roomId = roomId;
	}
	
}
