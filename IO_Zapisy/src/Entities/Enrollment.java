package Entities;

public class Enrollment extends AbstractEntity {

	public PersonalData student;
	public Group group;
	public Enrollment(int id, PersonalData student, Group group) {
		super(id);
		this.student = student;
		this.group = group;
	}
	
}
