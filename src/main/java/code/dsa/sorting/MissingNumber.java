package code.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MissingNumber {
    public static void main(String[] args) {
        var nums = new int[]{3,0,1};
        System.out.println("missing num in - "+ Arrays.toString(nums) + " is - " + findMissingNum(nums));
        nums = new int[]{0,1};
        System.out.println("missing num in - "+ Arrays.toString(nums) + " is - " + findMissingNum(nums));
        nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println("missing num in - "+ Arrays.toString(nums) + " is - " + findMissingNum(nums));

        nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("missing num in - "+ Arrays.toString(nums) + " is - " + findAllMissingNum(nums));
    }

    // https://leetcode.com/problems/missing-number/description/
    public static int findMissingNum(int[] nums) {
        var i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && i != nums[i]) {
                var temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
                continue;
            }
            i++;
        }

        for (int j = 0; j < nums.length; j++)
            if (j != nums[j])
                return j;

        return nums.length;
    }

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    public static List<Integer> findAllMissingNum(int[] nums) {
        var i = 0;
        while(i<nums.length) {
            var correctIndex = nums[i] - 1;
            if (correctIndex < nums.length && nums[i] != nums[correctIndex]) {
                var temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                continue;
            }
            i++;
        }

        List<Integer> missingNums = new ArrayList<>();
        for (int j = 0; j < nums.length; j++)
            if (j != nums[j] - 1)
                missingNums.add(j + 1);

        return missingNums;
    }
}
