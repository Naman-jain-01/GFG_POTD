package JANUARY;

import java.util.Arrays;

public class GFG_POTD_15_1_2024 {
    public static void main(String[] args) {
        int total =10;
        int[] cost={10, 9};
        int n=cost.length;
        System.out.println(Solution15.max_courses(n,total,cost));
    }
}

class Solution15 {
    static public int max_courses(int n, int total, int[] cost) {

        int[][] dp = new int[n + 1][total + 1];

        for(int i = n - 1; i > -1; i -- )
        {
            for (int j = 0; j < total + 1; j++)
            {
                int pick = 0, nopick = 0;

                nopick = dp[i + 1][j];

                if (cost[i] <= j) {
                    int rem = j - cost[i] + (cost[i] * 9) / 10;
                    pick = 1 + dp[i + 1][rem];
                }
                dp[i][j] = Math.max(pick, nopick);
            }
        }
        return dp[0][total];
    }
}
