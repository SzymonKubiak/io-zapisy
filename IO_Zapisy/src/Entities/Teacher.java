package Entities;

import java.util.List;

public class Teacher extends AbstractEntity {

	private PersonalData personalData;
	private List<Course> competencies;
	public Teacher(int id, PersonalData personalData, List<Course> competencies) {
		super(id);
		this.personalData = personalData;
		this.competencies = competencies;
	}
	
	
}
