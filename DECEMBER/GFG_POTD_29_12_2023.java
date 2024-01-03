


class Solution
{
     static int kSubstrConcat(int n, String s, int k)
    {
        if(n%k!=0) return 0;

        HashMap<String ,Integer> map=new HashMap<>();

        int count=1;

        for (int i = 0; i < n;i= i+k) {
            String temp=s.substring(i,i+k);
            count=map.getOrDefault(temp,1);
            if(map.containsKey(temp))
            {
                count++;
                map.replace(temp,count);
            }
            else
            {
                map.put(temp,count);
            }
        }

        int size=map.size();
        System.out.println(map);
        if(size==1) return 1;
        if(size==2) for(int value:map.values()) if (value==1) return 1;
        return 0;
    }
}
