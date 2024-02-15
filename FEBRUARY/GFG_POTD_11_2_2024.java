class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        ArrayList<Integer> ans= new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        
        ans.add(0);
        set.add(0);
        
        for(int i=1;i<n;i++)
        {
           int prev=ans.get(i-1);
            int next=prev -i;
            
            if(next<0 || set.contains(next))
            next=prev+i;
            
            ans.add(next);
            set.add(next);  
        }
          return ans;
    }
}
