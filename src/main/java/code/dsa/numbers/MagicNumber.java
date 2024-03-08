package code.dsa.numbers;

public class MagicNumber {
    public static void main(String[] args) {
        int n = 7;
        int ans = 0;

        int base = 5;
        while (n > 0) {
            int last = n & 1;
            ans += last * base;
            base *= 5;
            n = n >> 1;
        }

        System.out.println(ans);
    }
}
