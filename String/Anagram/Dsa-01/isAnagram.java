class Main {

    public static boolean isAnagram(String s, String t) {

        // Your logic here

        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(char ch : t.toCharArray()){
            freq[ch - 'a']--;
            if(freq[ch - 'a'] < 0){
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