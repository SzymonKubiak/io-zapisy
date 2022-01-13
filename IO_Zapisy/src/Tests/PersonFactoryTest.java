package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import Entities.PersonalData;
import Factories.PersonFactory;
import Repositories.*;

@Category(TestFactories.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PersonFactoryTest {

	PersonFactory p = new PersonFactory();
	AccountRepository accountRepository = RepositoryFactorySingleton.getInstance()
			.getRepository(AccountRepository.class);
	PersonalDataRepository personalDataRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(PersonalDataRepository.class);
	static TestData testData;

	@BeforeAll
	public static void initData() {
		testData = new TestData();
	}

	@Test
	void createStudentTest() {
		int dataIndex = 0;
		PersonalData pd1 = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], testData.year[dataIndex],
				testData.subject[dataIndex]);
		assertNotNull(pd1, "Utworzono studenta");

		PersonalData pd2 = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], testData.year[dataIndex],
				testData.subject[dataIndex]);
		assertNull(pd2, "Nie mozna utworzyc studenta o takim samym loginie jak pd1");

		dataIndex = 1;
		PersonalData pd3 = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex - 1],
				testData.phone[dataIndex], testData.address[dataIndex], testData.year[dataIndex],
				testData.subject[dataIndex]);
		assertNull(pd3, "Nie mozna utworzyc studenta o takim samym PESELU jak pd1");

		assertThrows(IllegalArgumentException.class, () -> {
			int dataId = 2;
			p.createStudent(testData.login[dataId], testData.password[dataId], testData.name[dataId],
					testData.surname[dataId], testData.pesel[dataId], testData.phone[dataId], testData.address[dataId],
					testData.year[dataId], testData.subject[dataId]);

		});
		
		TestData.cleanTablesAfterTest();
	}

	@Test
	void getAllTest() {

		int dataIndex = 0;
		PersonalData st = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], testData.year[dataIndex],
				testData.subject[dataIndex]);

		dataIndex = 1;
		PersonalData te = p.createTeacher(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], null);
		assertNotNull(te);

		List<PersonalData> allStudents = p.getAllStudents();
		List<PersonalData> allTeachers = p.getAllTeachers();

		assertEquals(allStudents.size(), 1);
		assertEquals(allTeachers.size(), 1);

		TestData.cleanTablesAfterTest();
	}

	@Test
	void getByIdTest() {

		int dataIndex = 0;
		PersonalData pd1 = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], testData.year[dataIndex],
				testData.subject[dataIndex]);
		int pd1Index = pd1.id;

		PersonalData pd2 = p.getPersonById(pd1Index);

		assertEquals(pd2.PESEL, pd1.PESEL);
		assertEquals(pd2.name, pd1.name);
		assertEquals(pd2.surname, pd1.surname);
		assertEquals(pd2.phoneNumber, pd1.phoneNumber);
		assertEquals(pd2.address, pd1.address);

		TestData.cleanTablesAfterTest();
	}

	@Test
	void createTeacherTest() {
		int dataIndex = 0;
		PersonalData pd = p.createTeacher(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], null);
		assertNotNull(pd);

		pd = p.createTeacher(testData.login[dataIndex], testData.password[dataIndex], testData.name[dataIndex],
				testData.surname[dataIndex], testData.pesel[dataIndex], testData.phone[dataIndex],
				testData.address[dataIndex], null);
		assertNull(pd);

		dataIndex = 1;
		String[] competencies = { testData.competencies[0], testData.competencies[1], testData.competencies[2] };
		PersonalData pd1 = p.createTeacher(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], competencies);
		assertNotNull(pd1);

		assertEquals(3, pd1.competencies.size());

		TestData.cleanTablesAfterTest();
	}
}
