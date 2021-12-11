package AppStart;

import Entities.Account;
import Repositories.GenericRepository;

public class Starter {

	public static void main(String[] args) {
		
		GenericRepository<Account> accountRepository = new GenericRepository<Account>();
		Account a = new Account();
		a.login = "szymon";
		a.password = "kub";
		accountRepository.create(a);
		
		var b = accountRepository.getAll();
	}

}
