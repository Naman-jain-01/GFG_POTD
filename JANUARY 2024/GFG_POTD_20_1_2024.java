class Solution
{
    static int ans;
    public static int givecoins(Node node)
    {
        if(node==null) return 0;
        int leftd=givecoins(node.left);
        int rightd=givecoins(node.right);
        ans+=Math.abs(leftd) + Math.abs(rightd);
        return node.data+leftd+rightd-1;
    }


    public static int distributeCandy(Node root)
    {
        ans=0;
        givecoins(root);
        return ans;
    }
}
