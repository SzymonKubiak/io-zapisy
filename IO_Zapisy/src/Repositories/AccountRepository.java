package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Account;
import Entities.PersonalData;

public class AccountRepository extends GenericRepository<Account> {

	public AccountRepository() {
		super("Account");
	}

	@Override
	protected Account resultToObject(ResultSet rs) {
		
		Account ac = null;
		try {
			int id = rs.getInt("id");
			String login = rs.getString("login");
			String password = rs.getString("password");
			ac = new Account(id, login, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ac;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS Account;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Account (")
	            .append("id int AUTO_INCREMENT PRIMARY KEY,")
	            .append("login varchar(50),")
	            .append("password varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
	}

	@Override
	protected String objectToInsertQuery(Account e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Account (login, password) VALUES (")
	            .append("\"" + e.login + "\", ")
	            .append("\"" +e.password+ "\"")
	            .append(");");

		return sb.toString();
	}

	@Override
	protected String objectToUpdateQuery(Account e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE Account SET ")
	            .append("login = \""+ e.login +"\", ")
	            .append("password = \""+e.password+ "\"")
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();
	}
	
}
