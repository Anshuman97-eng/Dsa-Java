import java.util.PriorityQueue;

public class KthLargest {
    // your variables here
    private PriorityQueue<Integer> pq;
    private int k;

    // constructor
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int n : nums){
            add(n);
        }
    }

    // add method
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek(); // kth largest
    }

    // main method
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(k, nums);

        // 👉 leave space for you to code / test
        // Example calls:
        System.out.println(obj.add(3));  // 4
        System.out.println(obj.add(5));  // 5
        System.out.println(obj.add(10)); // 5
        System.out.println(obj.add(9));  // 8
        System.out.println(obj.add(4));  // 8
    }
}
