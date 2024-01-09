package JANUARY;

import java.util.ArrayList;
import java.util.Arrays;

public class GFG_POTD_9_1_2024 {
    public static void main(String[] args) {
        String pat="code";
        String txt="codewmecode";

        System.out.println(Solution9.search(pat,txt));
    }
}

class Solution9
{
    static ArrayList<Integer> search(String pat, String txt)
    {
        int N=txt.length();
        int M=pat.length();
        ArrayList<Integer> ans= new ArrayList<>();

        int[] pref =new int[M];
        for(int i=1;i<M;i++)
        {
            int j=pref[i-1];
            while(j>0 && pat.charAt(i)!=pat.charAt(j)) j=pref[j-1];
            if(pat.charAt(i)==pat.charAt(j))j++;
            pref[i]=j;
        }

        int i=0;  // txt pointer
        int j=0; //  pattern pointer

        int pos=-1;
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                ans.add(i-j+1);
                j = pref[j - 1];
            }


            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = pref[j - 1];
                else
                    i++;
            }
        }
        return ans;
    }
}

