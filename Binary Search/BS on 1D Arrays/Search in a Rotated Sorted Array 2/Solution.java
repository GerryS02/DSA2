class Solution {
    public boolean search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(target == arr[mid]){
                return true;
            } //skip duplicates
            if(arr[lo] == arr[mid] && arr[hi] == arr[mid]){
                lo++;
                hi--;
            } //left side sorted
            else if(arr[lo] <= arr[mid]){
                if(target >= arr[lo] && target < arr[mid]){
                    hi = mid-1;
                } else{
                    lo = mid+1;
                }
            } //right side is sorted
            else if(target > arr[mid] && target <= arr[hi]){
                lo = mid+1;
            } else{
                hi = mid-1;
            }
        }

        return false;
    }
}