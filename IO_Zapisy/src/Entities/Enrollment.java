package Entities;

public class Enrollment extends AbstractEntity {

	private PersonalData student;
	private Group group;
	public Enrollment(int id, PersonalData student, Group group) {
		super(id);
		this.student = student;
		this.group = group;
	}
	
}
