import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BruteForce {

    private static int iterationCount;

    public static int nearlyIdentical(int[] a) {
        int longest = 0;
        
        for (int i = 0; i < a.length; i++) {
            int count = 0;

            boolean nextPresent = false;

            for (int j = 0; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                    iterationCount++;
                }
                else if( a[j] + 1 == a[i]) {
                    count++;
                    nextPresent = true;
                    iterationCount = iterationCount + 2;
                }
                else {
                    iterationCount = iterationCount + 2;
                }
            }

            if (nextPresent) {
                longest = count > longest ? count : longest;
                iterationCount++;
            }
        }

        return longest;
    }

    public static void metricLogger(int[] a, String algorithm) {

        iterationCount = 0;
        Instant start = Instant.now();
        int answer;
        if (algorithm.equals("BruteForce"))
            answer = nearlyIdentical(a);
        else
            answer = Hashing.nearlyIdentical(a);

        Instant end = Instant.now();

        long timeElapsed = Duration.between(start, end).toNanos();
        //System.out.print("\nArray: ");
        //printArray(a);
        System.out.println(algorithm + ": ");
        System.out.println("Length of array: " + a.length);
        System.out.println("Length of subsequence: " + answer);
        System.out.println("Time: " + timeElapsed);
        System.out.println("Comparisons: " + iterationCount + "\n");

    }

    private static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr1 = {8, 4, 3, 3, 6, 3, 4, 8};
        // int[] arr2 = {1, 2, 3, 4};
        // int[] arr3 = {5, 5, 5, 5};
        Random rand = new Random();

        int[][] arrayOfArrays = {new int[100], new int[1000], new int[10000], new int[100000]};
        
        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++)
                arrayOfArrays[i][j] = rand.nextInt(arrayOfArrays[i].length);
                metricLogger(arrayOfArrays[i], "BruteForce");
                metricLogger(arrayOfArrays[i], "Hashing");
        }
    }
}