class Solution {
    Node prev;
    
    public Node flattenBST(Node root) {
       Node ans=new Node(-1);
       prev=ans;
       inorder(root);
       prev.left=null;
       prev.right=null;
       return ans.right;
    }
    
    void inorder(Node curr)
    {
        if(curr==null) return;
        inorder(curr.left);
        prev.left=null;
        prev.right=curr;
        prev=curr;
        inorder(curr.right);
    }
}
