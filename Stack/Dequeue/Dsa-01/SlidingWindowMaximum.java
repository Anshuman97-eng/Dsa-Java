import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // store indexes

        // 👉 your for loop logic goes here
        for (int i = 0; i < n; i++) {
            // write your code here
            while(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k-1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = sw.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
