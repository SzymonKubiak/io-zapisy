package Facades;

import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;
import Entities.*;

public class EnrollmentService {
	
	RepositoryFactory repositoryFactory;

	public EnrollmentService() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
	}
	
	public boolean doesStudentHaveRightsToGroup(PersonalData student, Group group) {
		return false;
	}

}
