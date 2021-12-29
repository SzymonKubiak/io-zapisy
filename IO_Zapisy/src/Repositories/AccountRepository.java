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
			if(!rs.next()) return null;
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
	protected String objectToQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS Account;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Account (")
	            .append("id int,")
	            .append("login varchar(50),")
	            .append("password varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
	}
	
}
