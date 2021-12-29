package Factories;

import Entities.Account;
import Entities.PersonalData;
import Entities.Student;
import Entities.Teacher;
import Repositories.AccountRepository;
import Repositories.RepositoryFactory;

public class PersonFactory {
	
	RepositoryFactory repositoryFactory;

	public Student createStudent(PersonalData personalData) {
		
		AccountRepository accountRepo = repositoryFactory.getRepository(AccountRepository.class);
		accountRepo.findByFieldValue("login", "Szymon");
		
		Student student = new Student(1, null);
		return student;
	}
	
	public Teacher createTeacher(PersonalData personalData) {
		
		
		Teacher teacher = null;
		
		return teacher;
		
	}
	
	public PersonFactory(RepositoryFactory repositoryFactory) {
		this.repositoryFactory = repositoryFactory;
		
	}
}
