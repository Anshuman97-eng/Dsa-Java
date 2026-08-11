public class ReverseVowels {

    // Check if character is a vowel
    static boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Reverse only vowels
    static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while(left < right && !isVowel(arr[left])){
                left++;
            }

            while(left < right && !isVowel(arr[right])){
                right--;
            }

            // swap them ....
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        // YOUR CODE

        return new String(arr);

    }

    public static void main(String[] args) {

        String s = "hello";

        System.out.println(reverseVowels(s));
    }
}