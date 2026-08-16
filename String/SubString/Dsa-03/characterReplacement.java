
class Main {

    public static int characterReplacements(String s, int k) {
        int left = 0;
        int maxLen = 0;

        int[] freq = new int[26];
        int maxFreq = 0;

        for(int right = 0; right < s.length() ; right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while( (right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen , right -left + 1);
        }
        return maxLen;

    }

    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacements(s, k));
    }
}