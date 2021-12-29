package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.PersonalData;

public class PersonalDataRepository extends GenericRepository<PersonalData> {

	public PersonalDataRepository() {
		super("PersonalData");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PersonalData resultToObject(ResultSet rs) {
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
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS PersonalData (")
	            .append("id int,")
	            .append("name varchar(50),")
	            .append("surname varchar(50),")
	            .append("PESEL varchar(15),")
	            .append("address varchar(255),")
	            .append("phoneNumber varchar(15),")
	            .append("accountId int")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);

	}

}
