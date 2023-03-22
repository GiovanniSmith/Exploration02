import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class Main {
    private static int iterationCount;
    public static void main (String[] args) {
        Random rand = new Random();
        int[][] arrayOfArrays = {new int[100], new int[1000], new int[10000], new int[100000]};

        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++)
                arrayOfArrays[i][j] = rand.nextInt(arrayOfArrays[i].length);
                metricLogger(arrayOfArrays[i], "BruteForce");
                metricLogger(arrayOfArrays[i], "Hashing");
        }

    }
    public static void metricLogger(int[] a, String algorithm) {
        resetIterationCount();
        Instant start = Instant.now();
        int answer = 0;
        if (algorithm.equals("BruteForce"))
            answer = BruteForce.nearlyIdentical(a);
        else if (algorithm.equals("Hashing"))
            answer = Hashing.nearlyIdentical(a);
        else
            System.out.println("Error");

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
    public static void resetIterationCount() {
        iterationCount = 0;
    }
    public static int getIterationCount() {
        return iterationCount;
    }
    public static void increaseIterationCountBy(int integer) {
        iterationCount += integer;
    }
    private static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
