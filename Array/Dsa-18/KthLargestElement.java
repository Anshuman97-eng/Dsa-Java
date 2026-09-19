import java.util.*;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Step 1: Create a Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 2: Loop through nums and add elements
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }


        // Step 3: Return the root of heap (Kth largest)
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = obj.findKthLargest(nums, k);
        System.out.println("Kth largest element = " + result);
    }
}
