import java.util.*;

 class Main {

    public static int longestSubstring(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // 1. Add current character to map
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);


            // 2. If map.size() > k
            //    move left and decrease frequency
            while(map.size() > k){
                char ch =  s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
                left++;
            }


            // 4. Calculate window length
            maxLen = Math.max(maxLen, right-left + 1);

        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "aabac";
        int k = 2;

        System.out.println(longestSubstring(s, k));
    }
}