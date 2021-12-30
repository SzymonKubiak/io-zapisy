package Enums;

public enum RoomDestination {

	RegularClassroom,
	SportGym,
	Laboratory,
	Lecture;
	
	public static RoomDestination toEnum(int val) {
		switch(val) {
		case 0: return RegularClassroom;
		case 1: return SportGym;
		case 2: return Laboratory;
		case 3: return Lecture;
		}
		return null;
	}
}
