class Solution {
    public int TotalWays(int N) {
        long temp = fib(N + 2);
        long ans=((temp * temp) % mod);
        return (int)ans;
    }

    static final long mod = 1000000007;

    static long fib(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = (a + b) % mod;
            a = b;
            b = temp;
        }

        return b;
    }
}
