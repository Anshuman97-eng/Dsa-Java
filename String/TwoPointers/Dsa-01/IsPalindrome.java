

public class IsPalindrome {

    // Check whether character is a letter or number
    static boolean isAlphaNumeric(char ch) {

        ch = Character.toLowerCase(ch);

        return (ch >= '0' && ch <= '9') ||
               (ch >= 'a' && ch <= 'z');
    }

    // Check palindrome
    static boolean palindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric from left
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }

            // Skip non-alphanumeric from right
            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }

            // Compare lowercase characters
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        System.out.println(palindrome(s));
    }
}