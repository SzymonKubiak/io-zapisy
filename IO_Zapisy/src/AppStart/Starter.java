package AppStart;

import Entities.Account;
import Repositories.AccountRepository;
import Repositories.GenericRepository;
import Repositories.RepositoryFactory;

public class Starter {

	public static void main(String[] args) {
		
		RepositoryFactory repositoryFactory = new RepositoryFactory();
		
		var repo = repositoryFactory.getRepository(AccountRepository.class);
		
	}

}
