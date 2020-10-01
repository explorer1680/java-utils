package personal.bean.propertyeditor;

public class Weight {
	
	private float amount;
	private String unit;

	
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public Weight(float amount, String unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}
	
	public Weight() {
		super();
	}
	
	@Override
	public String toString() {
		return "Weight [unit=" + unit + ", amount=" + amount + "]";
	}
	
	public Weight getWeight() {
		return new Weight(this.amount, this.unit);
	}
	
	public void setWeight(Weight weight) {
		this.amount = weight.amount;
		this.unit = weight.unit;
	}
}
