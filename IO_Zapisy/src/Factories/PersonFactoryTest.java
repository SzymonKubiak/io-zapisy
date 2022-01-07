package Factories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Entities.PersonalData;
import Repositories.*;

class PersonFactoryTest {

	PersonFactory p = new PersonFactory();
	AccountRepository accountRepository = RepositoryFactorySingleton.getInstance().getRepository(AccountRepository.class);
	PersonalDataRepository personalDataRepo = RepositoryFactorySingleton.getInstance().getRepository(PersonalDataRepository.class);
	@Test
	void createStudentTest() {

		PersonalData pd1 = p.createStudent("login1","pass", "name", "surname", "123456789", "505505505", "Wroclaw", 1, "informatyka techniczna");
		assertNotNull(pd1,"Utworzono studenta");
		
		PersonalData pd2 = p.createStudent("login1","pass", "name2", "surname2", "1234567892", "5055055052", "Wroclaw2", 1, "informatyka techniczna2");
		assertNull(pd2, "Nie mozna utworzyc studenta o takim samym loginie jak pd1");
		
		PersonalData pd3 = p.createStudent("login2","pass", "name2", "surname2", "123456789", "5055055052", "Wroclaw2", 1, "informatyka techniczna2");
		assertNull(pd3, "Nie mozna utworzyc studenta o takim samym PESELU jak pd1");
		
		//cleanup
		personalDataRepo.deleteAll();
		accountRepository.deleteAll();
		
	}
	@Test
	void getAllTest() {
		
		PersonalData pd1 = p.createStudent("login4","pass", "name", "surname", "1234567894", "505505505", "Wroclaw", 2, "informatyka techniczna");
		
		String [] competencies5 = {"architektura komputerów", "bazy danych"};
		PersonalData pd2 = p.createTeacher("login5", "pass", "name", "surname", "1234567895", "505505505", "Wroclaw", competencies5);

		List<PersonalData> allStudents = p.getAllStudents();
		List<PersonalData> allTeachers = p.getAllTeachers();
		
		assertEquals(allStudents.size(), 1);
		assertEquals(allTeachers.size(), 1);
		
		//cleanup
		personalDataRepo.deleteAll();
		accountRepository.deleteAll();
	}
	
	@Test
	void getByIdTest(){
		
		PersonalData pd1 = p.createStudent("login1","pass", "name", "surname", "123456789", "505505505", "Wroclaw", 1, "informatyka techniczna");
		int pd1Index = pd1.id;
		
		PersonalData pd2 = p.getPersonById(pd1Index);
		
		assertEquals(pd2.PESEL, pd1.PESEL);
		assertEquals(pd2.name, pd1.name);
		assertEquals(pd2.surname, pd1.surname);
		assertEquals(pd2.phoneNumber, pd1.phoneNumber);
		assertEquals(pd2.address, pd1.address);
		
		//cleanup
		personalDataRepo.deleteAll();
		accountRepository.deleteAll();
	}
	
	@Test
	void createTeacherTest(){
		String [] competencies = {"architektura komputerów", "bazy danych", "inzynieria oprogramowania"};
		PersonalData pd = p.createTeacher("login6", "pass", "name", "surname", "1234567896", "505505505", "Wroclaw", competencies);
		
		assertEquals(3, pd.competencies.size());

		//cleanup
		personalDataRepo.deleteAll();
		accountRepository.deleteAll();
	}
}
