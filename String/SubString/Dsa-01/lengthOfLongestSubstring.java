import java.util.*;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstrings(String s) {

        // Your logic here
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0; 

        for(int right = 0; right < s.length() ; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen,right - left + 1);
        }

        return maxLen;

    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstrings(s));
    }
}