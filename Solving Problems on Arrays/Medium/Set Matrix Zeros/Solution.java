// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 
// 0. You must do it in place.

public class Solution {
    public void setZeroes(int[][] matrix){
        int m = matrix.length; //number of rows
        int n = matrix[0].length; //number of columns

        //flags to track if first row or column contains any zero
        boolean row = false;
        boolean col = false;

        //check if the first column contains any zeroes
        for(int i=0; i<m; i++){
            if(matrix[i][0] == 0){ //if any element in the first column is zero
                col = true; //mark the col flag as true
            }
        }

        for(int j=0; j<n; j++){
            if(matrix[0][j] == 0){ //if any element in the first row is zero
                row = true; //mark the row flag as true
            }
        }

        // Use the first row and the first column to mark the rows and columns
        // that should be set to zero
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                //if we find a zero in the matrix
                if(matrix[i][j] == 0){ 
                    matrix[0][j] = 0; //mark the first row at column 'j' as zero
                    matrix[i][0] = 0; //mark the first column at row 'i' as zero
                }
            }
        }

        //set the rows to zero based on the marks in the first column
        for(int i=1; i<m; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //set the columns to zero based on the marks in the first row
        for(int j=1; j<n; j++){
            if(matrix[0][j] == 0){
                for(int i=1; i<m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        //finally, handle the first row if it was marked to be zero
        if(row){
            //if the row flag is true, set the entire row to 0
            for(int j=0; j<n; j++){
                matrix[0][j] = 0;
            }
        }

        if(col){
            //if the col flag is true, ste the entire first col to 0
            for(int i=0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
