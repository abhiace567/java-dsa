package code.dsa.sorting;

import java.util.Arrays;

public class MissingPositive {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 0};
        System.out.println("The smallest positive integer missing in the array: "
                + Arrays.toString(nums) + ", is: " + firstMissingPositive(nums));
        nums = new int[]{3,4,-1,1};
        System.out.println("The smallest positive integer missing in the array: "
                + Arrays.toString(nums) + ", is: " + firstMissingPositive(nums));
        nums = new int[]{7,8,9,11,12};
        System.out.println("The smallest positive integer missing in the array: "
                + Arrays.toString(nums) + ", is: " + firstMissingPositive(nums));
    }

    //https://leetcode.com/problems/first-missing-positive/description/
    private static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                continue;
            }
            i++;
        }

        for (int j = 0; j < nums.length; j++)
            if (nums[j] != j + 1) return j + 1;

        return nums.length + 1;
    }
}
