 class Main {

    public static boolean isPalindrome(String s) {

        // Your logic here
        int left = 0;
        int n = s.length() - 1;
        int right = n;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "racecar";

        System.out.println(isPalindrome(s));
    }
}