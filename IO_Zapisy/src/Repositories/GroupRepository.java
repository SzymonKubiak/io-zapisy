package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.Group;

public class GroupRepository extends GenericRepository<Group> {

	public GroupRepository() {
		super("Course_Group");
	}

	@Override
	protected Group resultToObject(ResultSet rs) {
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
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS course_group;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS course_group (")
	            .append("id int,")
	            .append("time_hour time,")
	            .append("day int,")
	            .append("courseId int,")
	            .append("classroomId int,")
	            .append("teacherId int")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
		
	}

}
