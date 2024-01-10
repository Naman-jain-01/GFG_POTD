

class Solution{
int longSubarrWthSumDivByK(int a[], int n, int k)
{
    int[] prefsum=new int[n+1];
    HashMap<Integer,Integer> map=new HashMap<>();
    int maxlength=0;

    for(int i=1;i<n+1;i++)
    {
        prefsum[i]=prefsum[i-1]+a[i-1];
        int currem=(prefsum[i]%k + k )%k;

        if(currem==0) maxlength=i;
        else if( map.containsKey(currem)) maxlength=Math.max(maxlength,i-map.get(currem));
        if( !map.containsKey(currem)) map.put(currem,i);
    }
    return maxlength;
}

}
