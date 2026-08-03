// Index Placement Pattern (Rearrange Array Elements by Sign)

public class RearrangeArrayBySign {

    public static int[] rearrangeArray(int[] nums) {
        int m = nums.length;
        int[] arr = new int[m];

        int even = 0;
        int odd = 1;

        for(int num : nums){
            if(num < 0){
                arr[even] = num;
                even += 2;
            }else{
                arr[odd] = num;
                odd += 2;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] result = rearrangeArray(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}