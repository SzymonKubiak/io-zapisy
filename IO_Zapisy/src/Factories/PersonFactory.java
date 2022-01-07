package Factories;

import java.util.ArrayList;
import java.util.List;

import Entities.Account;
import Entities.Competency;
import Entities.PersonalData;
import Repositories.AccountRepository;
import Repositories.PersonalDataRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class PersonFactory{

	RepositoryFactory repositoryFactory;
	AccountRepository accountRepository;
	PersonalDataRepository personalDataRepository;

	public PersonalData createPerson(String login, String password, String name, String surname, String PESEL,
		 String phoneNumber, String address, int yearOfStudy, String educationSubject,
			String[] competencies) {

		// check if login and pesel is unique
		List<Account> accounts = accountRepository.getAll();
		final String finalLogin = login;
		boolean loginAlreadyExists = accounts.stream().anyMatch(account -> account.login.equals(finalLogin));

		List<PersonalData> personalDataList = personalDataRepository.getAll();
		final String finalPesel = PESEL;
		boolean peselAlreadyExists = personalDataList.stream().anyMatch(pd -> pd.PESEL.equals(finalPesel));

		if (loginAlreadyExists || peselAlreadyExists)
			return null;

		Account account = new Account(0, login, password);
		PersonalData personalData = new PersonalData(0, name, surname, PESEL, address, phoneNumber, account,
				yearOfStudy, educationSubject, null);

		account = accountRepository.create(account);
		personalData = personalDataRepository.create(personalData);

		List<Competency> competenciesList = new ArrayList();

		if (competencies != null) {

			for (String competency : competencies) {
				personalData.addCompetency(competency);
			}
		}

		return personalData;
	}

	public PersonalData getPersonById(int id) {
		return personalDataRepository.getById(id);
	}
	
	public List<PersonalData> getAllStudents(){
		List<PersonalData> personalDataList = personalDataRepository.getAll();
		List<PersonalData> students = personalDataList.stream().filter(pd-> pd.yearOfStudy != 0).toList();
		return students;
	}
	
	public List<PersonalData> getAllTeachers(){
		List<PersonalData> personalDataList = personalDataRepository.getAll();
		List<PersonalData> teachers = personalDataList.stream().filter(pd-> pd.yearOfStudy == 0).toList();
		return teachers;
	}

	public PersonalData createStudent(String login, String password, String name, String surname, String PESEL,
			 String phoneNumber, String address, int yearOfStudy, String educationSubject) {

		return this.createPerson(login, password, name, surname, PESEL, phoneNumber, address, yearOfStudy,
				educationSubject, null);
	}

	public PersonalData createTeacher(String login, String password, String name, String surname, String PESEL,
			String phoneNumber, String address, String[] competencies) {

		return this.createPerson(login, password, name, surname, PESEL, phoneNumber, address, 0, null,
				competencies);
	}

	public PersonFactory() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
		this.accountRepository = repositoryFactory.getRepository(AccountRepository.class);
		this.personalDataRepository = repositoryFactory.getRepository(PersonalDataRepository.class);

	}


}
