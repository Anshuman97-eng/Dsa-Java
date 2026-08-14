import java.util.*;

public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] strs) {

        // HashMap: key → group of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Traverse every word
        for (String s : strs) {

            // 1. Create frequency array
            int[] freq = new int[26];

            // 2. Count characters
            for (char ch : s.toCharArray()) {
                    freq[ch - 'a']++;
                // YOUR CODE    
            }

            // 3. Create unique key
            String key = Arrays.toString(freq);

            // 4. Create group if it doesn't exist
            // YOUR CODE
            map.putIfAbsent(key, new ArrayList<String>());

            // 5. Add word to group
            map.get(key).add(s);
            // YOUR CODE
        }

        // 6. Return all groups
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(groupAnagrams(strs));
    }
}