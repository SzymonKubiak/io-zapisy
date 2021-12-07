package CourseData;

public class Classroom {
	private int id;
	private RoomDestination destination;
	private String building;
	private String roomId;

	public Classroom(RoomDestination destination, String building, String roomId) {
		super();
		this.destination = destination;
		this.building = building;
		this.roomId = roomId;
	}

}
