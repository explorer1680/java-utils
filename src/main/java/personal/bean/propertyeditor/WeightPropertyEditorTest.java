package personal.bean.propertyeditor;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;

public class WeightPropertyEditorTest {
	
	public static void main(String[] args) {

		//if WeightBeanInfo don't defined PropertyEditor, you should register with following code:
//		PropertyEditorManager.registerEditor(Weight.class, WeightEditor.class);
		PropertyEditor editor = PropertyEditorManager.findEditor(Weight.class);
		
        editor.setAsText("100.23KG");
        System.out.println(editor.getValue());
		
	}

}
