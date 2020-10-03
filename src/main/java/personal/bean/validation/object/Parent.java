package personal.bean.validation.object;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

public class Parent {
	
	@NotNull(groups=BasicInfo.class)
	private String name;
	@Min(groups=AdvanceInfo.class, value = 20)
	private int age;
	@NotNull
	@Valid	//has this or not is different when validate parent
	//toggle following comment, the result is different
	@ConvertGroup(from = AdvanceInfo.class, to = BasicInfo.class)
	private Child child;
	
	public Parent() {
		
	}
	
	public Parent(String name, int age, Child child) {
		super();
		this.name = name;
		this.age = age;
		this.child = child;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "Parent [name=" + name + ", age=" + age + ", child=" + child + "]";
	}
	
	
}
