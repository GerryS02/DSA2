// Given an array nums of n integers, where nums[i] represents the number of pages in the i-th
// book, and an integer m representing the number of students, allocate all the books to the 
// students so that each student gets at least one book, each book is allocated to only one 
// student, and the allocation is contiguous.

// Allocate the books to m students in such a way that the maximum number of pages assigned to 
// a student is minimized. If the allocation of books is not possible, return -1.

class Solution {
    public int findPages(int[] arr, int k){

        // If the number of students is more than the number of books, return -1
        // It's not possible to allocate books to more students than books
        if(k > arr.length) return -1;

        int sum = 0;
        int max = 0;

         // Calculate the total number of pages and find the maximum number of pages in any book
        for(int val : arr){
            sum += val;
            max = Math.max(max, val);
        }

        if(arr.length == k) return max; 

        // Lowest possible value for maximum pages is the max single book pages
        int lo = max;
        // Highest possible value for maximum pages is the total sum of pages
        int hi = sum;

        int ans = 0;

        // Binary search to find the optimal maximum pages
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

             // If it's possible to allocate books with 'mid' as the maximum pages for any student
            if(isPossible(arr, mid, k)){
                ans = mid; // Store the result
                hi  = mid - 1; // Try for a smaller maximum number of pages
            } else{
                lo = mid + 1;  // We need to increase the maximum number of pages
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int mid, int k){
        int st = 1; // start with 1 student
        int sum = 0; // store the sum of pages assigned to a student

        for(int i=0; i<arr.length; i++){
            sum += arr[i]; // assign books to student

            // If the total pages for the current student exceeds 'mid',
            // assign a new student (start a new partition)
            if(sum > mid){
                st++;
                sum = arr[i]; // Start with the current book for the new student
            }
        }

        return st <= k; // If we can allocate books to at most 'k' students, return true
    }
}
