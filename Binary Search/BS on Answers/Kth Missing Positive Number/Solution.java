// Given an array arr of positive integers sorted in a strictly increasing order, and an 
// integer k.

// Return the kth positive integer that is missing from this array.


class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            int missing = arr[mid] - (mid+1); //number of missing elements up to arr[mid]

            //if missing numbers so far are less than k, we need to look to the right
            if(missing < k){
                lo = mid+1;
            } else{
                hi = mid-1; //if missing numbers are >= k, look to the left
            }
        }

        // hi will end up at the last index before the kth missing number
        // Formula: starting k + number of elements before it (hi+1)
        return k+hi+1;
    }
}
