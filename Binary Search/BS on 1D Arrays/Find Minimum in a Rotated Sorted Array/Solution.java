class Solution{
    public int findMin(int[] arr){
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            //array is sorted not rotated, the minimum is the first element
            if(arr[lo] <= arr[hi]) return arr[0];

            //if the middle element is greater than the next element, then mid+1 is the minimum
            if(arr[mid] > arr[mid+1]){
                return arr[mid+1];
            }
            //if the middle element is less than the previous element, then mid is the minimum
            else if(arr[mid] < arr[mid-1]){
                return arr[mid];
            }
            //if the left part of the array is sorted, search in the right part
            else if(arr[lo] <= arr[mid]){
                lo = mid+1;
            } 
            //if the right part of the array is sorted, search in the left part
            else if(arr[mid] <= arr[hi]){
                hi = mid-1;
            }
        }

        return -1;
    }
}