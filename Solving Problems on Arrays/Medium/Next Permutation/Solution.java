
public class Solution {
    public void nextPermutation(int[] arr){
        //find the pivot
        int pivot = -1;
        int n = arr.length;

        //start from the second last element and move leftwards
        for(int i=n-2; i>=0; i--){
            //if the current element is less than the next element, it's the pivot
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }

        //if no pivot is found, the array is in descending order, so just reverse it
        if(pivot == -1){
            reverse(arr, 0, n-1);
        }

        //find the element larger than the pivot and swap them
        for(int i=n-1; i>pivot; i--){
            if(arr[i] > arr[pivot]){
                swap(arr, i, pivot);
                break;
            }
        }

        //reverse the part of the array after the pivot to get the next smallest permutation
        reverse(arr, pivot+1, n-1);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start ++;
            end--;
        }
    }
}
