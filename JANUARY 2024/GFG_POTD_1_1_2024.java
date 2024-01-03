
        class Solution {
            static public boolean canPair(int[] nums, int k) {
               int n=nums.length;
               if(n%2!=0) return false;

                int[] map=new int[k+1];
                for(int num: nums)
                {
                    num=num%k;
                    map[num]++;
                    map[k-num]--;
                }
                for(int j=1;j<k;j++)
                {
                    if(map[j]!=0) return false;
                }

                return true;
             }
        }


