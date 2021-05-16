package searching;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String arg[]) {
        int[] a = {1,4,5,6,8,3,2,7};
        int elFound = findElementUsingWhileLoop(10, a);
        if ( elFound == 1 ) {
            System.out.println("Element Found ");
        } else {
            System.out.println("Element Not Found" );
        }
    }


    public static int findElementUsingWhileLoop(int el , int[] a) {
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;
        while ( high >= low ) {
            int middleIndex = ( high+ low ) / 2;
            if( el > a[middleIndex]) {
                low = middleIndex + 1;
            } else if ( el < a[middleIndex]) {
                high = middleIndex - 1;
            } else {
                return 1;
            }
        }
        return -1;
    }

}
