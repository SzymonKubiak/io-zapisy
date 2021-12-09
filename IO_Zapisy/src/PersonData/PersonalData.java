package PersonData;

public class PersonalData {
	private int id;
	private String name;
	private String PESEL;
	private String surname;
	private String address;
	private String phoneNumber;
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPESEL() {
		return PESEL;
	}

	public void setPESEL(String pESEL) {
		PESEL = pESEL;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public PersonalData(String [] data){
		this.name = data[0];
		this.surname = data[1];
		this.PESEL = data[2];
		this.address = data[3];
		this.phoneNumber = data[4];
		this.account = new Account();
	}

}
