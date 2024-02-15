class Solution{
    Node cloneGraph(Node src){
        
        
        Queue<Node> q = new LinkedList<Node>();
        HashMap<Node,Node> map=new HashMap<Node,Node>();
        q.add(src);
        map.put(src,new Node(src.val));
        
        while(!q.isEmpty())
        {
            Node u=q.poll();
            Node uclone=map.get(u);
            
             if (u.neighbors != null)
                {
                    ArrayList<Node> v = u.neighbors;
                    for(Node trav : v)
                    {
                        Node g_clone = map.get(trav);
                        if (g_clone == null)
                        {
                            q.add(trav);
                            g_clone = new Node(trav.val);
                            map.put(trav,g_clone);
                        }
                        uclone.neighbors.add(g_clone);
                    }
                }
        }
        return map.get(src);
    }
}
