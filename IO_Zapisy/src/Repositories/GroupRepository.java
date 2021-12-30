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

	@Override
	protected String objectToInsertQuery(Group e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO course_group VALUES (")
	            .append(e.id + ", ")
	            .append(e.time + ", ")
	            .append(e.day + ", ")
	            .append(e.course.id + ", ")
	            .append(e.classroom.id + ", ")
	            .append(e.teacher.id)
	            .append(");");

		return sb.toString();	
	}

	@Override
	protected String objectToUpdateQuery(Group e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE course_group SET ")
	            .append("time_hour = "+ e.time + ", ")
	            .append("day = "+e.day + ", ")
	            .append("courseId = "+e.course.id + ", ")
	            .append("classroomId = "+ e.classroom.id + ", ")
	            .append("teacherId = " + e.teacher.id)
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();
	}

}
