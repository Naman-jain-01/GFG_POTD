
class Solution {
    static int singleElement(int[] arr , int N) {

        HashMap<Integer,Integer> map= new HashMap<>();

        for(int num:arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet())
        {
            if(map.get(key)==1) return key;
        }
        return -1;

    }
}
