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
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS  Classroom;");
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

	@Override
	protected String objectToInsertQuery(Classroom e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Classroom VALUES (")
	            .append(e.id + ", ")
	            .append(e.destination + ", ")
	            .append(e.building + ", ")
	            .append(e.roomId)
	            .append(");");

		return sb.toString();	
	}

	@Override
	protected String objectToUpdateQuery(Classroom e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE Classroom SET ")
	            .append("destination = "+ e.destination + ", ")
	            .append("building = "+e.building + ", ")
	            .append("roomId = "+e.roomId)
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();	
	}

}
