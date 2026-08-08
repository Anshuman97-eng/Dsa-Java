import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/*
 * Problem : Merge Intervals (LeetCode 56)
 *
 * Pattern : Sorting + Merge Intervals
 *
 * Input   : int[][] intervals
 * Output  : int[][]
 *
 * Goal:
 * Merge all overlapping intervals.
 *
 * Example:
 * [1,3] + [2,6] → [1,6]
 *
 * Logic:
 * 1. Sort by start point.
 * 2. Compare current start with previous end.
 * 3. Overlap → merge.
 * 4. No overlap → add.
 *
 * Condition:
 * current[0] <= previous[1] → Overlap
 * current[0] > previous[1]  → No overlap
 *
 * Merge:
 * previous[1] = Math.max(previous[1], current[1])
 *
 * Time : O(n log n)
 * Space: O(n)
 */

public class MergeIntervalsProblem {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for(int[] curr : intervals){
            if(result.isEmpty() || curr[0] > result.get(result.size() - 1)[1]){
                // No Overlap ..
                result.add(curr);
            }else{
                //overlap 
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], curr[1]);
            }
        }

        // Your code here

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] result = merge(intervals);

        for (int[] interval : result) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}