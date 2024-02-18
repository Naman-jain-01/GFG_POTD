

/*node class of the binary ssearch tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/

//USING PREORDER
class Solution
{   private static int sum;
    
    static void preorder(Node root)
    {
        if(root==null) return;
        if(root.right == null && root.left==null) sum+=root.data;
        preorder(root.left);
        preorder(root.right);
    }

    public static int sumOfLeafNodes(Node root)
    {
        sum=0;
        preorder(root);
        return sum;
    }
}


//USING BFS
class Solution
{   private static int sum;
    
    static void bfs(Node root)
    {
        if(root==null) return;
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
        Node curr=q.poll();
        if(curr.right == null && curr.left==null) sum+=curr.data;
        if(curr.left!=null)q.add(curr.left);
        if(curr.right!=null)q.add(curr.right);
    }
    }

    public static int sumOfLeafNodes(Node root)
    {
        sum=0;
        bfs(root);
        return sum;
    }
}
