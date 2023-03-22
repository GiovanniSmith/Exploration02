import java.util.HashMap;

public class Hashing {
    public static int nearlyIdentical(int[] a) {
        // Initialize HashMap(key: integer, value: integer) H such that H(𝑎𝑘)=0 for all k
        HashMap<Integer, Integer> H = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            H.put(a[i], 0);
        }
        // find the number of occurrences of each value 𝑎𝑘
        for (int k = 0; k < a.length-1; k++) {
            int plusOne = H.get(a[k])+1;
            H.put(a[k], plusOne);
        }
        // current longest nearly identical subsequence
        int longest = 0;
        for (int key : H.keySet()) {
            // check for pairs that differ by one
            if (H.containsKey(key+1)) {
                longest = Math.max(longest, H.get(key) + H.get(key+1));
            }
        }

        return longest;
    }
}
