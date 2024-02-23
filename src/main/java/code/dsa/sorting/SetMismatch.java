package code.dsa.sorting;

import java.util.Arrays;

//https://leetcode.com/problems/set-mismatch/description/
public class SetMismatch {
    public static void main(String[] args) {
        var nums = new int[]{1,2,2,4};
        System.out.println("Duplicate, Missing number in: " + Arrays.toString(nums) + " are: " + Arrays.toString(findErrorNums(nums)));
    }
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]) {
                var temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                continue;
            }
            i++;
        }

        for (int j = 0; j < nums.length; j++)
            if (nums[j] != j + 1)
                return new int[]{nums[j], j + 1};

        return new int[]{-1, -1};
    }
}
