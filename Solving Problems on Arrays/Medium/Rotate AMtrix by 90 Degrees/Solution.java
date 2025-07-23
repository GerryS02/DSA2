// Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.

// The rotation must be done in place, meaning the input 2D matrix must be modified directly.

public class Solution {
     public void rotate(int[][] matrix){
        int n = matrix.length;

        //transpose the matrix (flip over the diagonal)
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row (to get 90-degree rotation)
        for(int i=0; i<n; i++){
            int left = 0;
            int right = matrix[i].length -1;

            //swap the elements at the start and end of the row, moving inward
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
     }
}
