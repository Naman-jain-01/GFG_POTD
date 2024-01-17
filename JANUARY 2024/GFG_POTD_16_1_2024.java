package JANUARY;

import java.util.Arrays;

public class GFG_POTD_16_1_2024 {
    public static void main(String[] args) {
        int n=4;
        int m=10;
        System.out.println(Solution16.numberSequence(m,n));
    }
}

class Solution16{

    static int recursion(int i,int j,int n,int m)
    {
        if(j==n) return 1;
        if(i>m)  return 0;

        int choose=recursion(2*i,j+1,n,m);
        int notchoose=recursion(i+1,j,n,m);

        return choose+notchoose;
    }
    static int numberSequence(int m, int n)
    {
            return recursion(1,0,n,m);
    }
}