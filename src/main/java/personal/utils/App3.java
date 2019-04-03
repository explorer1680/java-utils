package YeBaoLun;

public class App3 {
	public static void main(String[] args){
		long[] Summary = new long[190];
		long total = 0;
		
		int[] array1 = {0, 1, 2, 3};
		int[] array2 = {0, 4, 5, 6};
		int[] array3 = {0, 7, 8, 9};
		int[] array4 = {0, 10, 11, 12};
		int[] array5 = {0, 13, 14, 15};
		int[] array6 = {0, 16, 17, 18};
		int[] array7 = {0, 1, 2, 3};
		int[] array8 = {0, 4, 5, 6};
		int[] array9 = {0, 7, 8, 9};
		int[] array10 = {0, 10, 11, 12};
		int[] array11 = {0, 13, 14, 15};
		int[] array12 = {0, 16, 17, 18};
		int[] array13 = {0, 1, 2, 3};
		int[] array14 = {0, 4, 5, 6};
		int[] array15 = {0, 7, 8, 9};
		int[] array16 = {0, 10, 11, 12};
		int[] array17 = {0, 13, 14, 15};
		int[] array18 = {0, 16, 17, 18};
		
		for ( int i1 = 0; i1 < 4; i1++){
			for ( int i2 = 0; i2 < 4; i2++){
				for ( int i3 = 0; i3 < 4; i3++){
					for ( int i4 = 0; i4 < 4; i4++){
						for ( int i5 = 0; i5 < 4; i5++){
							for ( int i6 = 0; i6 < 4; i6++){
								for ( int i7 = 0; i7 < 4; i7++){
									for ( int i8 = 0; i8 < 4; i8++){
										for ( int i9 = 0; i9 < 4; i9++){
											for ( int i10 = 0; i10 < 4; i10++){
												for ( int i11 = 0; i11 < 4; i11++){
													for ( int i12 = 0; i12 < 4; i12++){
														for ( int i13 = 0; i13 < 4; i13++){
															for ( int i14 = 0; i14 < 4; i14++){
																for ( int i15 = 0; i15 < 4; i15++){
																	for ( int i16 = 0; i16 < 4; i16++){
																		for ( int i17 = 0; i17 < 4; i17++){
																			for ( int i18 = 0; i18 < 4; i18++){
																				int sum = 
																						array1[i1] + 
																						array2[i2] +
																						array3[i3] + 
																						array4[i4] +
																						array5[i5] + 
																						array6[i6] +
																						array7[i7] + 
																						array8[i8] +
																						array9[i9] + 
																						array10[i10] +
																						array11[i11] + 
																						array12[i12] +
																						array13[i13] + 
																						array14[i14] +
																						array15[i15] + 
																						array16[i16] +
																						array17[i17] + 
																						array18[i18];
																				Summary[sum]++;
																			}	
																		}
																	}	
																}	
															}	
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
//				for (int k = 0; k < 190; k++) {
//					System.out.print(Summary[k] + "; ");
//				}
//				System.out.print("\n");
			}
		}
		
		for ( int j = 0; j < 190; j ++){
			total += Summary[j];
		}
		System.out.println(total);
		for ( int j = 0; j < 190; j ++){
			float ratio = (float)Summary[j]/total;
			System.out.println(j + ": = " + Summary[j] + "; ratio : = " + ratio);
		} 
	}
}
