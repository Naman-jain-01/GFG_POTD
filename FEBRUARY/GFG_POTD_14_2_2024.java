class Solution
{
    private List<List<Integer>> ans;
    private int time;
    
     
    
      private void dfs(int u, int[] tin, int[] lowest, int[] parent, List<Integer>[] adj)
      {
           tin[u] = lowest[u] = time++;
            for (int i = 0; i < adj[u].size(); i++) 
            {
                 int v = adj[u].get(i);
                 if (tin[v] == -1)
                 {
                     parent[v] = u;
                     dfs(v, tin, lowest, parent, adj);
                    
                    //if my lowest time of insertion of child i.e v is greater than insertion time of parent 
                    // then it is out potential critical point
                    
                if (lowest[v] > tin[u]) {
                    ans.add(Arrays.asList(v, u));
                }
                else {
                    lowest[u] = Math.min(lowest[u], lowest[v]);
                }
                }
                
                else if (tin[v] > -1 && v != parent[u]) {
                lowest[u] = Math.min(lowest[u], lowest[v]);
                 } 
            }
      }
    
    private static List<Integer>[] convertToArrayList(ArrayList<ArrayList<Integer>> arrayListArrayList) {
        int size = arrayListArrayList.size();
        List<Integer>[] adj = new List[size];

        for (int i = 0; i < size; i++) {
            adj[i] = arrayListArrayList.get(i);
        }

        return adj;
    }
    
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adjlist)
    {
        List<Integer>[] adj=convertToArrayList(adjlist);
        ans = new ArrayList<>();
        time = 0;
    
        int[] tin = new int[v];
        int[] lowest = new int[v];
        int[] parent = new int[v];

        Arrays.fill(tin, -1);
        Arrays.fill(lowest, -1);
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < v; i++) {
            if (tin[i] == -1) {
                dfs(i, tin, lowest, parent, adj);
            }
        }
        
        for (List<Integer> connection : ans) {
            Collections.sort(connection);
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (List<Integer> bridge : ans) {
            result.add(new ArrayList<>(bridge));
        }
        
         Collections.sort(result, (o1, o2) -> {
    int compareResult = Integer.compare(o1.get(0), o2.get(0));
    return (compareResult == 0) ? Integer.compare(o1.get(1), o2.get(1)) : compareResult;
}); 


return result;

        
    }
}
