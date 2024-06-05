class Solution {
    String binaryNextNumber(String s) {
     
     int l=s.length();
     StringBuilder ans = new StringBuilder();
     
     char[] charArray = s.toCharArray();
     
       int i;
        for(i=l-1 ; i>=0 ; i--)
        {
            if(charArray[i]=='1') charArray[i]='0';
            else 
            {charArray[i]='1';
            break;}
        }
        
     if (i < 0) {
            ans.append('1');
            i = 0;
        } else {
            i = 0;
            while (i < l && charArray[i] == '0') i++;
        }


           
    ans.append(new String(charArray, i, l - i));
     return ans.toString();
}
   
}
