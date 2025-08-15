// Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in 
// ascending order, find the index of the row with the maximum number of ones.

// If two rows have the same number of ones, consider the one with a smaller index. If no 1 
// exists in the matrix, return -1.

class Solution{
    public int rowWithMax1s(int[][] mat){
        int max1s = 0; //store maximum number of 1's found so far
        int row = -1; //store the index of the row with max 1's

        for(int i=0; i<mat.length; i++){
            int count = binarySearch(mat, i); //number of 1's in ith row

            if(count > max1s){
                max1s = count;
                row = i;
            }
        }

        return row;
    }

    public int binarySearch(int[][] mat, int row){
        int lo = 0; //leftmost column index
        int hi = mat[0].length-1; //rightmost column index

        int firstIdx = mat[0].length; //store the index of the first 1 found

        while(lo <= hi){
            int mid = (lo+hi)/2; //middle column index

            if(mat[row][mid] == 1){
                //found a 1, but we need the first one, so move left
                firstIdx = mid;
                hi = mid-1;
            } //found a 0, move right to search for the first 1
            else{
                lo = mid+1;
            }
        }

        //number of 1's = total columns - index of first 1
        int count = mat[0].length - firstIdx;

        return count;
    }
}