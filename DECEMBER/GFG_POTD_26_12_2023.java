package DECEMBER;//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Solution3 {
    public static ArrayList<ArrayList<Integer>> convertMatrixToList(int[][] matrix) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        for (int[] row : matrix) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int value : row) {
                rowList.add(value);
            }
            resultList.add(rowList);
        }

        return resultList;
    }
    public ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] matrix) {
        ArrayList<ArrayList<Integer>> a=convertMatrixToList(matrix);
        int n = a.size();
        int m = a.get(0).size();

        ArrayList<ArrayList<Integer>> rowPrefix = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            rowPrefix.add(new ArrayList<>(m + 1));
            for (int j = 0; j <= m; j++) {
                rowPrefix.get(i).add(0);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                rowPrefix.get(i).set(j, rowPrefix.get(i).get(j - 1) + a.get(i - 1).get(j - 1));
            }
        }

        int best = 0;
        int start_col = 0, start_row = 0, end_col = 0, end_row = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                Map<Integer, Integer> pre = new HashMap<>();
                pre.put(0, 0);

                int current_sum = 0;

                for (int k = 1; k <= n; k++) {
                    current_sum += rowPrefix.get(k).get(j) - rowPrefix.get(k).get(i - 1);

                    if (pre.containsKey(current_sum)) {
                        int area = (j - i + 1) * (k - pre.get(current_sum));

                        if (area > best) {
                            best = area;
                            start_col = pre.get(current_sum) + 1;
                            start_row = i;
                            end_col = k;
                            end_row = j;
                        }
                    } else {
                        pre.put(current_sum, k);
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (best == 0) {
            return ans;
        }

        for (int i = start_col; i <= end_col; i++) {
            ArrayList<Integer> curRow = new ArrayList<>();

            for (int j = start_row; j <= end_row; j++) {
                curRow.add(a.get(i - 1).get(j - 1));
            }

            ans.add(curRow);
        }

        return ans;
    }
}