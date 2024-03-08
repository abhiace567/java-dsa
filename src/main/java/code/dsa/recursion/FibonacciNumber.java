package code.dsa.recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 6;
        printFibonacciSeries(n + 1);
        System.out.println(findFibonacci(n));
    }

    private static void printFibonacciSeries(int n) {
        int[] last = {0, 1};
        System.out.print(last[0] + ", " + last[1]);
        for (int i = 1; i < n - 1; i++) {
            int x = last[0] + last[1];
            System.out.print(", " + x);
            last[0] = last[1];
            last[1] = x;
        }
        System.out.println();
    }

    private static int findFibonacci(int pos) {
        if(pos < 2) return pos;
        return findFibonacci(pos - 1) + findFibonacci(pos - 2);
    }
}
