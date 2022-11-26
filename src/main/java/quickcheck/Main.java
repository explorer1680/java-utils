package quickcheck;

public class Main{
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*10));
		int[][] a = createMap(15);
//		System.out.println(arrayToString(a));
		printMap(a);
}

public static int[][] createMap(int n) { // n = number of walls in map
		int[][] rv = new int[10][10]; // create a new empty map
		int row, column;
		boolean b = true;

		// random you
		row = (int)(Math.random()*10); // determine random row location
		column = (int)(Math.random()*10); // random column location

		rv[row][column] = 1; // now YOU have a random location

		// random finish
		while (b) {
			row = (int)(Math.random()*10); 
			column = (int)(Math.random()*10);

			if (rv[row][column] == 0) { // found a unique location
				b = false; // exit loop
			}
		}
		rv[row][column] = 2;

		// n random walls
		while (n>0) {
			b = true;
			while (b) {
				row = (int)(Math.random()*10); 
				column = (int)(Math.random()*10);

				if ((rv[row][column] == 0)) { // found a unique location
					b = false; // exit loop
				}
			}
			rv[row][column] = 3;
//			System.out.println(n + ": " + row+ ": " + column);
			n--;
		}

		return rv;
       }

public static String getSymbol(int value) {
		String[] letters = {"_", "Y", "F", "*"};
		return letters[value];
	}

	public static void printMap(int[][] m) {
		for (int r=0; r<m.length; r++) {
			System.out.print("  "); // indent before every new row
			for (int c=0; c<m[r].length; c++)
				System.out.print(getSymbol(m[r][c]) + " "); // each row's symbols with space btwn
			System.out.print("\n"); // new line after every row
		}
	}

public static String arrayToString(int[] a) {
		if (a==null)
			return "null";
		String rv = "";
		for (int i=0; i<a.length; i++)
			if (i==0) // the first index
				rv += (a[i]); 
			else // all other indexes
				rv += ", " + (a[i]);
		return "{" + rv + "}"; // curly braces
	}
}
