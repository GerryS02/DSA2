class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start from the top-right corner of the matrix
        int row = 0;
        int col = matrix[0].length - 1;

        // Keep searching while we are within the bounds of the matrix
        while (row < matrix.length && col >= 0) {
            // If the current element equals the target, return true
            if (matrix[row][col] == target) {
                return true;
            } 
            // If the current element is less than the target, move down to the next row
            else if (matrix[row][col] < target) {
                row++;
            } 
            // If the current element is greater than the target, move left to the previous column
            else if (matrix[row][col] > target) {
                col--;
            }
        }

        // If we exit the loop, the target was not found
        return false;
    }
}
