package Entities;

import Enums.RoomDestination;

public class Classroom extends AbstractEntity {

	public RoomDestination destination;
	public String building;
	public String roomId;
	public Classroom(int id, RoomDestination destination, String building, String roomId) {
		super(id);
		this.destination = destination;
		this.building = building;
		this.roomId = roomId;
	}
	
}
