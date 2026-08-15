

class Main {

    public static boolean isAnagram(String s, String t) {

        // 1. Create frequency array
        int[] freq = new int[26];


        // 2. Increase frequency for s
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }


        // 3. Decrease frequency for t
        for(char ch : t.toCharArray()){
            freq[ch - 'a']--;
        }


        // 4. Check if any frequency is not 0
        for(int n : freq){
            if(n != 0){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}