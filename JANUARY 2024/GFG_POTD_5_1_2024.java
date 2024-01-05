package JANUARY;

public class GFG_POTD_5_1_2024 {
}

class Solution6 {
    public int TotalWays(int N) {
        long ans = fibonacciModulo(N + 2);
        long finals=((ans * ans) % MODULO);
        return (int)finals;
    }

    static final long MODULO = 1000000007;

    static long fibonacciModulo(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = (a + b) % MODULO;
            a = b;
            b = temp;
        }

        return b;
    }
}