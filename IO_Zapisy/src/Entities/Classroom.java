package Entities;

import Enums.RoomDestination;

public class Classroom extends AbstractEntity {

	public RoomDestination destination;
	public String building;
	public String roomId;
	public int capacity;
	public Classroom(int id, RoomDestination destination, String building, String roomId, int capacity) {
		super(id);
		this.destination = destination;
		this.building = building;
		this.roomId = roomId;
		this.capacity = capacity;
	}

	
}
