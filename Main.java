import java.util.*;

public class Main {
    public static void main (String[] args) {
        Random rand = new Random();
        int[][] arrayOfArrays = {new int[100], new int[1000], new int[10000], new int[100000]};

        TestBF bf = new TestBF();
        TestST st = new TestST();

        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++)
                arrayOfArrays[i][j] = rand.nextInt(arrayOfArrays[i].length);
                bf.runTest(arrayOfArrays[i]);
                st.runTest(arrayOfArrays[i]);
        }
    }

    // private static void printArray(int[] a) {
    //     for (int i : a) {
    //         System.out.print(i + " ");
    //     }
    //     System.out.println();
    // }
}
