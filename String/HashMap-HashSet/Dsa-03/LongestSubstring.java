import java.util.HashMap;

public class LongestSubstring {

    static int lengthOfLongestSubstring(String s) {

        // 1. Create HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        // 2. Two pointers
        int left = 0;
        int maxLength = 0;

        // 3. Expand window
        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // 4. Check if character already exists
            if (map.containsKey(ch)) {
                left =  Math.max(left, map.get(ch) + 1);
                // Move left
            }

            // 5. Store latest index
            map.put(ch, right);
            // YOUR CODE

            // 6. Calculate maximum length
            maxLength = Math.max(maxLength, right - left + 1);
            // YOUR CODE
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}