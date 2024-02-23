package code.dsa.sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,2,4,1,3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr) {
        var i = 0;
        while(i<arr.length) {
            var correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                var temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
                continue;
            }
            i++;
        }
    }
}
