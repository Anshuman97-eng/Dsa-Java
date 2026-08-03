// Greedy Algorithm (Jump Game)

public class JumpGame {

    public static boolean canJump(int[] nums) {

        int maxCount = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(i > maxCount){
                return false;
            }


            maxCount = Math.max(maxCount, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        boolean result = canJump(nums);

        System.out.println("Can Reach Last Index: " + result);
    }
}