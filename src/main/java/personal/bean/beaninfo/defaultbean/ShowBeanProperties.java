package personal.bean.beaninfo.defaultbean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.BeanUtils;

public class ShowBeanProperties {

	public static void main(String[] args) {
		MyBean myBean = new MyBean();
		myBean.setName("Name");
		myBean.setAge(30);
		try {
			BeanInfo bi = Introspector.getBeanInfo(MyBean.class);
			PropertyDescriptor[] pds = bi.getPropertyDescriptors();
			for (int i = 0; i < pds.length; i++) {
				// Get property name
				String propName = pds[i].getName();
				System.out.print("property: " + propName + "," + "\t\t");
				if (!"class".equalsIgnoreCase(propName)) {
					String s = BeanUtils.getProperty(myBean, propName);
					System.out.println("value: " + s);
				} else {
					System.out.println("value: no value");
				}
			}
		} catch (java.beans.IntrospectionException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
