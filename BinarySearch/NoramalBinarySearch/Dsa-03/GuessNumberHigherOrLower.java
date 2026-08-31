// Question: Guess Number Higher or Lower (LeetCode 374)
public class GuessNumberHigherOrLower {
    private int secret = 6;

    int guess(int num) {
        if (secret < num) return -1;
        if (secret > num) return 1;
        return 0;
    }

    public int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            // 👉 write your binary search logic here
            int mid = low + (high - low) / 2;
            int res = guess(mid);

            if(res == 0){
                return mid;
            }else if(res < 0){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }

        return -1; // placeholder
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower obj = new GuessNumberHigherOrLower();
        System.out.println(obj.guessNumber(10)); 
        // Example: if secret = 6, output should be 6
    }
}
