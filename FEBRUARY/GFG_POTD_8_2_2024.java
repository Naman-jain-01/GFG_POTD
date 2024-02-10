class Solution
{
    boolean check(Node root)
    {
	  Set<Integer> map=new HashSet<>();
	  dfs(root,0,map);
	  return map.size()==1?true:false;
    }
    
    void dfs(Node node,int d,Set<Integer> map)
    {
     if(node==null) return;
     
     dfs(node.left,d+1,map);
     dfs(node.right,d+1,map);
     if(node.left==null && node.right==null) map.add(d);
    }
}
