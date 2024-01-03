package JANUARY;

import java.util.HashMap;

public class GFG_POTD_3_1_2024 {
    public static void main(String[] args) {
        String s ="12110111";
        System.out.println(Solution3.smallestSubstring(s));
    }
}
class Solution3 {
    public static int smallestSubstring(String S) {
        if (!S.contains("0") || !S.contains("1") || !S.contains("2")) return -1;

        int one = 0;
        int zero = 0;
        int two = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '1') one++;
            if (c == '0') zero++;
            if (c == '2') two++;

            while (one >= 1 && zero >= 1 && two >= 1) {
                int value=i - start + 1;
                System.out.println("Value is "+value);
                minLength = Math.min(minLength, value);

                char startChar = S.charAt(start);
                if (startChar == '1') one--;
                if (startChar == '0') zero--;
                if (startChar == '2') two--;

                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
