package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Enrollment;

public class EnrollmentRepository extends GenericRepository<Enrollment> {

	public EnrollmentRepository() {
		super("Enrollment");
	}

	@Override
	protected Enrollment resultToObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String objectToQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS Enrollment;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Enrollment (")
	            .append("id int,")
	            .append("studentId int,")
	            .append("groupId int")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		

	}

}
