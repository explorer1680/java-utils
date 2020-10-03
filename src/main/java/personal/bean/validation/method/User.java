package personal.bean.validation.method;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private String name;
	private String email;
	private Address address;
	
	public String getName() {
		return name;
	}
	
	public void setName(@NotEmpty(message="Name may not be empty") String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(@Email(message = "Email must be a well-formed email address") String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(@NotNull(message="Address may not be null") @Valid Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", address=" + address + "]";
	}
}
