package personal.gameoflife;

import java.util.Arrays;

public class Game {

	static String getPrintString(int i) {
		if (i == 0) {
			return "\u26AA";
		} else {
			return "\u26AB";
		}
	}
	
	static int getRandom(){
		double r =Math.random();
		if(r>0.5){
			return 1;
		}else{
			return 0;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int row = 70;
		int column = 130;
		int[][] matrix = new int[row][column];
		for(int i = 0; i<row; i++){
			for(int j= 0; j< column; j++){
				matrix[i][j] = Game.getRandom();
						
			}
		}
//		int[][] matrix = { 
//				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,0, 0, 1, 0, 0, 0, 0, 0, 1, 0 }, 
//				{ 1, 0, 0, 1, 1, 0, 0, 0, 1, 0,1, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
//				{ 1, 0, 0, 0, 0,1, 0, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0}, 
//				{ 0, 0, 0, 0,1, 0, 0, 0, 1, 0, 0, 0, 0, 0,1, 0, 0, 0, 1, 0}, 
//				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//				{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 0,0, 1, 0, 0, 0, 0, 0, 0, 1, 0 }, 
//				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,1, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
//				{ 1, 0, 0, 0, 0,1, 1, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0}, 
//				{ 0, 0, 0, 0,1, 0, 0, 0, 1, 0, 0, 0, 0, 0,1, 0, 0, 0, 1, 0}, 
//				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//				{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,0, 0, 0, 0, 1, 0, 0, 0, 1, 0 }, 
//				{ 1, 0, 1, 0, 0, 1, 0, 0, 1, 0,1, 0, 0, 1, 0, 0, 0, 0, 1, 0 },
//				{ 1, 0, 0, 0, 0,1, 0, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0}, 
//				{ 0, 0, 0, 0,1, 0, 1, 0, 1, 0, 0, 0, 1, 0,1, 0, 0, 0, 1, 0}, 
//				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//				{ 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0}, 
//				{ 0, 0, 0,1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0}, 
//				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
//				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 
//				{ 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0}
//				};

		int rows = matrix.length;
		
		System.out.println("");
		Arrays.stream(matrix).forEach(p -> {
			System.out.print(" ");
			Arrays.stream(p).mapToObj(e -> Game.getPrintString(e)).forEach(System.out::print);
			System.out.println("");
		});

		for (int k = 0; k < 50000; k++) {
			Thread.sleep(500);

			int[][] temp = new int[matrix.length + 2][matrix[0].length + 2];

			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[0].length; j++) {
					temp[i][j] = 0;
				}
			}

			for (int i = 1; i < temp.length - 1; i++) {
				for (int j = 1; j < temp[0].length - 1; j++) {
					temp[i][j] = matrix[i - 1][j - 1];
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					int total = temp[i][j] + temp[i][j + 1] + temp[i][j + 2] + temp[i + 1][j] + temp[i + 1][j + 2]
							+ temp[i + 2][j] + temp[i + 2][j + 1] + temp[i + 2][j + 2];
					if (matrix[i][j] == 1) {
						if (total < 2) {
							matrix[i][j] = 0;
						} else if (total == 2 || total == 3) {
							matrix[i][j] = 1;
						} else {
							matrix[i][j] = 0;
						}
					} else {
						if (total == 3) {
							matrix[i][j] = 1;
						}
					}
				}
			}

			System.out.print("\033[" +(rows+1) + "A\033[" + 0 + 'C');
			System.out.println(k);
			Arrays.stream(matrix).forEach(p -> {
				System.out.print(" ");
				Arrays.stream(p).mapToObj(e -> Game.getPrintString(e)).forEach(System.out::print);
				System.out.println("");
			});
		}
	}
}
