

class Solution {

    static long primefactorsum(long n) {
        long sum = 0;
        while (n % 2 == 0) {
            sum++;
            n = n / 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                sum++;
                n = n / i;
            }
        }
        if (n > 2) sum++;
        return sum;
    }

    public static long sumOfPowers(long a, long b) {
        long ans = 0;
        while (a <= b) {
            ans += primefactorsum(a);
            a++;
        }
        return ans;
    }
}
    
