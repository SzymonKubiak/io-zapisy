package Entities;

public class Student extends AbstractEntity {

	private PersonalData personalData;

	public Student(int id, PersonalData personalData) {
		super(id);
		this.personalData = personalData;
	}

	
}
