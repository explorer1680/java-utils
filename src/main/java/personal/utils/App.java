package YeBaoLun;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int[] array = new int[190];
    	
    	
    	
    	for( int i1 = 0; i1 < 4; i1++){
    		for( int i2 =3; i2 < 7; i2++){
    			if(i2 == 3) i2 = 0;
    			for( int i3 = 6; i3 < 10; i3++){
    				if( i3 == 6 ) i3 = 0;
    				for( int i4 = 9; i4 < 13; i4++){
    					if (i4 == 9) i4 = 0;
    					for(int i5 = 12; i5 < 16; i5++){
    						if(i5 == 12) i5 = 0;
    						for(int i6 = 15; i6 < 19; i6++){
    							if(i6 ==15) i6 =0;
    							for( int i7 = 0; i7 < 4; i7++){
    					    		for( int i8 =3; i8 < 7; i8++){
    					    			if(i8 == 3) i8 = 0;
    					    			for( int i9 = 6; i9 < 10; i9++){
    					    				if( i9 == 6 ) i9 = 0;
    					    				for( int i10 = 9; i10 < 13; i10++){
    					    					if (i10 == 9) i10 = 0;
    					    					for(int i11 = 12; i11 < 16; i11++){
    					    						if(i11 == 12) i11 = 0;
    					    						for(int i12 = 15; i12 < 19; i12++){
    					    							if(i12 ==15) i12 =0;
    					    							for( int i13 = 0; i13 < 4; i13++){
    					    					    		for( int i14 =3; i14 < 7; i14++){
    					    					    			if(i14 == 3) i14 = 0;
    					    					    			for( int i15 = 6; i15 < 10; i15++){
    					    					    				if( i15 == 6 ) i15 = 0;
    					    					    				for( int i16 = 9; i16 < 13; i16++){
    					    					    					if (i16 == 9) i16 = 0;
    					    					    					for(int i17 = 12; i17 < 16; i17++){
    					    					    						if(i17 == 12) i17 = 0;
    					    					    						for(int i18 = 15; i18 < 19; i18++){
    					    					    							if(i18 ==15) i18 =0;
    					    					    							int j = i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17 + i18;
    					    					    							array[j]++;
    					    					    							for ( int k = 0; k < 190; k++ ){
    					    					    								System.out.print(array[k] + "; ");
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
