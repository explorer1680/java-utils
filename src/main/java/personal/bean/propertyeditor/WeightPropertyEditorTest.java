package personal.bean.propertyeditor;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

import personal.bean.propertyeditor.anotherpackage.WeightEditor;

public class WeightPropertyEditorTest {
	
	public static void main(String[] args) {

		//if WeightBeanInfo don't defined PropertyEditor, you should register with following code:
		PropertyEditorManager.registerEditor(Weight.class, WeightEditor.class);
		
		//Actually, since this WeightEditor is inside of the same package as Weight.class
		//it is registered automatically by PropertyEditorManager.
		PropertyEditor editor = PropertyEditorManager.findEditor(Weight.class);
		
        editor.setAsText("100.23KG");
        System.out.println(editor.getValue());
		
	}

}
