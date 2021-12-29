package Repositories;

import java.sql.ResultSet;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Account;

public class AccountRepository extends GenericRepository<Account> {

	public AccountRepository() {
		super("Account");
	}

	@Override
	protected Account resultToObject(ResultSet rs) {
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
	            .append("CREATE TABLE IF NOT EXISTS Account (")
	            .append("id int,")
	            .append("login varchar(50),")
	            .append("passsword varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);
		
	}
	
}
