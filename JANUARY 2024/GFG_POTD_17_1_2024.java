package JANUARY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GFG_POTD_17_1_2024 {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        int n=arr.size();
        ArrayList<ArrayList<Integer>> ans=Solution17.uniquePerms(arr,n);
        for(ArrayList<Integer> arr1 :  ans)
        {
            System.out.println(arr1);
        }
        System.out.println();
    }
}

class Solution17 {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(arr);

        generatePermutations(arr, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }
    private static void generatePermutations(ArrayList<Integer> arr, HashSet<Integer> used, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == arr.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (used.contains(i) || (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used.contains(i - 1))) {
                continue; // Skip duplicates and already used elements
            }

            used.add(i);
            current.add(arr.get(i));

            generatePermutations(arr, used, current, result);

            used.remove(i);
            current.remove(current.size() - 1);
        }
    }
}
