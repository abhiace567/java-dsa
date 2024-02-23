package code.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateNumberInRange {

    public static void main(String[] args) {
        var nums = new int[]{1, 3, 4, 2, 2};
        System.out.println("Duplicate number in: " + Arrays.toString(nums) + " is: " + findDuplicateNum(nums));
        nums = new int[]{3, 1, 3, 4, 2};
        System.out.println("Duplicate number in: " + Arrays.toString(nums) + " is: " + findDuplicateNum(nums));

        nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println("Duplicate number in: " + Arrays.toString(nums) + " are: " + findAllDuplicateNums(nums));
        nums = new int[]{1,1,2};
        System.out.println("Duplicate number in: " + Arrays.toString(nums) + " are: " + findAllDuplicateNums(nums));

    }

    //https://leetcode.com/problems/find-the-duplicate-number/description/
    public static int findDuplicateNum(int[] arr) {
        var i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                var correctIndex = arr[i] - 1;
                if (arr[i] != arr[correctIndex]) {
                    var temp = arr[i];
                    arr[i] = arr[correctIndex];
                    arr[correctIndex] = temp;
                    continue;
                }
                return arr[i];
            }
            i++;
        }
        return -1;
    }

    //https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
    public static List<Integer> findAllDuplicateNums(int[] arr) {
        var i = 0;
        while (i < arr.length) {
            var correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                var temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
                continue;
            }
            i++;
        }

        List<Integer> duplicateNums = new ArrayList<>();
        for (int j = 0; j < arr.length; j++)
            if (arr[j] != j + 1)
                duplicateNums.add(arr[j]);

        return duplicateNums;
    }
}
