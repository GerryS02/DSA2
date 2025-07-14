import java.util.Arrays;

class BubbleSort{

    public int[] bubbleSort(int[] arr){
        int n = arr.length;

        // Outer loop that goes through the array n-1 times
        for(int i=0; i<n-1; i++){

            boolean isSwap = false;  // A flag to check if a swap happened in this iteration

            // Inner loop to compare adjacent elements
            // The inner loop runs n-i-1 times to avoid re-checking the already sorted part
            for(int j=0; j<n-i-1; j++){

                // If the current element is greater than the next, swap them
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    isSwap = true;  // Indicate that a swap happened
                }
            }

            // If no swaps were made in the inner loop, the array is already sorted, so break early
            if(!isSwap) break;
        }

        // Return the sorted array
        return arr;
    }

    public static void main(String[] args){
        BubbleSort sol = new BubbleSort();

        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println(Arrays.toString(arr));

        int[] sortedArr = sol.bubbleSort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
};