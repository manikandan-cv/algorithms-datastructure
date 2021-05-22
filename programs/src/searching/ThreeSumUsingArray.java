package searching;

/**
 * Given element of size N , find triplets whose sum is zero
 */
public class ThreeSumUsingArray {

    public static void main(String arg[]) {
        int[] elements = {10,1,2,4,-4,3,-6};
        findTriplets(elements);
    }


    /**
     * Time Taken : n^3
     * first loop : iterates N times
     * second loop : For every iteration in first loop , it iterates N times (so N * N )
     * thrid loop : For every iteration in second loop , it iterates N times (so (second_iterations=N*N) * N )
     * @param elements
     */
    private static void findTriplets(int[] elements) {
        if ( elements != null && elements.length > 0 ) {
            for (int i = 0; i < elements.length; i++) {
                for (int j = i+1; j < elements.length; j++) {
                    for (int k = j+1; k < elements.length; k++) {
                        if( elements[i] + elements[j] + elements[k] == 0 ) {
                            System.out.println("Indexes : " + i +","+ j +","+ k);
                        }
                    }
                }
            }
        }
    }

}
