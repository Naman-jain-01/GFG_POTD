package February;

public class GFG_POTD_2_2_2024 {
    public static void main(String[] args) {
        String s="-123a";
        int ans=Solution2.atoi(s);
        System.out.println(ans);
    }
}

class Solution2 {
    static int atoi(String s) {
        boolean flag = true; // Assume it's a valid integer until proven otherwise

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') continue;
            else if ((int) s.charAt(i) <= 57 && (int) s.charAt(i) >= 48) continue;
            else {
                flag = false;
                break;
            }
        }

        if (flag) {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                // Handle the case where the string cannot be parsed to an integer
                return -1;
            }
        } else {
            // String contains invalid characters
            return -1;
        }
    }
}
