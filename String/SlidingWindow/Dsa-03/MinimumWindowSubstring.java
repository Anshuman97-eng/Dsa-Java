public class MinimumWindowSubstring {

    static String minWindow(String s, String t) {

        // 1. Edge case
        if (s.length() < t.length()) {
            return "";
        }

        // 2. Frequency array
        int[] freq = new int[128];

        // 3. Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        // 4. Sliding window variables
        int left = 0;
        int right = 0;

        // 5. Number of characters still required
        int required = t.length();

        // 6. Answer variables
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        // 7. Expand window
        while (right < s.length()) {

            // Add s[right]
            char ch = s.charAt(right);

            if (freq[ch] > 0) {
                required--;
            }

            freq[ch]--;

            // YOUR CODE

            // 8. Shrink while window is valid
            while (required == 0) {

                // Update minimum window
                if ((right - left + 1) < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                // YOUR CODE

                // Remove s[left]
                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                // YOUR CODE
                left++;
            }

            right++;
        }

        // 9. No valid window
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        // 10. Return answer
        return s.substring(start, start + minLength);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}