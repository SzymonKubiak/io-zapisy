package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Competency;
import Entities.Course;
import Enums.RoomDestination;

public class CourseRepository extends GenericRepository<Course> {

	public CourseRepository() {
		super("Course");
	}

	@Override
	protected Course resultToObject(ResultSet rs) {
		Course co = null;
		try {
			if(!rs.next()) return null;
			int id = rs.getInt("id");
			int requiredRoom = rs.getInt("requiredRoom");
			String title = rs.getString("title");
			String description = rs.getString("description");
			co = new Course(id, RoomDestination.toEnum(requiredRoom), title, description);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return co;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS Course;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Course (")
	            .append("id int AUTOINCREMENT PRIMARY KEY,")
	            .append("requiredRoom int,")
	            .append("title varchar(50),")
	            .append("description varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
	}

	@Override
	protected String objectToInsertQuery(Course e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Course (requiredRoom, title, description) VALUES (")
	            .append(e.requiredRoom + ", ")
	            .append(e.title + ", ")
	            .append(e.description)
	            .append(");");

		return sb.toString();
	}

	@Override
	protected String objectToUpdateQuery(Course e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE Course SET ")
	            .append("requiredRoom = "+ e.requiredRoom + ", ")
	            .append("title = "+e.title + ", ")
	            .append("description = "+e.description)
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();
	}

}
