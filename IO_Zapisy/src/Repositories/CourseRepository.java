package Repositories;

import java.sql.ResultSet;

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
	protected String objectToQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		// TODO Auto-generated method stub

	}

}
