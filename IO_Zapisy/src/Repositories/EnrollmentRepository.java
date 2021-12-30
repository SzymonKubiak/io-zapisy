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

	@Override
	protected String objectToInsertQuery(Enrollment e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Enrollment VALUES (")
	            .append(e.id + ", ")
	            .append(e.student.id + ", ")
	            .append(e.group.id)
	            .append(");");

		return sb.toString();
	}

	@Override
	protected String objectToUpdateQuery(Enrollment e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE Enrollment SET ")
	            .append("studentId = "+ e.student.id + ", ")
	            .append("groupId = "+e.group.id)
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();
	}

}
