import java.util.*;

class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {

        // Your logic here
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs)
        {   
            int[] freq = new int[26];
            for(char ch : str.toCharArray()){
                freq[ch - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(groupAnagrams(strs));
    }
}