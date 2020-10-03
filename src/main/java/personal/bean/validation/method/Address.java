package personal.bean.validation.method;

import javax.validation.constraints.NotNull;

public class Address {
	
	@NotNull(message="Street Name can not be null")
	private String streetName;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	

}
