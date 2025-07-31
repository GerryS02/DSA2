// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].

public class Solution {
    public int reversePairs(int[] nums){

        return mergeSort(nums, 0, nums.length-1);
    }

    public int countPairs(int[] nums, int st, int mid, int ed){
        int count = 0;
        int right = mid+1;

        for(int i=st; i<=mid; i++){
            while(right<=ed && (long) nums[i] > 2L* nums[right]){
                right++;
            }

            count += (right -(mid+1));
        }

        return count;
    }

    public int mergeSort(int[] arr, int st, int ed){
        int count = 0;

        if(st >= ed) return count;

        int mid = (st+ed)/2;

        count += mergeSort(arr, st, mid);
        count += mergeSort(arr, mid+1, ed);

        count+= countPairs(arr, st, mid, ed);

        mergeArray(arr, st, mid, ed);

        return count;
    }

    public void mergeArray(int[] arr, int st, int mid, int ed){
        int[] temp = new int[ed-st+1];
        
        int i = st;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ed){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            } else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i]++;
        }

        while(j <= ed){
            temp[k++] = arr[j++];
        }

        for(int p=0, q=st; p<temp.length; p++, q++){
            arr[q] = temp[p];
        }
    }
}
