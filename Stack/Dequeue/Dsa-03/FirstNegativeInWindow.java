import java.util.*;

class FirstNegativeInWindow {
    public static void printFirstNegative(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[arr.length - k + 1]; // number of windows

        for (int i = 0; i < arr.length; i++) {
            // remove out of window
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }

            // add negatives
            if (arr[i] < 0) {
                q.add(i);
            }

            // record answer
            if (i >= k - 1) {
                result[i - k + 1] = q.isEmpty() ? 0 : arr[q.peek()];
            }
        }

        // 👉 print result
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        printFirstNegative(arr, k);
    }
}
