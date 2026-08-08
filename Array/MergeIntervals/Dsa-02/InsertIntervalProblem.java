import java.util.ArrayList;
import java.util.List;

/*
 * Problem : Insert Interval (LeetCode 57)
 *
 * Pattern : Merge Intervals
 *
 * Input  : int[][] intervals, int[] newInterval
 * Output : int[][]
 *
 * Goal:
 * Insert newInterval and merge overlapping intervals.
 *
 * Logic:
 * 1. Add intervals before newInterval.
 * 2. Merge overlapping intervals.
 * 3. Add remaining intervals.
 *
 * Before:
 * intervals[i][1] < newInterval[0]
 *
 * Overlap:
 * intervals[i][0] <= newInterval[1]
 *
 * Merge:
 * start = Math.min(...)
 * end   = Math.max(...)
 *
 * Time  : O(n)
 * Space : O(n)
 */

public class InsertIntervalProblem {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;

        // 1. Add intervals before newInterval

        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }


        result.add(newInterval);

        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }


        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                { 1, 3 },
                { 6, 9 }
        };

        int[] newInterval = { 2, 5 };

        int[][] result = insert(intervals, newInterval);

        for (int[] interval : result) {

            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}