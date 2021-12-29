package AppStart;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entities.Account;
import Entities.Student;
import Facades.Facade;
import Repositories.AccountRepository;
import Repositories.GenericRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;
import Repositories.StudentRepository;

public class Starter {

	public static void main(String[] args) {
		
		RepositoryFactory repositoryFactory = RepositoryFactorySingleton.getInstance();
		/*
		Facade facade = new Facade(repositoryFactory);
		facade.createStudent("alogin", "pass", "name", "sunameee", "34232522", "02.10.3999", "997777", "Kalisz");
		
		*/
		StudentRepository sr = repositoryFactory.getRepository(StudentRepository.class);
		Student student = sr.getById(1);
		int a = student.id;
	}

}
