package JANUARY;

public class GFG_POTD_29_1_2024 {
    public static void main(String[] args) {
        String str="1119";
        System.out.println(Solution29.TotalCount(str));
    }
}

class Solution29
{
    static public int TotalCount(String str)
    {
        return grouping(str,0,0);
    }

   static int grouping(String str,int index,int sum)
    {
        int ans=0;
        int currsum=0;
        for(int i=0;i<str.length();i++)
        {
            currsum+= str.charAt(i)-'0';
            if(currsum>=sum) ans+=grouping(str,i+1,currsum);
        }
        return ans;
    }
}