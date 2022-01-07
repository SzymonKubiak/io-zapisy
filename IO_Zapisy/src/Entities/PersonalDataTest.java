package Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Factories.PersonFactory;
import Repositories.AccountRepository;
import Repositories.CompetencyRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactorySingleton;

class PersonalDataTest {

	PersonalDataRepository pdRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(PersonalDataRepository.class);
	CompetencyRepository coRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(CompetencyRepository.class);
	AccountRepository acRepo = RepositoryFactorySingleton.getInstance()
			.getRepository(AccountRepository.class);
	PersonFactory personFactory = new PersonFactory();

	
	
	@Test
	void testAddCompetency() {
		
		PersonalData pd1 = personFactory.createTeacher("login", "pass", "name", "surname", "1222", "123", "wroclaw",
				null);
		assertEquals(0, pd1.competencies.size(), 
				"Teacher created with no competencies should have 0");

		String[] competencies = { "IO", "AK2", "BD2" };
		
		for (String comp : competencies) {
			pd1.addCompetency(comp);
		}
		assertEquals(3, pd1.competencies.size(), 
				"After adding 3 competencies, teacher should have all of them");
		
		String repeatedCompetency = "IO";
		pd1.addCompetency(repeatedCompetency);
		
		assertEquals(3, pd1.competencies.size(), 
				"Should not add competency with the same name to the same teacher");
		
		cleanTablesAfterTest();
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
		
		cleanTablesAfterTest();
	}
	
	
	
	private PersonalData createPersonAndAssignCompetencies() {
		
		PersonalData pd1 = personFactory.createTeacher("login", "pass", "name", "surname", "1222", "123", "wroclaw",
				null);
		
		String[] competencies = { "IO", "AK2", "BD2" };
		
		for (String comp : competencies) {
			pd1.addCompetency(comp);
		}
		
		return pd1;
	}
	
	private void cleanTablesAfterTest() {
		pdRepo.deleteAll();
		acRepo.deleteAll();
		coRepo.deleteAll();
	}

}
