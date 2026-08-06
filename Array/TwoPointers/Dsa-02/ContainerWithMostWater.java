// Two Pointer Pattern (Container With Most Water)

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        // Initialize pointers
        int left = 0;
        int right = height.length - 1;

        // Store maximum area
        int maxArea = 0;

        while (left < right) {

            // Calculate width
            int width = right - left;

            // Calculate current area
            int area = Math.min(height[left], height[right]) * width;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println(result);
    }
}