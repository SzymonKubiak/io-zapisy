package Repositories;

import java.sql.ResultSet;

import Entities.Teacher;

public class TeacherRepository extends GenericRepository<Teacher> {

	public TeacherRepository() {
		super("Teacher");
	}

	@Override
	protected Teacher resultToObject(ResultSet rs) {
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
		// TODO Auto-generated method stub
		
	}

}
