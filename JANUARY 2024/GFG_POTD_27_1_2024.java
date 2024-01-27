class Solution {
    static String str = "";
    static char name = 'A';

    static String matrixChainOrder(int p[], int n) {
        str = "";
        name = 'A';
        int[][] dp = new int[n][n];
        int[][] bracket = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // for (int m = 0; m < dp.length; m++) {
        //     System.out.println(Arrays.toString(dp[m]));
        // }

        // System.out.println();
        // System.out.println("BRACKET BEFORE CACLULATION");
        // for (int m = 0; m < dp.length; m++) {
        //     System.out.println(Arrays.toString(bracket[m]));
        // }

        solve(p, 1, n - 1, dp, bracket);

        // System.out.println();
        // System.out.println("DP ARRAY AFTER CACLULATION");

        // for (int m = 0; m < dp.length; m++) {
        //     System.out.println(Arrays.toString(dp[m]));
        // }

        // System.out.println();
        // System.out.println("BRACKET ARRAY AFTER CACLULATION");

        // for (int m = 0; m < dp.length; m++) {
        //     System.out.println(Arrays.toString(bracket[m]));
        // }

        printOptimalParenthesis(1, n - 1, bracket);
        System.out.println(dp[0][n-1]);
        return str;
    }


    public static void printOptimalParenthesis(int i, int j, int[][] bracket) {
        if(i==j) {str=str+name;name++;}
        else {
            int k=bracket[i][j];
            str+="(";
            printOptimalParenthesis(i,k,bracket);
            printOptimalParenthesis(k+1,j,bracket);
            str+=")";
        }
    }


    static int solve(int[] p, int i, int j, int[][] dp, int[][] bracket) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = solve(p, i, k, dp, bracket) + solve(p, k + 1, j, dp, bracket) + p[i - 1] * p[k] * p[j];

            if (min > temp) {
                min = Math.min(min, temp);
                dp[i][j] = min;
                bracket[i][j] = k;
            }

        }
        return min;
    }
}
