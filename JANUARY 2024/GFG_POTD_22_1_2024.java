
class Solution
{
    public static void recursion(Node node , int sum , int curr_sum , ArrayList<Integer> path ,  ArrayList<ArrayList<Integer>> ans)
    {
        if(node==null) return;
        curr_sum+=node.data;
        path.add(node.data);
        if(curr_sum==sum)
        {
            ans.add(new ArrayList<>(path));
        }

        if(node.left!=null) recursion(node.left,sum,curr_sum,path,ans);
        if(node.right!=null) recursion(node.right,sum,curr_sum,path,ans);

        int index_To_remove_from_path=path.size()-1;
        path.remove(index_To_remove_from_path);

    }
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        ArrayList<Integer> path= new ArrayList<>() ;
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>() ;
        recursion(root,sum,0,path,ans);
        return ans;
    }
}
