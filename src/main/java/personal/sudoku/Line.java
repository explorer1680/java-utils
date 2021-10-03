package personal.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private int target;
	private int[] include;
	private int[] exclude;
	private int length;
	
	private List<int[]> result = new ArrayList<int[]>();
	
	public boolean validate(){
		if(this.length > 9){
			return false;
		}
		if(include !=null && include.length !=0 && include.length < this.length){
			return false;
		}else if(exclude != null && exclude.length !=0 && (9- exclude.length) < this.length){
			return false;
		}
		return true;
	}

	public int[] getNumbers(){
		if(include!=null && include.length > 0){
			return include;
		}else if(exclude != null && exclude.length > 0){
			int[] numbers = new int[9-exclude.length];
			System.out.println(numbers.length);
			int k = 0;
			for(int i = 1; i < 10; i++){
				boolean contains = false;
				for(int j = 0; j < exclude.length; j++){
					if(i == exclude[j]){
						contains = true;
						continue;
					}
				}
				if(!contains){
					numbers[k] = i;
					System.out.println(i);
					k++;
				}
			}
			return numbers;
		}else{
			return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		}
	}
	
	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int[] getInclude() {
		return include;
	}

	public void setInclude(int[] include) {
		this.include = include;
	}

	public int[] getExclude() {
		return exclude;
	}

	public void setExclude(int[] exclude) {
		this.exclude = exclude;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<int[]> getResult() {
		return result;
	}

	public void setResult(List<int[]> result) {
		this.result = result;
	}
}
