package AppStart;

import java.util.List;

import Entities.Account;
import Entities.Classroom;
import Entities.Competency;
import Entities.PersonalData;
import Enums.RoomDestination;
import Repositories.AccountRepository;
import Repositories.ClassroomRepository;
import Repositories.CompetencyRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class DatabaseCreator {

	public static void Seed() {
		RepositoryFactory rf = RepositoryFactorySingleton.getInstance();
		
		AccountRepository ar = rf.getRepository(AccountRepository.class);
		Account account1 = new Account(0,"szymon123", "pass" );
		Account account2 = new Account(0,"grzegorz123", "pass" );
		Account account3 = new Account(0,"pawel123", "pass" );
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
		
		Competency comp1 = new Competency(0, pd3.id, "Architektura Komputerów");
		Competency comp2 = new Competency(0, pd3.id, "Jezyki programowania");
		CompetencyRepository compr = rf.getRepository(CompetencyRepository.class);
		comp1 = compr.create(comp1);
		comp2 = compr.create(comp2);
		
		
		Classroom cr1 = new Classroom(0, RoomDestination.Laboratory, "C-1", "016");
		ClassroomRepository crr = rf.getRepository(ClassroomRepository.class);
		cr1 = crr.create(cr1);
		
		cr1.building = "C-4";
		cr1 = crr.update(cr1);
		crr.delete(cr1);
	}
}
