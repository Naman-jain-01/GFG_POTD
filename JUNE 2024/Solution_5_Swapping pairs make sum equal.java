class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        
        
        HashMap<Long, Integer> map =  new HashMap<>();
        int sum1=0,sum2=0;
        
        for(long num1 : a ) sum1+=num1;
        for(long num2 : b ) 
        {sum2+=num2;
        map.put(num2,1);
        }
        
        if((sum2-sum1)%2!=0) return -1;
        
        for(int i = 0 ; i<n ; i++)
        {
            long bi = a[i] + (sum2-sum1)/2;
            if(map.get(bi)!=null) return 1;
        }
        return -1;
        
     }
}
