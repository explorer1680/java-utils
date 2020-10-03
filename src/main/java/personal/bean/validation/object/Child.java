package personal.bean.validation.object;

import javax.validation.constraints.NotNull;

public class Child {
	
	@NotNull(groups=BasicInfo.class)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Child [name=" + name + "]";
	}
}
