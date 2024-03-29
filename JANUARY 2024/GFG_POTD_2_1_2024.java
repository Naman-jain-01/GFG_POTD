
   class Solution {
        public static long maxSumWithK(long a[], long N, long K)
        {
            int n=(int)N;
            int k=(int)K;

            long[] dp= new long[n+1];

            for (int i = n-1; i >-1;i--) {
                dp[i]=a[i]+dp[i+1];
                dp[i]=Math.max(0,dp[i]);
            }

            long ans=Long.MIN_VALUE;
            long curr_sum=0;

            for (int i = 0; i <k ; i++) {
                curr_sum+=a[i];
            }

            for (int i = k; i < n; i++) {

                long sum = curr_sum+dp[i];
                ans=Math.max(sum,ans);
                curr_sum+=a[i];
                curr_sum-=a[i-k];
            }

            return Math.max(curr_sum,ans);

        }
    }
