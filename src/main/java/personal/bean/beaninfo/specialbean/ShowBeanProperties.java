package personal.bean.beaninfo.specialbean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtils;


public class ShowBeanProperties {
	
	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.setName("$$$$$$$");
		foo.setAge(30);
		try {
			//if the BeanInfo is not in the same package, you should setup the search path.
			Introspector.setBeanInfoSearchPath(new String[] {"personal.bean.beaninfo.specialbean.anotherpackage"});
		    BeanInfo bi = Introspector.getBeanInfo(Foo.class);
		    PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		    for (int i=0; i<pds.length; i++) {
		        String propName = pds[i].getName();
		        System.out.print("property: " + propName + "," +  "\t\t");
				if (!"class".equalsIgnoreCase(propName)) {
					String s = BeanUtils.getProperty(foo, propName);
					System.out.println("value: " + s);
				} else {
					System.out.println("value: no value");
				}
		        
//		        String s = BeanUtils.getProperty(foo, propName);
//
//		        System.out.println("value: " + s);
		    }
		} catch (java.beans.IntrospectionException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("finished");
	}

}
