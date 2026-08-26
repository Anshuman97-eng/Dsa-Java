import java.util.*;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();        // 👉 monotonic stack
        int[] ans = new int[nums2.length];

        for(int i = nums2.length - 1 ; i>=0 ; i--){
            if(stack.isEmpty()){
                ans[i] = -1;
                stack.push(ans[i]);
                continue;
            }

            if(stack.peek() > nums2[i]){
                ans[i] = stack.peek();
                stack.push(nums2[i]);
                continue;
            }

            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }

            stack.add(nums2[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
        // Expected: [-1, 3, -1]
    }
}
