package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Account;
import Entities.PersonalData;

public class PersonalDataRepository extends GenericRepository<PersonalData> {

	public PersonalDataRepository() {
		super("PersonalData");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PersonalData resultToObject(ResultSet rs) {
		PersonalData pd = null;
		try {
			if(!rs.next()) return null;
			int id = rs.getInt("id");
			int accountId = rs.getInt("accountId");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String pesel = rs.getString("pesel");
			String address = rs.getString("address");
			String phoneNumber = rs.getString("phoneNumber");
			Account account = RepositoryFactorySingleton.getInstance().getRepository(AccountRepository.class).getById(accountId);
			pd = new PersonalData(id, name, surname, pesel, address, phoneNumber, account);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	protected String objectToQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS PersonalData;");
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
