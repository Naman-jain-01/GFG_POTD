package JANUARY;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
class Solution8
{
   static int splitArray(int[] arr , int N, int K)
   {

       int max=Integer.MIN_VALUE;
       int sum=0;
       for(int n : arr)
       {
          if(n>max) max=n;
          sum+=n;
       }
       int l=max;
       int r=sum;
       int mid;
       int ans=r;

       while(l<=r)
       {
           mid=(l+r)/2;
           if(canSplit(mid,arr,K))
           {
               ans=mid;
               r=mid-1;
           }
           else
           {
               l=mid+1;
           }
       }
       return ans;
   }

    private static boolean canSplit(int mid, int[] arr, int k) {
       int subarray=1;
       int currSum=0;
       for (int n:arr)
       {
           currSum+=n;
           if(currSum>mid)
           {
           subarray++;
           currSum=n;
           }
       }
       return subarray<=k;
    }
}