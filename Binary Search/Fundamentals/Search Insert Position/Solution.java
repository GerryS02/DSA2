class Solution {
    public int searchInsert(int[] nums, int target) {
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

        return lo;
    }
}