// Two Pointer Pattern (Trapping Rain Water)

public class TrappingRainWater {

    public static int trap(int[] height) {

        int left = 0;
        int leftMax = 0;
        int right = height.length-1;
        int rightMax = 0;
        int water = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMax < height[left]){
                    leftMax = height[left];
                }else{
                    water += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {

        int[] height = {3, 0, 2, 0, 4};

        int result = trap(height);

        System.out.println("Trapped Water: " + result);
    }
}