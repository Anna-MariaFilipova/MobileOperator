package mobileOperator;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;

	User(String name, String email, String password, int id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) throws PasswordException {

		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
