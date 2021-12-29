package Entities;

public class Account extends AbstractEntity {

	public String login;
	public String password;
	public Account(int id, String login, String password) {
		super(id);
		this.login = login;
		this.password = password;
	}
	

	
}
