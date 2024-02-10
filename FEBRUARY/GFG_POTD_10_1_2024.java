class Solution {
    long[][][] memo;
    long numberOfPath(int n, int k, int[][] arr) {
        
        memo=new long[n][n][k+1];
        for(long[][] num : memo)
        {
            for(long[] row : num)
            {
                Arrays.fill(row,-1);
            }
        }
     return path(n-1,n-1,k,arr);  
    }
    
    long path(int n ,int m ,int k ,int[][] arr)
    {
        
        if(m<0 || n<0) return 0;
        if(n==0 && m==0 ){
            return  1;
        }
        
        if(memo[n][m][k]!=-1) return memo[n][m][k];
        long left=path(n-1,m,k,arr);
        long up=path(n,m-1,k,arr);
        return memo[n][m][k]=left+up;
    }
}
