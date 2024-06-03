class Solution {
    
    static int mod = (int)1e9 + 7;
    
    static int numberOfConsecutiveOnes(int n) {
        
        
        long p2 = power(2,n);
        long fibn = fib (n+ 2);
        
        return (int)(p2-fibn+mod)%mod;
    }
    
    static long power(long a , long b)
    {
        long ans=1;
        
        a=a%mod;
        
        if(a==0) return 0;
        
        while(b>0)
        {
            if((b&1)==1)
            {
                ans  = (ans * a)%mod;
            }
             
            b=b>>1; //b even
            
            
            a=(a*a)%mod;
        }
        return ans;
    }
    
    
     static long fib(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        
        return fib_recursion(n, dp);
    }
    
    
    static long fib_recursion(int n, long[] dp)
    {
        if (dp[n] != -1) return dp[n];  
         if (n == 0) return 0;
        if (n == 1) return 1;
        
        
        dp[n] = (fib_recursion(n - 1, dp) % mod + fib_recursion(n - 2, dp) % mod) % mod;
        return dp[n];
    }
    
}
