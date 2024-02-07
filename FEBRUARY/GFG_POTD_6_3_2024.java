
class Solution
{
    boolean check(Node node,int k,int currd)
    {
        if(node.left==null && node.right==null) return currd==k;
        
        boolean flag=false;
        if(node.left!=null) flag=flag||check(node.left,k,currd+1);
        if(node.right!=null) flag=flag||check(node.right,k,currd+1);
        return flag;
    }
    int dfs(Node node, int k)
    {
        int ans=0;
        if(check(node,k,0)) ans++;
        if(node.left!=null) ans+=dfs(node.left,k);
        if(node.right!=null) ans+=dfs(node.right,k);
        return ans;
    }
    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node root, int k)
    {
        return dfs(root,k);
    }

}
