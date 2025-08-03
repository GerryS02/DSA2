// Given a sorted array of distinct integers and a target value, return the index if the 
// target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

class Solution{
    public int searchInsert(int[] nums, int target){
        int lo = 0;
        int hi = nums.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] == target){
                return mid;
            } else if(target < nums[mid]){
                hi = mid-1;
            } else if(target > nums[mid]){
                lo = mid+1;
            }
        }

        return lo; //if target is not found, lo will be the correct insert position
    }
}