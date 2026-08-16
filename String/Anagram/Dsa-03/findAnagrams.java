import java.util.*;

class Main {

    public static List<Integer> findAnagrams(String s, String t) {
        // Your logic here

        int left = 0;
        int[] freq = new int[26];
        int[] windowFreq = new int[26];
        ArrayList<Integer> result = new ArrayList<>();

        for(char ch : t.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int right = 0 ; right < s.length() ; right++){
            windowFreq[s.charAt(right) - 'a']++;

            if(right - left + 1 > t.length()){
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(windowFreq, freq)){
                result.add(left);
            }
        }


        return result;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}