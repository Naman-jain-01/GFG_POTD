package JANUARY;
import java.util.*;

public class GFG_POTD_25_1_2024
{
    public static void main(String[] args) {
        int n=1033;
        int m=1055;
        System.out.println(Solution25.solve(n,m));
    }
}

class Solution25 {
    static boolean make_sieve = true;
    static int n=9999;
    static boolean[] prime = new boolean[n+1];
        static void sieve() {
            for (int i = 0; i <= n; i++) prime[i] = true;

            for (int p = 2; p * p <= n; p++) {
                if (prime[p]) {
                    for (int i = p * p; i <= n; i += p)
                        prime[i] = false;
                }
            }
        }

    static int bfs(int num1,int destination){
        int[] dp =new int[10001]; // array to store the shortest distance from num1 to destination
        Arrays.fill(dp,-1); // set all elements in dp array to -1
        int[] vis=new int[10001]; // array to track visited nodes
        Queue<Integer> q = new LinkedList<>(); // queue for BFS traversal


        q.add(num1); // add num1 to queue
        dp[num1]=0; // set the distance of num1 from itself to 0
        vis[num1]=0; // mark num1 as visited


        while(!q.isEmpty()){

            int current=q.poll(); // get the current node from queue
            if(vis[current]==1) continue; // if current node is already visited, continue to next iteration

            vis[current]=1; // mark current node as visited



            String s=Integer.toString(current); // convert current number to string
            for(int i=0;i<4;i++){
                for(char ch='0';ch<='9';ch++){
                    if(ch==s.charAt(i)||(ch=='0'&&i==0)) continue;// if the digit in the string is equal to current digit or it is 0 at first position, continue to next iteration


                    String nextnumstring=s;
                    nextnumstring=s.substring(0,i)+ch+s.substring(i+1); // replace digit at index i with ch character in the string
                    int nxtnum=Integer.parseInt(nextnumstring); // convert the new string to integer

                    if((prime[nxtnum]) && (dp[nxtnum] == -1)){
                        // if the new number is prime and it is not visited yet
                        dp[nxtnum]=1+dp[current]; // set the shortest distance to the new number
                        q.add(nxtnum); // add the new number to queue for traversal
                      System.out.println(nxtnum);
                    }
                }
            }

        }
        return dp[destination]; // return the shortest distance from the num1 to destination node
    }

    static int solve(int num1, int num2) {
        if (make_sieve) {
            sieve();
            make_sieve = false;
        }

        return bfs(num1,num2);
    }
}

