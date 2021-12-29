package Entities;

import java.util.List;

public class PersonalData extends AbstractEntity {

	public String name;
	public String surname;
	public String PESEL;
	public String address;
	public String phoneNumber;
	public Account account;
	public List<Competency> competencies;
	public PersonalData(int id, String name, String surname, String pESEL, String address, String phoneNumber,
			Account account,List<Competency> competencies ) {
		super(id);
		this.name = name;
		this.surname = surname;
		PESEL = pESEL;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.competencies = competencies;
	}
	

	
}
