package code.dsa.bitwise;

import java.util.Arrays;

// https://leetcode.com/problems/flipping-an-image/description/
public class FlipImage {
    public static void main(String[] args) {
        for(int[] arr :
            flipAndInvertImage(new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        })) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("-------------------------------------");
        for(int[] arr :
            flipAndInvertImage(new int[][]{
                    {1,1,0,0},
                    {1,0,0,1},
                    {0,1,1,1},
                    {1,0,1,0}
            })) {
            System.out.println(Arrays.toString(arr));
        }
    }


    private static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int row = image[i].length;
            for (int j = 0; j < row/2; j++) {
                int t = image[i][j];
                image[i][j] = image[i][row - j - 1] ^ 1;
                image[i][row - j - 1] = t ^ 1;
            }
            if (row % 2 == 1) image[i][row/2] ^= 1;
        }

        return image;
    }
}
