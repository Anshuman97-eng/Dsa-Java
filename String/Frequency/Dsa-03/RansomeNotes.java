
public class RansomeNotes {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        // Your logic here

        for(char ch : magazine.toCharArray()){
            freq[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray()){
            freq[ch - 'a']--;
            if(freq[ch - 'a'] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "aab";
        String magazine = "aabbxyz";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}