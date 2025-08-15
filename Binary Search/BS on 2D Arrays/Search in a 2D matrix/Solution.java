class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Find the row where the target might be
        int lo = 0;                      // first row index
        int hi = matrix.length - 1;      // last row index
        int row = -1;                    // will store the row index if found

        while (lo <= hi) {
            int mid = (lo + hi) / 2;     // middle row index

            // Check if the target is between the first and last element of this row
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                row = mid;               // found the possible row
                break;                   // stop searching rows
            } 
            // If target is smaller than the first element of mid row -> search above
            else if (target < matrix[mid][0]) {
                hi = mid - 1;
            } 
            // If target is larger than the first element of mid row -> search below
            else {
                lo = mid + 1;
            }
        }

        // If no row found, target is not in matrix
        if (row == -1) return false;

        // Search within the found row using binary search
        lo = 0;                          // first column index
        hi = matrix[0].length - 1;       // last column index

        while (lo <= hi) {
            int mid = (lo + hi) / 2;     // middle column index

            if (matrix[row][mid] == target) {
                return true;             // found target
            } 
            // If target is smaller, search left
            else if (target < matrix[row][mid]) {
                hi = mid - 1;
            } 
            // If target is bigger, search right
            else {
                lo = mid + 1;
            }
        }

        // Target not found in the row
        return false;
    }
}
