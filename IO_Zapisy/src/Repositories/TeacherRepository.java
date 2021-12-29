package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.Teacher;

public class TeacherRepository extends GenericRepository<Teacher> {

	public TeacherRepository() {
		super("Teacher");
	}

	@Override
	protected Teacher resultToObject(ResultSet rs) {
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
		DatabaseConnector.executeUpdate("DROP TABLE Teacher;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Teacher (")
	            .append("id int,")
	            .append("personalDataId int")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
		
	}

}
