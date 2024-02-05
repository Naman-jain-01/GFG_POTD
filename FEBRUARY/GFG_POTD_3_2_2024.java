class Solution
{
   long DecimalValue(Node head)
   {
    int mod=1000000007;
    long ans=0;
    int length=0;
    Node node=head;
    StringBuilder num =new StringBuilder();
    
 	while(node!=null)
 	{   num.append(node.data);
 	    node=node.next;
 	    length++;
 	}
 	
 	int bdigit=1;
 	for(int i=length-1 ; i>-1 ; i--)
 	{
 	    ans+=bdigit*(Integer.parseInt(num.substring(i,i+1)));
 	    bdigit=(bdigit*2)%mod;
 	    ans%=mod;
 	}
 	return ans;
 	
   }
}
