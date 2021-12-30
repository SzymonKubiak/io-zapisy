package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import AppStart.DatabaseConnector;
import Entities.Classroom;
import Entities.Competency;
import Enums.RoomDestination;

public class CompetencyRepository extends GenericRepository<Competency> {

	public CompetencyRepository() {
		super("Competency");
	}

	@Override
	protected Competency resultToObject(ResultSet rs) {
		Competency cm = null;
		try {
			if(!rs.next()) return null;
			int id = rs.getInt("id");
			int teacherId = rs.getInt("teacherId");
			String name = rs.getString("name");
			cm = new Competency(id, teacherId, name);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cm;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE Competency;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Competency (")
	            .append("id int AUTOINCREMENT PRIMARY KEY,")
	            .append("teacherId int,")
	            .append("name varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
	}

	@Override
	protected String objectToInsertQuery(Competency e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Competencies (name, teacherId) VALUES (")
	            .append(e.name + ", ")
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
