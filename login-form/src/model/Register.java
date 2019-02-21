package model;

public class Register {
	
	private String email;
	private String password;
	private String dob;
	private String address;
	
	public Register(String email, String password, String dob, String address) {
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
