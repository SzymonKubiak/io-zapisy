package Repositories;

import java.sql.ResultSet;

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
	protected String objectToQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		// TODO Auto-generated method stub

	}

}
