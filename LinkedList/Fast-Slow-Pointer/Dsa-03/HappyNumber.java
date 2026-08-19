public class HappyNumber {

    // Calculate sum of squares of digits
    public static int sumOfSquares(int n) {

        int sum = 0;

        // Write your logic here

        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n = n/10;
        }
        
        return sum;
    }

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        // Write your logic here

        while(true){
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));

            if(fast == 1 || slow == 1){
                return true;
            }

            if(fast == slow ){
                return false;
            }
        }
    }

    public static void main(String[] args) {

        int n = 19;

        System.out.println(isHappy(n));
    }
}