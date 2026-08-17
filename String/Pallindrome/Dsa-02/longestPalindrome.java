class Main {

    public static String longestPalindrome(String s) {
        // Your logic here

        int left =0;
        int right = 0;
        String ans="" ;

        for(int i=0 ; i<s.length() ; i++){
            left = i;
            right = i;

            while((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))){
                if(right - left +1 > ans.length()){
                    ans = s.substring(left,right+1);
                }

                left--;
                right++;
            }

            left = i;
            right = i+1;

            while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > ans.length()){
                    ans = s.substring(left,right+1);
                }

                left--;
                right++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}