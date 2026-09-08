import java.util.*;

class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Integer.compare(a[0],b[0]));
        int[] prev = points[0];

        int arrow = 1;

        for(int i=1 ; i< points.length ; i++){
            int[] curr = points[i];

            int prevEP = prev[1];

            int currSP = curr[0];

            if(prevEP < currSP){
                arrow++;
                prev = curr;
            }else{
                prev[0] = Math.max(prev[0],curr[0]);
                prev[1] = Math.min(prev[1],curr[1]);
            }

        }
        
        return arrow; // temporary return
    }

    public static void main(String[] args) {
        FindMinArrowShots obj = new FindMinArrowShots();

        int[][] points = {
            {10,16},
            {2,8},
            {1,6},
            {7,12}
        };

        int result = obj.findMinArrowShots(points);
        System.out.println("Minimum arrows needed = " + result);
    }
}
