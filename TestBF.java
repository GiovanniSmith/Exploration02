import java.time.Duration;
import java.time.Instant;

public class TestBF extends TestWithCounter {


    @Override
    public long[] runTest(int[] sequence) {
        TestBF.resetCount();

        System.out.println("Algorithm: Brute Force");

        Instant start = Instant.now();
        int answer = BruteForce.nearlyIdentical(sequence);
        Instant end = Instant.now();

        long timeElapsed = Duration.between(start, end).toNanos();

        printMetrics(sequence, answer, timeElapsed);

        return new long[] {timeElapsed, comparisonCount};
    }
}