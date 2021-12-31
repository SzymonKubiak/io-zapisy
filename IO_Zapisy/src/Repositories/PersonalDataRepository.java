package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Account;
import Entities.Competency;
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
			final int id = rs.getInt("id");
			int accountId = rs.getInt("accountId");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			String pesel = rs.getString("pesel");
			String address = rs.getString("address");
			String phoneNumber = rs.getString("phoneNumber");
			Account account = RepositoryFactorySingleton.getInstance().getRepository(AccountRepository.class).getById(accountId);
			List<Competency> list = RepositoryFactorySingleton.getInstance().getRepository(CompetencyRepository.class).getAll();
			list = list.stream().filter(c-> c.teacherId == id).toList();
			pd = new PersonalData(id, name, surname, pesel, address, phoneNumber, account, list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	protected String objectToUpdateQuery(PersonalData e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE PersonalData SET ")
	            .append("name = \""+ e.name + "\", ")
	            .append("surname = \""+e.surname + "\", ")
	            .append("pesel = \""+e.PESEL + "\", ")
	            .append("address = \""+ e.address + "\", ")
	            .append("phoneNumber = \"" + e.phoneNumber + "\", ")
	            .append("accountId = \"" + e.account.id+ "\"")
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();
	}
	
	@Override
	protected String objectToInsertQuery(PersonalData e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO PersonalData (name, surname, pesel, address, phoneNumber, accountId) VALUES (")
	            .append("\"" + e.name + "\", ")
	            .append("\"" + e.surname+ "\", ")
	            .append("\"" + e.PESEL+ "\", ")
	            .append("\"" + e.address+ "\", ")
	            .append("\"" + e.phoneNumber + "\", ")
	            .append(e.account.id)
	            .append(");");

		return sb.toString();	
	}

	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS PersonalData;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS PersonalData (")
	            .append("id int AUTO_INCREMENT PRIMARY KEY,")
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
