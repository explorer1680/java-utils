package personal.bean.propertyeditor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;

public class WeightBeanInfo extends SimpleBeanInfo {

//	private WeightEditor weightEditor = new WeightEditor();

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {

		PropertyDescriptor propertyDescriptor;
		try {
			propertyDescriptor = new PropertyDescriptor("weight", Weight.class, "getWeight", "setWeight");
//			{
//
//				@Override
//				public PropertyEditor createPropertyEditor(Object Bean) {
//					return weightEditor;
//				}
//			};
			
			//another way to do it:
//			propertyDescriptor.setPropertyEditorClass(WeightEditor.class);
			
			return new PropertyDescriptor[] { propertyDescriptor };

		} catch (IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
