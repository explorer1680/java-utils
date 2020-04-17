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

	public static void main(String[] args) throws InterruptedException {
		int[][] matrix = { 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }
				};

		System.out.println("");
		Arrays.stream(matrix).forEach(p -> {
			System.out.print(" ");
			Arrays.stream(p).mapToObj(e -> Game.getPrintString(e)).forEach(System.out::print);
			System.out.println("");
		});

		for (int k = 0; k < 50; k++) {
			Thread.sleep(500);

			int[][] temp = new int[matrix.length + 2][matrix[0].length + 2];

			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					temp[i][j] = 0;
				}
			}

			for (int i = 1; i < temp.length - 1; i++) {
				for (int j = 1; j < temp[0].length - 1; j++) {
					temp[i][j] = matrix[i - 1][j - 1];
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
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

			System.out.print("\033[11A\033[" + 0 + 'C');
			System.out.println("");
			Arrays.stream(matrix).forEach(p -> {
				System.out.print(" ");
				Arrays.stream(p).mapToObj(e -> Game.getPrintString(e)).forEach(System.out::print);
				System.out.println("");
			});
		}
	}
}
