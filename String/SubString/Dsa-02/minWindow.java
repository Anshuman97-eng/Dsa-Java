import java.util.*;

class minWindow {

 public static String minWindows(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Frequency of characters required
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int have = 0;
        int required = need.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Sliding Window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Required frequency reached
            if (need.containsKey(ch)
                    && window.get(ch).equals(need.get(ch))) {
                have++;
            }

            // Window is valid → shrink it
            while (have == required) {

                // Save smallest window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                // Window became invalid
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindows(s, t));
    }
}