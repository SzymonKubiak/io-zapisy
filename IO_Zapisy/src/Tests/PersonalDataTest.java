package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


import Entities.*;
import Factories.PersonFactory;
import Repositories.AccountRepository;
import Repositories.CompetencyRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactorySingleton;

@Category(TestEntity.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PersonalDataTest {

	PersonalDataRepository pdRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(PersonalDataRepository.class);
	CompetencyRepository coRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(CompetencyRepository.class);
	AccountRepository acRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(AccountRepository.class);
	PersonFactory personFactory = new PersonFactory();

	static TestData testData;

	@BeforeAll
	public static void initData() {
		testData = new TestData();
	}
	
	@Test
	void testAddCompetency() {
		
		int dataIndex = 0;
		PersonalData pd1 = personFactory.createTeacher(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], null);
		
		assertEquals(0, pd1.competencies.size(), 
				"Teacher created with no competencies should have 0");

		String[] competencies = {testData.competencies[0],testData.competencies[1],testData.competencies[2]};
		
		for (String comp : competencies) {
			pd1.addCompetency(comp);
		}
		assertEquals(3, pd1.competencies.size(), 
				"After adding 3 competencies, teacher should have all of them");
		
		String repeatedCompetency = testData.competencies[0];
		pd1.addCompetency(repeatedCompetency);
		
		assertEquals(3, pd1.competencies.size(), 
				"Should not add competency with the same name to the same teacher");
		
		TestData.cleanTablesAfterTest();
	}

	@Test
	void testRemoveCompetency() {
		
		PersonalData pd1 = createPersonAndAssignCompetencies();
		assertEquals(3, pd1.competencies.size());
		Competency c0 = pd1.competencies.get(0);
		Competency c1 = pd1.competencies.get(1);
		Competency c2 = pd1.competencies.get(2);
		
		pd1.removeCompetency(c1);
		assertEquals(2, pd1.competencies.size());
		
		pd1.removeCompetency(c0);
		pd1.removeCompetency(c2);
		assertEquals(0, pd1.competencies.size());
		
		TestData.cleanTablesAfterTest();
	}
	
	
	
	private PersonalData createPersonAndAssignCompetencies() {
		
		int dataIndex = 0;
		PersonalData pd1 = personFactory.createTeacher(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], null);
		
		String[] competencies = {testData.competencies[0],testData.competencies[1],testData.competencies[2]};
		
		for (String comp : competencies) {
			pd1.addCompetency(comp);
		}
		
		return pd1;
	}
	

}
