public class BruteForce {

    public static int nearlyIdentical(int[] a) {
        int longest = 0;
        
        for (int i = 0; i < a.length; i++) {

            TestBF.comparisonCount++;

            int count = 0;
            boolean nextPresent = false;

            for (int j = 0; j < a.length; j++) {

                TestBF.comparisonCount++;

                if (a[j] == a[i]) {
                    TestBF.comparisonCount++;
                    count++;
                } else if (a[j] + 1 == a[i]) {
                    TestBF.comparisonCount += 2;
                    count++;
                    nextPresent = true;
                } else {
                    TestBF.comparisonCount += 2;
                }
            }
            if (nextPresent) {
                longest = count > longest ? count : longest;
                TestBF.comparisonCount++;
            }
        }
        return longest;
    }
}