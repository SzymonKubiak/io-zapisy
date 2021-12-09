package CourseData;

public class Course {
	private static int idCounter = 0;
	private int id;
	private RoomDestination requiredRoom;
	private String title;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoomDestination getRequiredRoom() {
		return requiredRoom;
	}

	public void setRequiredRoom(RoomDestination requiredRoom) {
		this.requiredRoom = requiredRoom;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course(String [] data) {
		
		this.id = idCounter++;
		this.requiredRoom = RoomDestination.valueOf(data[0]);
		this.title = data[1];
		this.description = data[2];
	}
	@Override
	public String toString() {
		return id + "\n" + title + "\n" + description + "\n" + requiredRoom + "\n";
	}

}