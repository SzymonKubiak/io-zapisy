package Factories;

import Entities.Account;
import Entities.PersonalData;
import Repositories.AccountRepository;
import Repositories.RepositoryFactory;

public class PersonFactory {
	
	RepositoryFactory repositoryFactory;

	public PersonalData createStudent(PersonalData personalData) {
		

		return null;
	}
	
	public PersonalData createTeacher(PersonalData personalData) {
		
		
		PersonalData teacher = null;
		
		return teacher;
		
	}
	
	public PersonFactory(RepositoryFactory repositoryFactory) {
		this.repositoryFactory = repositoryFactory;
		
	}
}
