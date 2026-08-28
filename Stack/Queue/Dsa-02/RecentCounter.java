import java.util.*;


class Main {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();

        System.out.println(rc.ping(1));    // Expected: 1
        System.out.println(rc.ping(100));  // Expected: 2
        System.out.println(rc.ping(3001)); // Expected: 3 (calls at 1,100,3001)
        System.out.println(rc.ping(3002)); // Expected: 3 (calls at 100,3001,3002)
    }
}


class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    // TODO: implement ping
    public int ping(int t) {
        // your code here
        queue.add(t);
        while(!queue.isEmpty() && t - 3000 > queue.peek()){
            queue.poll();
        }
        return queue.size(); // placeholder
    }
}
