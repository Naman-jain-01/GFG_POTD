package DECEMBER;

import java.util.Arrays;

class Solution4 {
    public static int[] antiDiagonalPattern(int[][] matrix) {
        int n = matrix.length;
        int start = 0;
        int[] ans = new int[n * n];

        for (int j = 0; j < n; j++) {
            for (int x = 0, y = j; y > -1 && x < n; x++, y--) {
                ans[start] = matrix[x][y];
                start++;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int y = n - 1, x = i; y > -1 && x < n; x++, y--) {
                ans[start] = matrix[x][y];
                start++;
            }
        }
        return ans;
    }
}
