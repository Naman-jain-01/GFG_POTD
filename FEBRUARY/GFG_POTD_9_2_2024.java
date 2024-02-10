class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    { // add your code here
        int left_d=0;
        int right_d=0;
        
        if(root==null || (root.left==null && root.right==null)) return 1;
        
        else
        {
            if(root.left!=null)
             left_d=root.left.data;
            if(root.right!=null)
            right_d=root.right.data;
            
            if((root.data==left_d+right_d)  &&((isSumProperty(root.left)!=0)&&(isSumProperty(root.right)!=0)))
            return 1;
            else return 0;
            
        }
    }
}
