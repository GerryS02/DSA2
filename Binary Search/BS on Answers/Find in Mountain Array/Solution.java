/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int lo = 0;
        int hi = n-1;

        //step 1: find the peak index
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                lo = mid+1;
            } else{
                hi = mid;
            }
        }

        int peak = lo;  // peak index

        //step 2: binary search from 0 to peak
        lo = 0;
        hi = peak;

        while(lo < hi){
            int mid = lo + (hi-lo)/2;

            if(mountainArr.get(mid) == target){
                return mid;
            } else if(mountainArr.get(mid) < target){
                lo = mid-1;
            } else{
                hi = mid+1;
            }
        }

        //step 3: binary search from peak+1 to n-1
        lo = peak+1;
        hi = n-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(mountainArr.get(mid) == target){
                return mid;
            } else if(mountainArr.get(mid) < target){
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return -1;
    }
}