package Facades;

import Entities.Account;
import Entities.PersonalData;
import Factories.PersonFactory;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class Facade {
	
	RepositoryFactory repositoryFactory;
	PersonFactory personFactory;
	

	public PersonalData createStudent(String login, String password, String name, String surname, String PESEL, String dateOfBirth, String phoneNumber, String address) {
		
		return personFactory.createPerson(login, password, name, surname, PESEL, dateOfBirth, phoneNumber, address);
	}
	
	public Facade() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
		this.personFactory = new PersonFactory();
		
	}
	
}
