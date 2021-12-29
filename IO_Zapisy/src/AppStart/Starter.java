package AppStart;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entities.Account;
import Facades.Facade;
import Repositories.AccountRepository;
import Repositories.GenericRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

public class Starter {

	public static void main(String[] args) {
		
		RepositoryFactory repositoryFactory = RepositoryFactorySingleton.getInstance();

		DatabaseCreator.Seed();
		
	}

}
