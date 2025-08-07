// You are given a sorted array of integers arr and an integer target. Your task is to 
// determine how many times target appears in arr.

// Return the count of occurrences of target in the array.

class solution {
    public static int countOccurences(int[] nums, int target){
        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);


        return last-first+1;
    }

    public static int firstOccurence(int[] arr, int target){
        int ans = 0;

        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(arr[mid] == target){
                ans = mid;
                hi = mid-1; // Keep searching on the left side
            } else if(arr[mid] > target){
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return ans;
    }

    public static int lastOccurence(int[] arr, int target){
        int ans = 0;

        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;

            if(arr[mid] == target){
                ans = mid;
                lo = mid+1; // keep serching on the right side
            } else if(arr[mid] > target){
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,3,4};

        System.out.println(countOccurences(nums, 1));
    }
}
