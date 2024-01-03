package DECEMBER;

import java.util.*;

class Solution8
{
    public static String[] winner(String arr[], int n) {
        HashMap<String, Integer> map = new HashMap<>();
        int count;
        for (String name : arr) {
            count = map.getOrDefault(name, 1);
            if (map.containsKey(name)) {
                count++;
                map.replace(name, count);
            } else map.put(name, count);

        }

        int max = -1;
        for (int values : map.values()){
            if(values>max) max=values;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String name: map.keySet())
        {
            if(map.get(name)==max) ans.add(name);
        }

         Collections.sort(ans) ;

        String[] finalans={ans.get(0),String.valueOf(max)};
        return finalans;
    }
}
