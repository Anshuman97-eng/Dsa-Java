// Merge Intervals Pattern (Insert Interval)

import java.util.*;

class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int i = 0;

        // Step 1: Add intervals before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i< intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0] , newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        ans.add(newInterval);

        // Step 3: Add merged interval


        // Step 4: Add remaining intervals
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {2, 5};

        int[][] result = insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}