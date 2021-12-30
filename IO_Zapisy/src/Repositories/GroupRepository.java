package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import AppStart.DatabaseConnector;
import Entities.Classroom;
import Entities.Course;
import Entities.Enrollment;
import Entities.Group;
import Entities.PersonalData;

public class GroupRepository extends GenericRepository<Group> {

	public GroupRepository() {
		super("Course_Group");
	}

	@Override
	protected Group resultToObject(ResultSet rs) {
		Group gr = null;
		try {
			if(!rs.next()) return null;
			int id = rs.getInt("id");
			int teacherId = rs.getInt("teacherId");
			PersonalData pd = RepositoryFactorySingleton.getInstance().getRepository(PersonalDataRepository.class).getById(teacherId);
			Time time = rs.getTime("time_hour");
			int day = rs.getInt("day");
			int courseId = rs.getInt("courseId");
			Course co = RepositoryFactorySingleton.getInstance().getRepository(CourseRepository.class).getById(courseId);
			
			int classroomId = rs.getInt("classroomId");
			Classroom cl = RepositoryFactorySingleton.getInstance().getRepository(ClassroomRepository.class).getById(classroomId);
			
			gr = new Group(id, pd, time, day, co, cl);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gr;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS course_group;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS course_group (")
	            .append("id int AUTOINCREMENT PRIMARY KEY,")
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
	            .append("INSERT INTO course_group (time, day, courseId, ClassroomId, teacherId) VALUES (")
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
