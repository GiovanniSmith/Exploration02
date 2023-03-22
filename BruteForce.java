import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BruteForce {
    public static int nearlyIdentical(int[] a) {
        int longest = 0;
        
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            boolean nextPresent = false;

            for (int j = 0; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                    Main.increaseIterationCountBy(1);
                } else if (a[j] + 1 == a[i]) {
                    count++;
                    nextPresent = true;
                    Main.increaseIterationCountBy(2);
                } else {
                    Main.increaseIterationCountBy(3);
                }
            }
            if (nextPresent) {
                longest = count > longest ? count : longest;
                Main.increaseIterationCountBy(1);
            }
        }
        return longest;
    }
}