public class FibonacciSeries {

    public static int fibonacciSeries(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return fibonacciSeries(n-1) + fibonacciSeries(n-2);
    }

    public static void main(String[] args) {

        // Code here
        int n = 6;

        System.out.print(fibonacciSeries(n) + " ");

    }
}