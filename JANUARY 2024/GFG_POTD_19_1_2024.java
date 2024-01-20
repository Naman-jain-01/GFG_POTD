package JANUARY;
import java.util.*;

public class GFG_POTD_19_1_2024 {
    public static void main(String[] args) {
        int[] arr={5,2,1,3,2};
        int k=4;
        int n=arr.length;

        System.out.println(Solution19.kTop(n,k,arr));
    }
}

class Solution19 {
    public static ArrayList<Integer> kTop(int N, int K, int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);

        for (int i = 0; i < N; i++)
        {
            int number=a[i];
            
            ans.add(number);
        }

        return ans;
    }
}

