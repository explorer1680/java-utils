package personal.bean.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeightEditor extends PropertyEditorSupport{
	
	@Override
	public String getAsText() {
		Weight weight = (Weight) getValue();
		return weight.toString();
	}
	
	@Override
	public void setAsText(String s) {
		Weight weight = null;
		Pattern p = Pattern.compile("\\p{L}");
		Matcher m = p.matcher(s);
		if (m.find()) {
			weight = new Weight(Float.parseFloat(s.substring(0, m.start())), s.substring(m.start()));
		}
		setValue(weight);
	}
}
