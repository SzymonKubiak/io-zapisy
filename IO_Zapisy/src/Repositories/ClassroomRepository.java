package Repositories;

import java.sql.ResultSet;

import Entities.AbstractEntity;
import Entities.Classroom;

public class ClassroomRepository extends GenericRepository<Classroom> {

	public ClassroomRepository() {
		super("Classroom");
	}

	@Override
	protected Classroom resultToObject(ResultSet rs) {
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
