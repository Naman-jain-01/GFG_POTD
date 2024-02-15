class Solution{
    static long sequence(int n){
      
      long ans=0;
      long x=1;
      long mod=1000000007;
      for(int i=1;i<=n;i++)
      {   
          long temp=1;
          for(int j=1;j<=i;j++)
          {
              temp=(x*temp)%mod;
              x++;
          }
          ans=(ans+temp)%mod;
      }
      return ans;
    }
}
