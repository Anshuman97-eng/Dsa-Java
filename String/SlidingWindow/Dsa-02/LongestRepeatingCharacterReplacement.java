public class LongestRepeatingCharacterReplacement {

    static int characterReplacement(String s, int k) {

        // Frequency array
        int[] freq = new int[26];

        // Two pointers
        int left = 0;
        int right = 0;

        // Track most frequent character
        int maxFreq = 0;

        // Track maximum window
        int maxLength = 0;

        // Sliding Window
        while (right < s.length()) {

            // 1. Add s[right]
            freq[s.charAt(right) - 'A']++;
            
            
            // 2. Update maxFreq
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            
            
            // 3. Check if window is invalid
            //    windowSize - maxFreq > k

            while((right - left + 1) - maxFreq > k ){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            
            // 5. Update maxLength
            maxLength = Math.max(maxLength, right-left+1);
            
            // 6. Move right
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}