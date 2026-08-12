import java.util.HashSet;

public class LongestSubstringWithoutRepeating {

    static int lengthOfLongestSubstring(String s) {

        // Create HashSet
        HashSet<Character> set = new HashSet<>();

        // Create left pointer
        int left =0;
        

        // Create maxLength
        int maxLength = 0;
        

        // Sliding Window
        for (int right = 0; right < s.length(); right++) {

            // If duplicate → move left
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(right));
                left++;
            }
            
            // Add current character
            set.add(s.charAt(right)); 
            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
            
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}