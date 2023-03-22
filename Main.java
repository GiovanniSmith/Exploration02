import java.util.*;

public class Main {
    
    static int[][] arrayOfArrays = new int[10][];
    public static void main (String[] args) {

        for (int i = 0; i < arrayOfArrays.length; i++) {
            arrayOfArrays[i] = new int[(i+1)*10000]; 
        }
        Random rand = new Random();

        TestBF bf = new TestBF();
        TestST st = new TestST();

        long[][][] testData = new long[arrayOfArrays.length][2][2];

        for (int i = 0; i < arrayOfArrays.length; i++) {

            for (int j = 0; j < arrayOfArrays[i].length; j++) {
                arrayOfArrays[i][j] = rand.nextInt(arrayOfArrays[i].length);
            }
            testData[i][0] = bf.runTest(arrayOfArrays[i]);
            testData[i][1] = st.runTest(arrayOfArrays[i]);
        }

        parseTestData(testData);

    }

    static void parseTestData(long[][][] testData) {
        for (int i = 0; i < testData.length; i++) {
            System.out.println();
            System.out.println("Sequence length:\t\t" + arrayOfArrays[i].length);
            System.out.println("\nHashing Time:\t\t\t" + testData[i][1][0]);
            System.out.println("BruteForce Time:\t\t" + testData[i][0][0]);
            System.out.println("\nHashing Comparison Count:\t" + testData[i][1][1]);
            System.out.println("BruteForce Comparison Count:\t" + testData[i][0][1]);
            System.out.println();
        }
    }
    // private static void printArray(int[] a) {
    //     for (int i : a) {
    //         System.out.print(i + " ");
    //     }
    //     System.out.println();
    // }
}
