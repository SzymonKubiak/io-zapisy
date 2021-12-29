package Facades;

import Entities.Account;
import Entities.PersonalData;
import Factories.PersonFactory;
import Repositories.RepositoryFactory;

public class Facade {
	
	RepositoryFactory repositoryFactory;
	PersonFactory personFactory;
	

	public PersonalData createStudent(String login, String password, String name, String surname, String PESEL, String dateOfBirth, String phoneNumber, String address) {
		
		Account account = null;//new Account(login, password);
		PersonalData pd = null;//new PersonalData(name, surname, PESEL, address, phoneNumber, account);
		return personFactory.createStudent(pd);
		
	}
	
	public Facade(RepositoryFactory repositoryFactory) {
		this.repositoryFactory = repositoryFactory;
		this.personFactory = new PersonFactory(repositoryFactory);
		
	}
	
}
