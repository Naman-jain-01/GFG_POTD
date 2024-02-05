class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node curr=head;
        Node datanode=new Node(data);
        
        if(curr==null) {datanode.next=datanode;
        return datanode;}
        
        else if(curr.data >= datanode.data)
        {
            while(curr.next!=head) curr=curr.next;
            
            curr.next=datanode;
            datanode.next=head;
            return datanode;
        }
        
        else
        {
            while(curr.next!=head && curr.next.data < datanode.data)
                curr=curr.next;
            
            
            datanode.next=curr.next;
            curr.next=datanode;
            return head;
        }
    }
}
