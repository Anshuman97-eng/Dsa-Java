/*
 * Problem Name : Trapping Rain Water (LeetCode 42)
 *
 * Pattern Used : Prefix Max + Suffix Max
 *
 * Input  : int[] height
 * Output : int
 *
 * Definition:
 * Return the total amount of rain water trapped.
 *
 * Formula:
 * Water = min(LeftMax, RightMax) - CurrentHeight
 *
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */

public class TrappingRainWater {

    public static int trap(int[] height) {

        int n= height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int water =0;
        prefix[0] = height[0];
        for(int i=1 ; i<n ; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        suffix[n-1] = height[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }

        for(int i=0 ; i<n ; i++){
            water += Math.min(suffix[i], prefix[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = trap(height);

        System.out.println(result);
    }
}