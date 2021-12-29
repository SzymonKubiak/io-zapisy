package Entities;

public class Enrollment extends AbstractEntity {

	private Student student;
	private Group group;
	public Enrollment(int id, Student student, Group group) {
		super(id);
		this.student = student;
		this.group = group;
	}
	
}
