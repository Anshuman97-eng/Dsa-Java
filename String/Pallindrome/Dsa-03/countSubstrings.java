class Main {

    public static int countSubstrings(String s) {
        // Your logic here

        int left = 0;
        int right = 0;
        int n = s.length() - 1;
        int count = 0;

        for(int i=0 ; i<=n ; i++ ){
            left = i;
            right = i;

            while(left >= 0 && right <= n && s.charAt(left) == s.charAt(right)){
                count++; //count pallindorme ...
                left--;
                right++;
            }

            left = i;
            right = i+1;


            while(left >=0 && right <=n && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String s = "aba";

        System.out.println(countSubstrings(s));
    }
}