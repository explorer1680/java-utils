package YeBaoLun;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 * 
 */
public class App2 {
	public static void main(String[] args) {
		int[] array = new int[190];

		for (int i1 = 0; i1 < 4; i1++) {
			for (int i2 = 3; i2 < 7; i2++) {
				if (i2 == 3)
					i2 = 0;
				for (int i3 = 6; i3 < 10; i3++) {
					if (i3 == 6)
						i3 = 0;
					for (int i4 = 9; i4 < 13; i4++) {
						if (i4 == 9)
							i4 = 0;
						for (int i5 = 12; i5 < 16; i5++) {
							if (i5 == 12)
								i5 = 0;
							for (int i6 = 15; i6 < 19; i6++) {
								if (i6 == 15)
									i6 = 0;
								int j = i1 + i2 + i3 + i4 + i5 + i6;
								array[j]++;
								for (int k = 0; k < 190; k++) {
//									System.out.print(array[k] + "; ");
									float r = (float)array[k]/1000;
									System.out.println(r);
								}
								System.out.print("\n");
							}
						}
					}
				}
			}
		}
	}
}
