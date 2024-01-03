
class Solution {
    public static boolean isPossible(int N, int[] coins) {
// code here
        Boolean[][] dp = new Boolean[N][2025];
        return find(0, 0, coins, dp);
    }
        static boolean find( int ind, int sum, int[] coins, Boolean[][] dp){
            if (sum > 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024))
                return true;
            if (ind >= coins.length)
                return false;
            if (dp[ind][sum] != null)
                return dp[ind][sum];
            return dp[ind][sum] = find(ind + 1, sum + coins[ind], coins, dp) || find(ind + 1, sum, coins, dp);

        }

    }
