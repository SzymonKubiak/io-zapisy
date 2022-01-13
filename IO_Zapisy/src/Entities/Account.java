package Entities;

public class Account extends AbstractEntity {

	public String login;
	public String password;
	public String role;
	public Account(int id, String login, String password, String role) {
		super(id);
		this.login = login;
		this.password = password;
		this.role = role;
	}


	
}
