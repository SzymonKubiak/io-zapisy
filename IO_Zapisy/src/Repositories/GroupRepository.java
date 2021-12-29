package Repositories;

import java.sql.ResultSet;

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
		// TODO Auto-generated method stub
		
	}

}
