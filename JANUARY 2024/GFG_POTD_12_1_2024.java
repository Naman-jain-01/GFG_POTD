package JANUARY;

import java.util.Queue;
import java.util.Stack;

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<k;i++)
        {
            st.push(q.poll());
        }

        while(!st.empty())
        {
            q.offer(st.pop());
        }
        int n=q.size();
        for(int i=0;i<n-k;i++)
        {
            q.offer(q.poll());
        }
        return q;
    }
}
