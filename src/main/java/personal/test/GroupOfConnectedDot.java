package personal.test;

public class GroupOfConnectedDot {
	
	public static void main(String[] args){
		
		Integer matric[][] = new Integer[][]{
			{1,0,1,0,1,0,0,0},
			{1,0,1,0,0,1,0,0},
			{1,1,1,0,1,0,1,1},
			{0,0,0,1,1,0,0,0},
			{0,0,0,0,0,0,1,1},
			{1,1,1,0,1,0,0,0},
			{1,0,1,0,1,1,1,0},
			{1,1,1,0,1,0,0,1}
			};
		
		int result = 0;
		
		while(true){
			boolean oneExisted = findOne(matric);
			if(!oneExisted){
				break;
			}
			
			boolean runAgain = true;
			while(runAgain){
				boolean changedWhenMoveRight = moveRight(matric);
				
				boolean changedWhenMoveDown = moveDown(matric);
				
				boolean changedWhenMoveLeft = moveLeft(matric);
				
				boolean changedWhenMoveUp = moveUp(matric);
				
				runAgain=changedWhenMoveRight || changedWhenMoveDown || changedWhenMoveLeft || changedWhenMoveUp;
			}
			
			result += 1;
			
			showMatric(matric);
			removeTwo(matric);
			System.out.println(result);
			System.out.println();
		}
		
		System.out.println(result);
	}
	
	static void showMatric(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		for(int row=0; row<rowNum; row++){
			for(int column = 0; column<columnNum; column++){
				System.out.print(matric[row][column]);
			}
			System.out.println();
		}
	}
	
	static void removeTwo(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		for(int row=0; row<rowNum; row++){
			for(int column = 0; column<columnNum; column++){
				if(matric[row][column] == 2){
					matric[row][column] =0;
				}
			}
		}
	}
	
	static boolean findOne(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		for(int row=0; row<rowNum; row++){
			for(int column = 0; column<columnNum; column++){
				if(matric[row][column] == 1){
					matric[row][column] =2;
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean moveRight(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		boolean changed = false;
		
		for(int row=0; row<rowNum; row++){
			Integer previous = 0;
			for(int column = 0; column<columnNum; column++){
				if(matric[row][column] == 1 && previous ==2){
					matric[row][column] =2;
					changed = true;
				}
				previous = matric[row][column];
			}
		}
		return changed;
	}
	
	static boolean moveLeft(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		boolean changed = false;
		
		for(int row=rowNum-1; row>=0; row--){
			Integer previous = 0;
			for(int column = columnNum-1; column>=0; column--){
				if(matric[row][column] == 1 && previous ==2){
					matric[row][column] =2;
					changed = true;
				}
				previous = matric[row][column];
			}
		}
		return changed;
	}
	
	static boolean moveDown(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		boolean changed = false;
		
		for(int column = 0; column<columnNum; column++){
			Integer previous = 0;
			for(int row=0; row<rowNum; row++){
				if(matric[row][column] == 1 && previous ==2){
					matric[row][column] =2;
					changed = true;
				}
				previous = matric[row][column];
			}
		}
		return changed;
	}
	
	static boolean moveUp(Integer matric[][]){
		int rowNum =matric.length;
		int columnNum = matric[0].length;
		boolean changed = false;
		
		for(int column = columnNum-1; column>=0; column--){
			Integer previous = 0;
			for(int row=rowNum-1; row>=0; row--){
				if(matric[row][column] == 1 && previous ==2){
					matric[row][column] =2;
					changed = true;
				}
				previous = matric[row][column];
			}
		}
		return changed;
	}
}
