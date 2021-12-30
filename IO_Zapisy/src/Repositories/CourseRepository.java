package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Course;

public class CourseRepository extends GenericRepository<Course> {

	public CourseRepository() {
		super("Course");
	}

	@Override
	protected Course resultToObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS Course;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Course (")
	            .append("id int,")
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
	            .append("INSERT INTO Course VALUES (")
	            .append(e.id + ", ")
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
