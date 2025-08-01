class Solution {
    public int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(target == arr[mid]){
                return mid;
            } else if(arr[lo] <= arr[mid]){ //left side is sorted
                if(target >= arr[lo] && target < arr[mid]){
                    hi = mid-1;
                } else{
                    lo = mid+1;
                }
            } else if(arr[mid] <= arr[hi]){ //right side is sorted
                if(target > arr[mid] && target <= arr[hi]){
                    lo = mid+1;
                } else{
                    hi = mid-1;
                }
            }
        }

        return -1;
    }
}