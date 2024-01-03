package JANUARY;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class GFG_POTD_1_1_2024 {
    public static void main(String[] args) {
        int arr[] = {9, 3, 5, 7,2,1};
        int k = 6;
        System.out.println(Solution.canPair(arr,k));
    }}
        class Solution {
            static public boolean canPair(int[] nums, int k) {
               int n=nums.length;
               if(n%2!=0) return false;

                int[] map=new int[k+1];
                for(int num: nums)
                {
                    num=num%k;
                    map[num]++;
                    map[k-num]--;
                }
                for(int j=1;j<k;j++)
                {
                    if(map[j]!=0) return false;
                }

                return true;
             }
        }


