package personal.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

import personal.sudoku.Line;

public class LineTest {
	
	@Test
	public void validateTest1(){
		Line line1 = new Line();
		assertTrue(line1.validate());
	}
	
	@Test
	public void validateTest2(){
		Line line1 = new Line();
		line1.setExclude(new int[]{3, 4, 5});
		line1.setLength(8);
		assertFalse(line1.validate());
	}

	@Test
	public void validateTest3(){
		Line line1 = new Line();
		line1.setInclude(new int[]{3, 4, 5,7});
		line1.setLength(8);
		assertFalse(line1.validate());
	}
	
	@Test
	public void validateTest4(){
		Line line1 = new Line();
		line1.setLength(10);
		assertFalse(line1.validate());
	}
	
	@Test
	public void getNumbersTest1(){
		Line line1 = new Line();
		line1.setExclude(new int[]{3, 5, 8});
		assertArrayEquals(new int[]{1,2,4,6,7,9}, line1.getNumbers());
	}
	
	@Test
	public void getNumbersTest2(){
		Line line1 = new Line();
		line1.setInclude(new int[]{3, 5, 8});
		assertArrayEquals(new int[]{3,5,8}, line1.getNumbers());
	}
	
	@Test
	public void getNumbersTest3(){
		Line line1 = new Line();
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, line1.getNumbers());
	}
}
