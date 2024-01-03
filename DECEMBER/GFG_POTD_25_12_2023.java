


class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        if(matrix.length==1) return matrix[0][0];

        int det=0;
        for(int i=0;i<n;i++)
        {
            int sign=(int)Math.pow(-1,i);
            int[][] cof=getCof(matrix,0,i,n);
            det=det+sign*matrix[0][i]*determinantOfMatrix(cof,n-1);
        }
        return det;
    }

    static int[][] getCof(int[][] matrix,int rowIgnore,int colIgnore,int n)
    {
        int[][] cof=new int[n-1][n-1];

        for(int i=0,new_row=0;i<n;i++)
        {
            if(i!=rowIgnore) {
                for (int j = 0, new_col = 0; j < n; j++) {
                    if (j != colIgnore) {
                        cof[new_row][new_col] = matrix[i][j];
                        new_col++;
                    }
                }
                new_row++;
            }
        }
        return cof;
    }
}

