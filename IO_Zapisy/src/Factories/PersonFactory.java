package Factories;

import java.util.List;

import Entities.Account;
import Entities.PersonalData;
import Repositories.AccountRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class PersonFactory {
	
	RepositoryFactory repositoryFactory;
	AccountRepository accountRepository;
	PersonalDataRepository personalDataRepository;

	public PersonalData createPerson(String login, String password, String name, String surname, String PESEL, String dateOfBirth, String phoneNumber, String address, int yearOfStudy, String educationSubject) {
		
		// check if login and pesel is unique
		List<Account> accounts = accountRepository.getAll();
		final String finalLogin = login;
		boolean loginAlreadyExists = accounts.stream().anyMatch(account-> account.login.equals(finalLogin));
		
		List<PersonalData> personalDataList = personalDataRepository.getAll();
		final String finalPesel = PESEL;
		boolean peselAlreadyExists = personalDataList.stream().anyMatch(pd-> pd.PESEL.equals(finalPesel));
		
		if(loginAlreadyExists || peselAlreadyExists) return null;
		
		Account account = new Account(0, login, password);
		PersonalData personalData = new PersonalData(0, name, surname, PESEL, address, phoneNumber, account,yearOfStudy,educationSubject, null);
		
		account = accountRepository.create(account);
		personalData = personalDataRepository.create(personalData);
		
		return personalData;
	}
	
	public PersonalData getPersonById(int id) {
		return personalDataRepository.getById(id);
	}
	
	
	public PersonFactory() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
		this.accountRepository = repositoryFactory.getRepository(AccountRepository.class);
		this.personalDataRepository = repositoryFactory.getRepository(PersonalDataRepository.class);
		
	}
}
