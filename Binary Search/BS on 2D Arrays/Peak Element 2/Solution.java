// Find any element in a 2D grid that is greater than its top, bottom, left, and right 
// neighbors.

class Solution{
    public int[] findPeakGrid(int[][] mat){
        int m = mat.length; //number of rows
        int n = mat[0].length; //number of columns

        int lo = 0; //first column
        int hi = n-1; //last column

        while(lo <= hi){
            int mid = (lo+hi)/2; //mid column

            //find the row index that has the maximum value in the mid column
            int row = findRow(mat, m, mid);

            //get values of left and right neighbors (or -1 if out of bounds)
            int left = (mid-1>=0) ? mat[row][mid-1] : -1;
            int right = (mid+1<n) ? mat[row][mid+1] : -1;
            int curr = mat[row][mid]; //current element

            if(curr > left && curr > right){
                return new int[]{row,mid};
            }//if the left neighbor is greater, there must be a peak on the left side
            //beacuse the peak lie in the direction of the greater neighbor
             else if(left > curr){
                hi = mid-1;
            } //if the right neighbor is greater, there must be a peak on the right side
            else if(right > curr){
                lo = mid+1;
            }
            
        }

        return new int[]{-1,-1};
    }

    private int findRow(int[][] mat, int rows, int col) {
        int maxElement = -1;
        int rowIdx = -1;

        for(int i=0; i<rows; i++){
            if(mat[i][col] > maxElement){
                maxElement = mat[i][col];
                rowIdx = i;
            }
        }

        return rowIdx;
    }
}
