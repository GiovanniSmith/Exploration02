import java.time.Duration;
import java.time.Instant;

public class TestST extends TestWithCounter {


    @Override
    void runTest(int[] sequence) {
        TestST.resetCount();
        
        System.out.println("Algorithm: Hashing");

        Instant start = Instant.now();
        int answer = Hashing.nearlyIdentical(sequence);
        Instant end = Instant.now();

        long timeElapsed = Duration.between(start, end).toNanos();
        
        printMetrics(sequence, answer, timeElapsed);
    }
}