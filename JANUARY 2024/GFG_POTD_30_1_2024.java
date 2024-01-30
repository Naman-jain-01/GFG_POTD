package JANUARY;

import java.util.Arrays;

public class GFG_POTD_30_1_2024 {
    public static void main(String[] args) {
        String str1="geeks";
        String str2="geeksfor";
        String str3= "geeksforgeeks";
        int n1=str1.length();
        int n2=str2.length();
        int n3=str3.length();
        System.out.println(Solution30.LCSof3(str1,str2,str3,n1,n2,n3));
    }
}

class Solution30 {
    static int recursion(String A, String B, String C, int n1, int n2, int n3, int[][][] dp) {

        if(dp[n1][n2][n3]!=-1) return dp[n1][n2][n3];

        if (n1 == 0 || n2 == 0 || n3 == 0) {
            return dp[n1][n2][n3]=0;
        }
        if (A.charAt(n1 - 1) == B.charAt(n2 - 1) && A.charAt(n1 - 1) == C.charAt(n3 - 1)) {
            return dp[n1][n2][n3]=1 + recursion(A, B, C, n1 - 1, n2 - 1, n3 - 1, dp);
        } else {
            return dp[n1][n2][n3]=Math.max(Math.max(recursion(A, B, C, n1 - 1, n2, n3, dp), recursion(A, B, C, n1, n2 - 1, n3, dp)), recursion(A, B, C, n1, n2, n3 - 1, dp));
        }
    }


    static int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        recursion(A, B, C, n1, n2, n3, dp);

        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                System.out.println(Arrays.toString(dp[i][j]));
            }
        }
        return dp[n1][n2][n3];
    }
}

