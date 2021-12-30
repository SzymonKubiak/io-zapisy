package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.Competency;

public class CompetencyRepository extends GenericRepository<Competency> {

	public CompetencyRepository() {
		super("Competency");
	}

	@Override
	protected Competency resultToObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE Competency;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Competency (")
	            .append("id int,")
	            .append("teacherId int,")
	            .append("name varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
	}

	@Override
	protected String objectToInsertQuery(Competency e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Competencies VALUES (")
	            .append(e.id + ", ")
	            .append(e.teacherId)
	            .append(");");

		return sb.toString();	
	}

	@Override
	protected String objectToUpdateQuery(Competency e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE Competencies SET ")
	            .append("name = "+ e.name + ", ")
	            .append("teacherId = "+e.teacherId)
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();
	}

}
