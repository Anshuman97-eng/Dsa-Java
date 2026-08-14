import java.util.HashMap;

public class FirstUniqueCharacter {

    static int firstUniqChar(String s) {

        // 1. Create HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        // 2. Count frequency of each character
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) + 1);
            // YOUR CODE
        }

        // 3. Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        // 4. No unique character
        return -1;
    }

    public static void main(String[] args) {

        String s = "aabbccdeexyz";

        System.out.println(firstUniqChar(s));
    }
}