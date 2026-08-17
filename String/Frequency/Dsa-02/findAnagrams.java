

import java.util.*;

class Main {

    public static List<Integer> findAnagram(String s, String p) {
        // Your logic goes here

        int[] windowFreq = new int[26];
        int[] patFre  = new int[26];
        int left = 0;

        List<Integer> list = new ArrayList<>();

        for(char c : p.toCharArray()){
            patFre[c - 'a']++;
        }

        for(int right = 0 ; right < s.length() ; right++){
            char rightChar = s.charAt(right);
            windowFreq[rightChar - 'a']++;

            while(right - left + 1 > p.length()){
                char leftChar = s.charAt(left);
                windowFreq[leftChar - 'a']--;
                left++;
            }
            
            if(Arrays.equals(patFre, windowFreq)){
                list.add(left);
            }
        }
        return list;

    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagram(s, p));
    }
}