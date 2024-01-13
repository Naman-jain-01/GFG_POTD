package JANUARY;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class GFG_POTD_11_1_2023 {
    public static void main(String[] args) {
        String S= "149812";
        int k=3;
        System.out.println(Solution11.removeKdigits(S,k));
    }
}

class Solution11 {

    static public String removeKdigits(String S, int k) {
        if(S.length()==k) return "0";

        Stack<Character> stack=new Stack<>();
        int i=0;

        while(i<S.length())
        {
            while(k>0 && !stack.empty() && stack.peek()>S.charAt(i))
            {
                System.out.println("popped is 1st condition " + stack.peek() + " " + k);
                stack.pop();
                k--;
            }
            stack.push(S.charAt(i));
            i++;
        }

        while(k>0)
        {   System.out.println( " Popped in second condition " + stack.peek());
            stack.pop();
            k--;
        }
        StringBuilder ans=new StringBuilder();

        while (!stack.empty())
        {
            ans.append(stack.pop());
        }
        ans.reverse();
        while(ans.length()>1 &&  ans.charAt(0)=='0')
        {
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}