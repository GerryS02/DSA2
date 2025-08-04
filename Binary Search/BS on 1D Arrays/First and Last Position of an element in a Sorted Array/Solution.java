// Given an array of integers nums sorted in non-decreasing order, find the starting and 
// ending position of a given target value.

// If target is not found in the array, return [-1, -1].

class Solution{
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};

        int lo = 0;
        int hi = nums.length-1;

        //search for the first idx
        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] == target){
                ans[0] = mid;
                //continue search to the left
                hi = mid-1;
            } else if(nums[mid] < target){
                lo = mid+1;
            } else{
                hi = mid-1;
            }
        }

        //search for the last idx
        lo = 0;
        hi = nums.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(nums[mid] == target){
                ans[1] = mid;
                //continue search to the right
                lo = mid+1;
            } else if(nums[mid] < target){
                lo = mid+1;
            } else{
                hi = mid-1;
            }
        }

        return ans;
    }
}