package JANUARY;

import java.util.Arrays;

public class GFG_POTD_18_1_2024 {
    public static void main(String[] args) {
        int[] gallery={-1,2,2,-1,0,0};
        int n=gallery.length;
        System.out.println(Solution18.min_sprinklers(gallery,n));
    }
}
class Solution18
{
    static int min_sprinklers(int gallery[], int n) {
        int[] water = new int[n];
        Arrays.fill(water, -1);

        for (int i = 0; i < n; i++) {
            if(gallery[i]==0)
            {
                water[i]=Math.max(water[i],i);
            } else if (gallery[i]!=-1) {
                int start=Math.max(0,i-gallery[i]);
                int end=Math.min(n,i+gallery[i]);
                for (int j = start; j <end ; j++) {
                    water[j]=Math.max(water[j],end);
                }
            }
        }
        int ans=0;
        int i=0;
        while(i<n)
        {
            if(water[i]==-1 ) return -1;
            ans++;
            i=water[i]+1;
        }
        return ans;
    }
}
