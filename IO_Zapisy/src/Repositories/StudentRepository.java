package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import AppStart.DatabaseConnector;
import Entities.PersonalData;
import Entities.Student;

public class StudentRepository extends GenericRepository<Student> {

	public StudentRepository() {
		super("Student");
	}

	@Override
	protected Student resultToObject(ResultSet rs) {
		Student st = null;
		try {
			if(!rs.next()) return null;
			int id = rs.getInt("id");
			int personalDataId = rs.getInt("personalDataId");
			PersonalDataRepository pdr = RepositoryFactorySingleton.getInstance().getRepository(PersonalDataRepository.class);
			PersonalData pd = pdr.getById(personalDataId);
			st = new Student(id, pd);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	protected String objectToQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Student (")
	            .append("id int,")
	            .append("personalDataId int")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
	}

}
