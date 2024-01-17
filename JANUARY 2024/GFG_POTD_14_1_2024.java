package JANUARY;

import java.util.*;

public class GFG_POTD_14_1_2024 {

}

class Solution14 {

    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<String> map = new HashSet<>();
        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) row.append(matrix[i][j]);
            String r = row.toString();
            if (map.contains(r)) ans.add(i);
            else map.add(r);
        }
        return ans;
    }
}
