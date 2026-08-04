

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        // Write your code here
        int left =0;
        int right = nums.length-1;

        while (left < right) {
           int sum = nums[left] + nums[right];
           if(sum == target){
            return new int[]{left+1,right+1};
           }
            if(sum > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + " " + result[1]);
    }
}