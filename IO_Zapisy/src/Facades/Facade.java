package Facades;

import Entities.Account;
import Entities.Enrollment;
import Entities.Group;
import Entities.PersonalData;
import Factories.PersonFactory;
import Repositories.EnrollmentRepository;
import Repositories.GroupRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class Facade {
	
	RepositoryFactory repositoryFactory;
	PersonFactory personFactory;
	EnrollmentService enrollmentService;
	

	public PersonalData createStudent(String login, String password, String name, String surname, String PESEL, String dateOfBirth, String phoneNumber, String address, int yearOfStudy, String educationSubject) {
		
		return personFactory.createPerson(login, password, name, surname, PESEL, dateOfBirth, phoneNumber, address, yearOfStudy,educationSubject);
	}
	
	public Enrollment enrollStudentToGroup(int studentId, int groupId) {
		
		EnrollmentRepository enrollmentRepo = repositoryFactory.getRepository(EnrollmentRepository.class);
		GroupRepository groupRepo = repositoryFactory.getRepository(GroupRepository.class);
		
		PersonalData student = personFactory.getPersonById(studentId);
		Group group =  groupRepo.getById(groupId);
		
		boolean canEnroll = enrollmentService.doesStudentHaveRightsToGroup(student, group);
		
		//TODO
		return null;
		
	}
	

	public Facade() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
		this.personFactory = new PersonFactory();
		this.enrollmentService = new EnrollmentService();
		
	}
	
}
