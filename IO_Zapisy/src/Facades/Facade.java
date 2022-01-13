package Facades;

import Entities.Account;
import Entities.Enrollment;
import Entities.Group;
import Entities.PersonalData;
import Factories.PersonFactory;
import Repositories.EnrollmentRepository;
import Repositories.GroupRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class Facade {

	RepositoryFactory repositoryFactory;
	PersonFactory personFactory;
	EnrollmentService enrollmentService;

	public PersonalData createStudent(String login, String password, String name, String surname, String PESEL,
			String phoneNumber, String address, int yearOfStudy, String educationSubject) {

		return personFactory.createStudent(login, password, name, surname, PESEL, phoneNumber, address, yearOfStudy,
				educationSubject);
	}

	public PersonalData createTeacher(String login, String password, String name, String surname, String PESEL,
			String phoneNumber, String address, String[] competencies) {

		return personFactory.createTeacher(login, password, name, surname, PESEL, phoneNumber, address, competencies);
	}

	public Enrollment enrollStudentToGroup(int studentId, int groupId) {

		EnrollmentRepository enrollmentRepo = repositoryFactory.getRepository(EnrollmentRepository.class);
		GroupRepository groupRepo = repositoryFactory.getRepository(GroupRepository.class);

		PersonalData student = personFactory.getPersonById(studentId);
		Group group = groupRepo.getById(groupId);

		boolean canEnroll = enrollmentService.doesStudentHaveRightsToGroup(student, group);

		if (canEnroll == false)
			return null;

		Enrollment enrollment = enrollmentRepo.create(new Enrollment(0, student, group));
		
		return enrollment;
	}
	
	public PersonalData editPersonalData(PersonalData p) {
		var personalRepo = this.repositoryFactory.getRepository(PersonalDataRepository.class);
		return personalRepo.update(p);
	}
	
	
	public Facade() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
		this.personFactory = new PersonFactory();
		this.enrollmentService = new EnrollmentService();

	}

}
