package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Classroom;

public class ClassroomRepository extends GenericRepository<Classroom> {

	public ClassroomRepository() {
		super("Classroom");
	}

	@Override
	protected Classroom resultToObject(ResultSet rs) {
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
		DatabaseConnector.executeUpdate("DROP TABLE Classroom;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Classroom (")
	            .append("id int,")
	            .append("destination int,")
	            .append("building varchar(50),")
	            .append("roomId varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);

	}

}
