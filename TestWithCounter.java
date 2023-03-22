public abstract class TestWithCounter {
    
    static long comparisonCount;

    abstract void runTest(int[] sequence);

    static long getCount() {
        return comparisonCount;
    }

    static void resetCount() {
        comparisonCount = 0;
    }

    void printMetrics(int[] sequence, int answer, long timeElapsed) {
        System.out.println("Length of array: " + sequence.length);
        System.out.println("Length of subsequence: " + answer);
        System.out.println("Time: " + timeElapsed);
        System.out.println("Comparisons: " + comparisonCount + "\n");
    }
}
