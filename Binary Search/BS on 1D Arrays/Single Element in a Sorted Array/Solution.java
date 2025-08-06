// You are given a sorted array consisting of only integers where every element appears exactly
// twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

class Solution{
    public int singleNonDuplicate(int[] arr){
        int n = arr.length;

        //if the array contains only one element, return it directly
        if(n == 1) return arr[0];

        //if the first element is different from the second, the first element is the single one
        if(arr[0] != arr[1]) return arr[0];

        //if the last element is different from the second last, the last element is the single one
        if(arr[n-2] != arr[n-1]) return arr[n-1];

        int lo = 0;
        int hi = n-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            //if the middle element is different from both its neighbors, it is the single number
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return mid;
            }
            //if the element to the left of mid is equal to arr[mid], the single element is on the right
            else if(arr[mid] == arr[mid-1]){
                //number of elemets from lo to mid
                int leftCount = mid-lo+1;

                //if the leftCount is even, the single element must be in the right part
                if(leftCount % 2 == 0){
                    lo = mid+1;
                } else{
                    hi = mid-2;
                }
            } 
            //if the element to the right of mid is equal to arr[mid], the single element is on the left
            else if(arr[mid] == arr[mid+1]){
                //number of elements from mid to hi
                int rightCount = hi-mid+1;

                //if rightCount is even, the single element must be in the left part
                if(rightCount % 2 == 0){
                    hi = mid-1;
                } else{
                    lo = mid+2;
                }
            }
        }

        return -1;
    }
}