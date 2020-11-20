package personal.bean.beaninfo.specialbean.anotherpackage;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.util.ArrayList;
import java.util.List;

import personal.bean.beaninfo.specialbean.Foo;

public class FooBeanInfo extends SimpleBeanInfo {


	public PropertyDescriptor[] getPropertyDescriptors(){

		List<PropertyDescriptor> list = new ArrayList<PropertyDescriptor>();
		try {
			PropertyDescriptor descriptor = new PropertyDescriptor("specialName", Foo.class, "getName", "setName");
			descriptor.setName("verySpecialName");
			
			list.add(descriptor);
		}catch(
		IntrospectionException ex)
		{
			ex.printStackTrace();
		}
		return list.toArray(new PropertyDescriptor[list.size()]);
	}
	
}
