class Solution
{
    public int isPossible(int[][] paths)
    {
       boolean flag = true;
       if (paths.length == 1) {
                return 1;
            }
            
             for (int i = 0; i < paths.length; i++)
             {   
                 int numones=0;
                 for (int j = 0; j < paths[i].length; j++) 
                 {
                   int valid=paths[i][j] == 1 ? 1 : 0;
                   numones += valid ;
                 }
                 if((numones&1)!=0 || numones==0) flag =false;
             }
              return (flag)?1:0;
    }
   
}
