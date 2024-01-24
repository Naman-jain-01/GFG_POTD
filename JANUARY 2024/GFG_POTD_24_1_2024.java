package JANUARY;
import java.util.*;
class Solution24 {

    public boolean isConnected(int n,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        int start=0;
        dfs(start,visited,adj);

        for(boolean check :  visited) if(!check) return false;
        return true;
    }

    private void dfs(int v,boolean[] visited ,ArrayList<ArrayList<Integer>> adj )
    {
        visited[v]=true;
        for(int neighbour  : adj.get(v))
        {
            if(!visited[neighbour]) dfs (neighbour,visited,adj);
        }
    }

    public boolean isCycle(int n,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                if(check(adj,visited,i,-1)) return true;
            }
        }
        return false;
    }
    public boolean check(ArrayList<ArrayList<Integer>> adj,boolean[]  visited , int node ,int parent)
    {
        visited[node]=true;

        for(int neighbour : adj.get(node))
        {
            if(!visited[neighbour]) {if(check(adj,visited,neighbour,node)) return true;}
            else if(neighbour !=parent) return true;
        }
        return false;
    }

    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> a :  edges)
        {   int s=a.get(0);
            int d=a.get(1);
            adj.get(s).add(d);
            adj.get(d).add(s);
        }

        //cond1 to check if connected
        boolean cond1=isConnected(n,visited,adj);
        if(cond1==false) return false;
        //cond2 to check if cyclic
        boolean cond2=isCycle(n,adj);
        if(cond2==false) return true;
        else return false;
    }
}
