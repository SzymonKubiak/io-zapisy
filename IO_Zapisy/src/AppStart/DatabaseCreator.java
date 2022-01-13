package AppStart;

import java.sql.Time;
import java.util.List;

import Entities.Account;
import Entities.Classroom;
import Entities.Competency;
import Entities.Course;
import Entities.Enrollment;
import Entities.Group;
import Entities.PersonalData;
import Enums.RoomDestination;
import Repositories.AccountRepository;
import Repositories.ClassroomRepository;
import Repositories.CompetencyRepository;
import Repositories.CourseRepository;
import Repositories.EnrollmentRepository;
import Repositories.GroupRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class DatabaseCreator {

	@SuppressWarnings("deprecation")
	public static void Seed() {
		RepositoryFactory rf = RepositoryFactorySingleton.getInstance();
		
		AccountRepository ar = rf.getRepository(AccountRepository.class);
		Account account1 = new Account(0,"szymon123", "pass", "user" );
		Account account2 = new Account(0,"grzegorz123", "pass","user" );
		Account account3 = new Account(0,"pawel123", "pass","user" );
		account1 = ar.create(account1);
		account2 = ar.create(account2);
		account3 = ar.create(account3);
		
		PersonalData pd1 = new PersonalData(0,"Szymon", "Kubiak", "0021234252352", "Wroclaw, Fabryczna 1", "123-232-231", account1, 3, "informatyka",  null);
		PersonalData pd2 = new PersonalData(0,"Grzegorz", "Litwiniuk", "00212998352", "Wroclaw, Fabryczna 4", "321-232-231", account2, 3, "informatyka techniczna", null);
		PersonalData pd3 = new PersonalData(0,"Pawel", "Rogalinski", "9421234252352", "Wroclaw, Fabryczna 8", "999-232-231", account3, 0, null, null);
		PersonalDataRepository pdr = rf.getRepository(PersonalDataRepository.class);
		pd1 = pdr.create(pd1);
		pd2 = pdr.create(pd2);
		pd3 = pdr.create(pd3);
		var list = pdr.getAll();
		
		Competency comp1 = new Competency(0, pd3.id, "Architektura Komputerów");
		Competency comp2 = new Competency(0, pd3.id, "Jezyki programowania");
		CompetencyRepository compr = rf.getRepository(CompetencyRepository.class);
		comp1 = compr.create(comp1);
		comp2 = compr.create(comp2);
		
		
		Classroom cr1 = new Classroom(0, RoomDestination.Laboratory, "C-1", "016", 15);
		ClassroomRepository crr = rf.getRepository(ClassroomRepository.class);
		cr1 = crr.create(cr1);
		
		cr1.building = "C-4";
		cr1 = crr.update(cr1);
		crr.delete(cr1);
		
		CourseRepository courseRepo = rf.getRepository(CourseRepository.class);
		Course course1 = new Course(0, RoomDestination.Laboratory, "Architektura Komputerów", "asembler itd", 3, "informatyka techniczna");
		course1 = courseRepo.create(course1);
		
		GroupRepository groupRepo =rf.getRepository(GroupRepository.class);
		Time time1 = new Time(13, 0, 0);
		Group group1 = new Group(0, pd3, time1, 1, course1, cr1);
		group1 = groupRepo.create(group1);
		
		EnrollmentRepository enrollmentRepo = rf.getRepository(EnrollmentRepository.class);
		Enrollment enrollement1 = new Enrollment(0, pd1, group1);
		enrollement1 = enrollmentRepo.create(enrollement1);
		int a =5;
		
	}
}
