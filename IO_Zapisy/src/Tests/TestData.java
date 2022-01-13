package Tests;

import Repositories.*;


public class TestData {


		public String[] login = new String[]{ "login1", "login2", "login!!!@##", "l", "26337547775", "login6" };
		public String[] password = { "pass12345678", "pass2345#5432", "pass!!!@@##", "p", "23526345745","pass12345678" };
		public String[] name = { "szymon", "szymon1", "s", "1234", "@@#$@!", "maciej" };
		public String[] surname = { "kowalski", "kowalski1", "k", "1234", "@@#$@!","maciejewski" };
		public String[] pesel = { "1234567890123", "0987654321098", "abc", "!##", "brak peselu","1234567890123" };
		public String[] phone = { "233456789", "fds", "a!", "12", "brak", "21314153" };
		public String[] address = { "Wroclaw", "!!!@@@", "bds3fse", "   ", "Katowice", "Warszawa" };
		public int[] year = { 1, 2, 3, 0, -1, 1 };
		public String[] subject = { "informatyka", "elektronika", "abc123", "@#%%", null, "informatyka" };
		public String[] competencies = { "IO", "AK2", "PEA", "!@#", "123qwe123", "BD2" };
		
		public TestData() {
			
		}
		public static void cleanTablesAfterTest() {
			
			RepositoryFactory rf = RepositoryFactorySingleton.getInstance();
			PersonalDataRepository pdRepo = rf.getRepository(PersonalDataRepository.class);
			AccountRepository acRepo = rf.getRepository(AccountRepository.class);
			CompetencyRepository coRepo = rf.getRepository(CompetencyRepository.class);
			ClassroomRepository  clRepo = rf.getRepository(ClassroomRepository.class);
			GroupRepository  grRepo = rf.getRepository(GroupRepository.class);
			
			pdRepo.deleteAll();
			acRepo.deleteAll();
			coRepo.deleteAll();
			clRepo.deleteAll();
			grRepo.deleteAll();
		}

}
