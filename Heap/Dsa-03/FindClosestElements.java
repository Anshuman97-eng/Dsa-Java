import java.util.*;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 👉 You will write your logic here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(a-x);
            int distB = Math.abs(b-x);

            if(distA == distB){
                return Integer.compare(b, a);
            }else{
                return Integer.compare(distB, distA);
            }
        });

        for(int num : arr){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        FindClosestElements solution = new FindClosestElements();

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> result = solution.findClosestElements(arr, k, x);
        System.out.println(result);
    }
}
