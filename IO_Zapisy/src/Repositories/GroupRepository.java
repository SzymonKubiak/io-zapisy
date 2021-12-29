package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.Group;

public class GroupRepository extends GenericRepository<Group> {

	public GroupRepository() {
		super("Group");
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
		DatabaseConnector.executeUpdate("DROP TABLE Group;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Group (")
	            .append("id int,")
	            .append("date time,")
	            .append("day int,")
	            .append("courseId int,")
	            .append("classroomId int,")
	            .append("teacherId int")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
		
	}

}
