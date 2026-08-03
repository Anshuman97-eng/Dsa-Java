// HashSet Pattern (Remove Duplicates from Unsorted Array)

import java.util.*;

public class RemoveDuplicatesUnsortedArray {

    public static int removeDuplicates(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int j=0;
        for(int i=0 ; i<nums.length ; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[i] = nums[j];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 3};

        int length = removeDuplicates(nums);

        System.out.println("Unique Elements:");

        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}