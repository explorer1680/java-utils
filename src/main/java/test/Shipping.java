package test;

public class Shipping {
	public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
		int left = items;
		int largePackageUsed = 0;
		for (int i = 0; i < availableLargePackages; i++) {
			if (left >= 5) {
				left = left - 5;
				largePackageUsed++;
			} else {
				break;
			}
		}
		

		if (left <= availableSmallPackages) {
			return largePackageUsed + left;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		System.out.println(minimalNumberOfPackages(16, 2, 10));
	}
}