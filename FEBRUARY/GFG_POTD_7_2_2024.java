class GfG {
    
    int findDist(Node root, int a, int b) {
      Node LCA =findLCA(root,a,b);
      int d1=findDistance(LCA,a,0);
      int d2=findDistance(LCA,b,0);
      return d1+d2;
    }
    
    Node findLCA(Node root,int a,int b)
    {
        if(root==null || root.data ==a || root.data ==b) return root;
        
        Node leftLCA=findLCA(root.left,a,b);
        Node rightLCA=findLCA(root.right,a,b);
        
        if(leftLCA !=null && rightLCA!=null) return root;
        return (leftLCA!=null)?leftLCA : rightLCA;
    }
    
    int findDistance(Node root,int target,int currd)
    {
        if(root==null) return -1;
        if(root.data == target) return currd;
        
        int leftd=findDistance(root.left,target,currd+1);
        int rightd=findDistance(root.right,target,currd+1);
        
        return(leftd!=-1)? leftd : rightd;
    }
}
