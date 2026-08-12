public class IsSubsequence {

    static boolean isSubsequence(String s, String t) {

        int i=0;
        int j=0;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        
        return i == s.length();
    }

    public static void main(String[] args) {

        //s is the string that we have to check and the t is the string in which we need to find the letter ...
        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
}