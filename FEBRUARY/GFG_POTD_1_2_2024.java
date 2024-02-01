class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String str) {
       str=str.toLowerCase();
       
       for(int i=0;i<26;++i)
       {
           char curr=(char)('a'+i);
           if(str.indexOf(curr)==-1) return false;
       }
       return true;
    }
}
